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
        async public Task<string> Add(double[] start, double[] end)
        {
            await GetClosestStation(start[0], end[0]);
            return await GetPath(start, end);
        }

        async private Task<string> GetClosestStation(double longitude, double latitude)
        {
            string url = "https://api.jcdecaux.com/vls/v1/stations?apiKey=105a67e972bd8e364d7f4da5301dbaf4f314db90";
            HttpResponseMessage response = await client.GetAsync(url);
            Console.WriteLine(response.StatusCode.ToString());
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();
            List<StationInfo> stations = JsonConvert.DeserializeObject<List<StationInfo>>(responseBody);
            Console.WriteLine(stations[0].Name);
            StationInfo firstStation = stations[0];
            // Filter stations based on non-null sum of availabilities
            stations = stations.Where(s => s.totalStands != null && s.totalStands.Availabilities != null && s.totalStands.Availabilities.Bikes != null && s.totalStands.Availabilities.Stands != null).ToList();

            // Calculate distances and find the closest station
            StationInfo closestStation = null;
            double minDistance = double.MaxValue;

            foreach (var station in stations)
            {
                double distance = CalculateDistance(latitude, longitude, station.Position.Latitude, station.Position.Longitude);

                if (distance < minDistance)
                {
                    minDistance = distance;
                    closestStation = station;
                }
            }
            Console.WriteLine(closestStation.ToString());

//            return closestStation;
            return "bruh";
        }
        static double CalculateDistance(double lat1, double lon1, double lat2, double lon2)
        {
            return Math.Sqrt(Math.Pow(lat2 - lat1, 2) + Math.Pow(lon2 - lon1, 2));
        }

        async private Task<string> GetPath(double[] coord1, double[] coord2)
        {
            string url = $"https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&start={coord1[0]},{coord1[1]}&end={coord2[0]},{coord2[1]}";
            HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();
            
            JObject responseJson = JObject.Parse(responseBody);
            string geometryType = responseJson["features"][0]["geometry"].ToString();
            return geometryType;

        }
    }

    public class Availabilities
    {
        public int? Bikes { get; set; }
        public int? Stands { get; set; }
    }

    public class Stands
    {
        public Availabilities Availabilities { get; set; }
        public int Capacity { get; set; }
    }

    public class StationInfo
    {
        public int Number { get; set; }
        public string ContractName { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        public Position Position { get; set; }
        public bool Banking { get; set; }
        public bool Bonus { get; set; }
        public string Status { get; set; }
        public DateTime LastUpdate { get; set; }
        public bool Connected { get; set; }
        public bool Overflow { get; set; }
        public object Shape { get; set; }
        public Stands totalStands { get; set; }
        public Stands mainStands { get; set; }
        public object OverflowStands { get; set; }
    }

    public class Position
    {
        public double Latitude { get; set; }
        public double Longitude { get; set; }
    }

}
