using System;
using System.Linq;
using System.Threading.Tasks;
using System.Runtime.Caching;
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
                string url = "https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&text=" + address + "&boundary.country=FR&layers=locality,address";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();
                Console.WriteLine("[GetAddressInfo] Call to api.openrouteservice.org/geocode/" + address);

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

        public async Task<string> GetRouteInfo(double startLat, double startLng, double endLat, double endLng, string pathType)
        {
            string cacheKey = $"{startLng},{startLat};{endLng},{endLat};{pathType}";
            string cachedRoute = this.routeCache[cacheKey] as string;
            if (cachedRoute == null)
            {
                string url = $"https://api.openrouteservice.org/v2/directions/{pathType}?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&start={startLng},{startLat}&end={endLng},{endLat}";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();
                Console.WriteLine($"[GetRouteInfo] Call to api.openrouteservice.org/directions/{pathType}&start={startLng},{startLat}&end={endLng},{endLat}");

                string responseBody = await response.Content.ReadAsStringAsync();
                CacheItem value = new CacheItem(cacheKey, responseBody);
                routeCache.Add(value, policy);
                return responseBody;
            }
            return cachedRoute;
        }

        public async Task<string> GetStationInfo()
        {
            string cacheKey = "allStations";
            string cachedInfo = stationCache[cacheKey] as string;
            if (cachedInfo == null)
            {
                string url = "https://api.jcdecaux.com/vls/v1/stations?apiKey=105a67e972bd8e364d7f4da5301dbaf4f314db90";
                HttpResponseMessage response = await client.GetAsync(url);
                response.EnsureSuccessStatusCode();
                Console.WriteLine("[GetStationInfo] Call to api.jcdecaux.com/v1/stations");

                string responseBody = await response.Content.ReadAsStringAsync();
                CacheItem value = new CacheItem(cacheKey, responseBody);
                routeCache.Add(value, policy);
                return responseBody;
            }
            return cachedInfo;
        }
    }
}