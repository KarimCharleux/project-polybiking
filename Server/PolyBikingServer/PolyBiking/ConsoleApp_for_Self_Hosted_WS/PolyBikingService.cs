using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System.Runtime.Serialization;


namespace PolyBiking
{
    class PolyBikingService : IPolyBikingService
    {
        static readonly HttpClient client = new HttpClient();

        // Main function of the service, compute the best path between two addresses
        async public Task<BikingResponse> ComputeTrip(string addressOrigin, string addressDestination)
        {
            BikingResponse responce = new BikingResponse();
            Position origin = await getPositionFromAddress(addressOrigin);
            Position destination = await getPositionFromAddress(addressDestination);

            StationInfo[] stations = await GetClosestStation(origin, destination);
            List<Path> allPaths = new List<Path>();

            // Get the foot and bike path between, the first option is to take a bike
            Path firstFootPath = await GetPath(origin, stations[0].Position, PathType.footPath);
            Path bikePath = await GetPath(stations[0].Position, stations[1].Position, PathType.bikePath);
            Path secondFootPath = await GetPath(stations[1].Position, destination, PathType.footPath);

            // Check if full foot path is a better option than bike 
            Path fullFootPath = await GetPath(origin, destination, PathType.footPath);

            // Compare and select the best path
            List<Path> selectedPaths = SelectBestPath(firstFootPath, bikePath, secondFootPath, fullFootPath);

            // Create the responce object
            return CreateBikingResponse(selectedPaths);
        }

        // Method to get the position from an string address 
        async private Task<Position> getPositionFromAddress(string address)
        {
            string url = "https://api.openrouteservice.org/geocode/autocomplete?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&text=" + address + "&boundary.country=FR&layers=locality,address";
            HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();
            JObject responseJson = JObject.Parse(responseBody);

            Position positionResult = new Position();
            if (responseJson["features"].Count() > 0)
            {
                positionResult.Lat = responseJson["features"][0]["geometry"]["coordinates"][1].Value<double>();
                positionResult.Lng = responseJson["features"][0]["geometry"]["coordinates"][0].Value<double>();
            }
            else
            {
                throw new Exception("No position found for this address" + address);
            }

            return positionResult;
        }

        // Method to get the closest station from two positions
        async private Task<StationInfo[]> GetClosestStation(Position origin, Position destination)
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
            catch (Exception e)
            {
                Console.WriteLine(e.Message); return null;
            }

            stations = stations.Where(s => s.AvailableBikes > 0).ToList();

            double minDistance = double.MaxValue;
            foreach (var station in stations)
            {
                double distance = CalculateDistance(origin.Lat, origin.Lng, station.Position.Lat, station.Position.Lng);

                if (distance < minDistance)
                {
                    minDistance = distance;
                    departingStation = station;
                }
            }
            minDistance = double.MaxValue;
            foreach (var station in stations)
            {
                double distance = CalculateDistance(destination.Lat, destination.Lng, station.Position.Lat, station.Position.Lng);

                if (station.ContractName == departingStation.ContractName && distance < minDistance)
                {
                    minDistance = distance;
                    arrivalStation = station;
                }
            }

            StationInfo[] funcResponse = new StationInfo[] { departingStation, arrivalStation };
            return funcResponse;
        }

        // Method to calculate the distance between two positions
        static double CalculateDistance(double lat1, double lon1, double lat2, double lon2)
        {
            return Math.Sqrt(Math.Pow(lat2 - lat1, 2) + Math.Pow(lon2 - lon1, 2));
        }

        // Method to get the (Foot or Cycle) path between two positions
        async private Task<Path> GetPath(Position start, Position end, PathType pathType)
        {
            string url = $"https://api.openrouteservice.org/v2/directions/{pathType.GetString()}?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&start={start.Lng},{start.Lat}&end={end.Lng},{end.Lat}";
            HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();

            JObject responseJson = JObject.Parse(responseBody);

            if (responseJson["features"].Count() == 0)
            {
                return null;
            }
            string geometryCoords = responseJson["features"][0]["geometry"]["coordinates"].ToString();

            List<List<double>> coordinatesList = JsonConvert.DeserializeObject<List<List<double>>>(geometryCoords);
            List<Position> positions = coordinatesList.Select(coord => new Position(coord[1], coord[0])).ToList();

            Path myPath = new Path(positions);
            myPath.distance = responseJson["features"][0]["properties"]["summary"]["distance"].Value<double>();
            myPath.duration = responseJson["features"][0]["properties"]["summary"]["duration"].Value<double>();

            string stepsList = responseJson["features"][0]["properties"]["segments"][0]["steps"].ToString();
            myPath.steps = JsonConvert.DeserializeObject<List<Step>>(stepsList);
            myPath.type = pathType;
            return myPath;
        }

        // Method to select the best path between the different options
        private List<Path> SelectBestPath(Path firstFootPath, Path bikePath, Path secondFootPath, Path fullFootPath)
        {
            var allPaths = new List<Path> { firstFootPath, bikePath, secondFootPath };
            double combinedDuration = allPaths.Sum(p => p?.duration ?? 0);

            if (fullFootPath != null && fullFootPath.duration < combinedDuration)
            {
                return new List<Path> { fullFootPath };
            }
            else
            {
                return allPaths.Where(p => p != null).ToList();
            }
        }

        // Method to create the responce object
        private BikingResponse CreateBikingResponse(List<Path> paths)
        {
            return new BikingResponse
            {
                Paths = paths,
                TotalDistance = paths.Sum(p => p.distance),
                TotalDuration = paths.Sum(p => p.duration)
            };
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

        public Position(double lat, double lng)
        {
            Lat = lat;
            Lng = lng;
        }

        public Position()
        {
        }
    }

    public class Step
    {
        [JsonProperty("instruction")]
        public string Instruction { get; set; }

        [JsonProperty("distance")]
        public double Distance { get; set; }

        [JsonProperty("duration")]
        public double Duration { get; set; }

        [JsonProperty("type")]
        public int Type { get; set; } 

        [JsonProperty("name")]
        public string Name { get; set; }

        [JsonProperty("way_points")]
        public List<int> WayPoints { get; set; }
    }

    public class BikingResponse
    {
        public List<Path> Paths;
        public List<Step> steps;
        public double TotalDistance;
        public double TotalDuration;
    }

    [DataContract]
    public class Path
    {
        [DataMember]
        public PathType type;

        [DataMember]
        public List<Position> coordinates;

        [DataMember]
        public double distance;

        [DataMember]
        public double duration;

        [DataMember]
        public List<Step> steps;

        public Path(List<Position> coordinates)
        {
            this.coordinates = coordinates;
        }
    }

    public enum PathType
    {
        footPath,
        bikePath
    }

    public static class PathTypeExtensions
    {
        public static string GetString(this PathType pathType)
        {
            switch (pathType)
            {
                case PathType.footPath:
                    return "foot-walking";
                case PathType.bikePath:
                    return "cycling-regular";
                default:
                    return "foot-walking";
            }
        }
    }
}
