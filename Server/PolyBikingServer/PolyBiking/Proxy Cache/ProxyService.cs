using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Caching;
using Newtonsoft.Json;
using System.Net.Http;
using Newtonsoft.Json.Linq;

namespace Proxy_Cache_Server
{
    internal class ProxyService : IProxyService
    {
        static readonly HttpClient client = new HttpClient();
        ObjectCache addressCache = MemoryCache.Default;
        ObjectCache routeCache = MemoryCache.Default;
        ObjectCache stationCache = MemoryCache.Default;
        CacheItemPolicy policy = new CacheItemPolicy { AbsoluteExpiration = DateTimeOffset.Now.AddMinutes(10) };

        public async Task<string> GetAddressInfo(string address)
        {
            string cachedAddress = this.addressCache[address] as string;
            if (cachedAddress == null)
            {
            string url = "https://api.openrouteservice.org/geocode/autocomplete?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&text=" + address + "&boundary.country=FR&layers=locality,address";
            HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();
            JObject responseJson = JObject.Parse(responseBody);
            string newResponseBody;
            if (responseJson["features"].Count() > 0)
                {
                newResponseBody = responseJson["features"][0]["geometry"]["coordinates"].ToString();
                }
                else
                {
                    newResponseBody = responseBody;
                }
            CacheItem value = new CacheItem(address, newResponseBody);
            addressCache.Add(value, policy);
            return newResponseBody;
            }
            return cachedAddress;
        }

        public async Task<string> GetRouteInfo(Position start, Position end)
        {
            string cacheKey = $"{start.Lng},{start.Lat};{end.Lng},{end.Lat}";
            string cachedRoute = this.routeCache[cacheKey] as string;
            if(cachedRoute == null)
            {
            string url = $"https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&start={start.Lng},{start.Lat}&end={end.Lng},{end.Lat}";
            HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();
            CacheItem value = new CacheItem(cacheKey, responseBody);
            routeCache.Add(value, policy);
            return responseBody;
            }
            return cachedRoute;
        }

        public async Task<string> GetStationInfo()
        {
            string cachedInfo = this.stationCache["elstazion"] as string;
            if(cachedInfo == null)
            {
                string url = "https://api.jcdecaux.com/vls/v1/stations?apiKey=105a67e972bd8e364d7f4da5301dbaf4f314db90";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();
                string responseBody = await response.Content.ReadAsStringAsync(); 
                string newResponseBody;
            List<StationInfo> stations;
            try
            {
                stations = JsonConvert.DeserializeObject<List<StationInfo>>(responseBody);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.Message); return null;
            }
            stations = stations.Where(s => s.AvailableBikes > 0).ToList();
                newResponseBody = JsonConvert.SerializeObject(stations);
                CacheItem value = new CacheItem("elstazion", newResponseBody);
                routeCache.Add(value, policy);
                return newResponseBody;
            }
            return cachedInfo;
        }
    }
    public class Position
    {
        [JsonProperty("lat")]
        public double Lat { get; set; }

        [JsonProperty("lng")]
        public double Lng { get; set; }

        public Position(double lat, double lng)
        {
            Lat = lat;
            Lng = lng;
        }

        public Position()
        {
        }
    }
    public class StationInfo
    {
        [JsonProperty("number")]
        public int Number { get; set; }

        [JsonProperty("contract_name")]
        public string ContractName { get; set; }

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("address")]
        public string Address { get; set; }

        [JsonProperty("position")]
        public Position Position { get; set; }

        [JsonProperty("banking")]
        public bool Banking { get; set; }

        [JsonProperty("bonus")]
        public bool Bonus { get; set; }

        [JsonProperty("bike_stands")]
        public int BikeStands { get; set; }

        [JsonProperty("available_bike_stands")]
        public int AvailableBikeStands { get; set; }

        [JsonProperty("available_bikes")]
        public int AvailableBikes { get; set; }

        [JsonProperty("status")]
        public string Status { get; set; }

        [JsonProperty("last_update")]
        public long? LastUpdate { get; set; }
    }

}
