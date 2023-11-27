using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace ConsoleApp_for_Self_Hosted_WS
{
    class PolyBikingService : IPolyBikingService
    {
        static readonly HttpClient client = new HttpClient();
        async public Task<Path[]> Add(double[] start, double[] end)
        {
            StationInfo[] stations = await GetClosestStation(start, end);
            Console.WriteLine(stations[0].Name);
            Console.WriteLine(stations[1].Name);
            Path[] totalPath = new Path[3];

            Path bufferPath = await GetPath(start, new double[] {stations[0].Position.Lng , stations[0].Position.Lat });
            bufferPath.type = "footPath";
            totalPath.Append(bufferPath);
            Console.WriteLine("test");
            
            bufferPath = await GetPath(new double[] { stations[0].Position.Lng, stations[0].Position.Lat }, new double[] {stations[1].Position.Lng , stations[1].Position.Lat });
            bufferPath.type = "bikePath";
            totalPath.Append(bufferPath);
            Console.WriteLine("test");

            bufferPath = await GetPath(new double[] {stations[0].Position.Lng , stations[0].Position.Lat }, end);
            bufferPath.type = "footPath";
            totalPath.Append(bufferPath);
            Console.WriteLine("test");

            return totalPath;
        }

        async private Task<StationInfo[]> GetClosestStation(double[] start, double[] end)
        {
            StationInfo departingStation = null;
            StationInfo arrivalStation = null;
            string url = "https://api.jcdecaux.com/vls/v1/stations?apiKey=105a67e972bd8e364d7f4da5301dbaf4f314db90";
            HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();
            List<StationInfo> stations;

            try
            {
            stations = JsonConvert.DeserializeObject<List<StationInfo>>(responseBody);
            }
            catch (Exception e){ 
                Console.WriteLine(e.Message); return null;
            }

            stations = stations.Where(s => s.AvailableBikes > 0).ToList();

            double minDistance = double.MaxValue;
            foreach (var station in stations)
            {
                double distance = CalculateDistance(start[1], start[0], station.Position.Lat, station.Position.Lng);

                if (distance < minDistance)
                {
                    minDistance = distance;
                    departingStation = station;
                }
            }
            minDistance = double.MaxValue;
            foreach (var station in stations)
            {
                double distance = CalculateDistance(end[1], end[0], station.Position.Lat, station.Position.Lng);

                if (distance < minDistance)
                {
                    minDistance = distance;
                    arrivalStation = station;
                }
            }

            StationInfo[] funcResponse = new StationInfo[] { departingStation, arrivalStation };
            return funcResponse;
        }
        static double CalculateDistance(double lat1, double lon1, double lat2, double lon2)
        {
            return Math.Sqrt(Math.Pow(lat2 - lat1, 2) + Math.Pow(lon2 - lon1, 2));
        }

        async private Task<Path> GetPath(double[] coord1, double[] coord2)
        {
            string url = $"https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&start={coord1[0]},{coord1[1]}&end={coord2[0]},{coord2[1]}";
            HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();
            
            JObject responseJson = JObject.Parse(responseBody);

            string geometryCoords = responseJson["features"][0]["geometry"]["coordinates"].ToString();
            List<List<double>> coordinatesList = JsonConvert.DeserializeObject<List<List<double>>>(geometryCoords);
            List<Position> positions = coordinatesList.Select(coord => new Position { Lat = coord[1], Lng = coord[0] }).ToList();
            Path myPath = new Path();
            myPath.coordinates = positions;

            return myPath;
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

    public class Position
    {
        [JsonProperty("lat")]
        public double Lat { get; set; }

        [JsonProperty("lng")]
        public double Lng { get; set; }
    }

    public class Path
    {
        public string type;
        public List<Position> coordinates;
    }
}
