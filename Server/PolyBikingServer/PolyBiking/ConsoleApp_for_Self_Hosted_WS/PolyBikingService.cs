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
        async public Task<Path[]> ComputeTrip(string addressOrigin, string addressDestination)
        {
            Position origin = await getPositionFromAddress(addressOrigin);
            Position destination = await getPositionFromAddress(addressDestination);

            StationInfo[] stations = await GetClosestStation(origin, destination);

            Path firstFootPath = await GetPath(origin, stations[0].Position);
            firstFootPath.type = "footPath";

            Path bikePath = await GetPath(stations[0].Position, stations[1].Position);
            bikePath.type = "bikePath";

            Path secondFootPath = await GetPath(stations[1].Position, destination);
            secondFootPath.type = "footPath";

            return new Path[] { firstFootPath, bikePath, secondFootPath };
        }

        private Task<Path> GetPath(Position origin, double[] doubles)
        {
            throw new NotImplementedException();
        }

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

        static double CalculateDistance(double lat1, double lon1, double lat2, double lon2)
        {
            return Math.Sqrt(Math.Pow(lat2 - lat1, 2) + Math.Pow(lon2 - lon1, 2));
        }

        async private Task<Path> GetPath(Position start, Position end)
        {
            string url = $"https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&start={start.Lng},{start.Lat}&end={end.Lng},{end.Lat}";
            HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();

            JObject responseJson = JObject.Parse(responseBody);

            string geometryCoords = responseJson["features"][0]["geometry"]["coordinates"].ToString();
            //Console.WriteLine(geometryCoords);
            List<List<double>> coordinatesList = JsonConvert.DeserializeObject<List<List<double>>>(geometryCoords);
            List<Position> positions = coordinatesList.Select(coord => new Position(coord[1], coord[0])).ToList();
            //Console.WriteLine(positions[0].Lat);
            Path myPath = new Path(positions);
            //Console.WriteLine(myPath.coordinates[0].Lng);

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

        public Position(double lat, double lng)
        {
            Lat = lat;
            Lng = lng;
        }

        public Position()
        {
        }
    }

    [DataContract]
    public class Path
    {
        [DataMember]
        public string type;

        [DataMember]
        public List<Position> coordinates;

        public Path(List<Position> coordinates)
        {
            this.coordinates = coordinates;
        }
    }
}
