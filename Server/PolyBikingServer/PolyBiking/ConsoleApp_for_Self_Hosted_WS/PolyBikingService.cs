using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System.Runtime.Serialization;
using PolyBiking.Proxy;

namespace PolyBiking
{
    class PolyBikingService : IPolyBikingService
    {
        ProxyServiceClient proxyServiceClient = new ProxyServiceClient();

        // Main function of the service, compute the best path between two addresses
        public async Task<BikingResponse> ComputeTrip(string addressOrigin, string addressDestination)
        {
            // Start two tasks to get the position of the two addresses
            var originTask = Task.Run(() => getPositionFromAddress(addressOrigin));
            var destinationTask = Task.Run(() => getPositionFromAddress(addressDestination));

            // Wait for the two tasks to finish
            await Task.WhenAll(originTask, destinationTask);

            // Retrieve the positions
            Position origin = originTask.Result;
            Position destination = destinationTask.Result;

            // Get all the stations in France
            List<StationInfo> allFranceStations = JsonConvert.DeserializeObject<List<StationInfo>>(proxyServiceClient.GetStationInfo());
            Console.WriteLine("[ComputeTrip] Call to api.jcdecaux.com/vls/v1/stations");

            List<Path> allPaths = new List<Path>();
            Position currentOrigin = origin;
            int iteration = 1;
            while (true)
            {
                // Step 0 : Get the closest stations from the current origin and the destination
                StationInfo[] stations = GetClosestStation(currentOrigin, destination, allFranceStations);
                StationInfo originStation = stations[0];
                StationInfo destinationStation = stations[1];
                StationInfo nextStation = stations[2];

                // Remove the stations from the list to avoid to select them again
                allFranceStations.Remove(originStation);
                allFranceStations.Remove(destinationStation);
                allFranceStations.Remove(nextStation);

                Console.WriteLine(iteration+" - Origin station : " + originStation.Name + " - " + originStation.Position.Lat+", "+ originStation.Position.Lng);
                Console.WriteLine(iteration+" - Destination station : " + destinationStation.Name + " - " + destinationStation.Position.Lat + ", " + destinationStation.Position.Lng);
                if (nextStation != null)
                {
                    Console.WriteLine(iteration + " - Next station : " + nextStation.Name + " - " + nextStation.Position.Lat + ", " + nextStation.Position.Lng);
                }

                Console.WriteLine("[Step 0] Get the closest stations from the current origin and the destination");

                // Step 1 : Foot path from current origin to closest station
                if (currentOrigin.Lng == originStation.Position.Lng && currentOrigin.Lat == originStation.Position.Lat)
                {
                    Console.WriteLine("[Step 1] No foot path from current origin to closest station");
                }
                else
                {
                    Console.WriteLine("[Step 1] Foot path from current origin to closest station");
                    allPaths.Add(GetPath(currentOrigin, originStation.Position, PathType.footPath));
                }

                // Step 2 : Bike path from closest station to closest station in the same contract
                Path bikePath = GetPath(originStation.Position, destinationStation.Position, PathType.bikePath);
                bikePath.departingStation = originStation;
                bikePath.arrivalStation = destinationStation;
                allPaths.Add(bikePath);
                Console.WriteLine("[Step 2] Bike path from closest station to closest station in the same contract");

                // Step 3 : Foot path from the station to another station or the destination
                if (nextStation != null && (CalculateDistance(destinationStation.Position.Lat, destinationStation.Position.Lng, destination.Lat, destination.Lng) > 
                    CalculateDistance(destinationStation.Position.Lat, destinationStation.Position.Lng, nextStation.Position.Lat, nextStation.Position.Lng)))
                {
                    allPaths.Add(GetPath(destinationStation.Position, nextStation.Position, PathType.footPath));
                    Console.WriteLine("[Step 3] Foot path from the station to another station");
                }
                else
                {
                    allPaths.Add(GetPath(destinationStation.Position, destination, PathType.footPath));
                    Console.WriteLine("[Step 3] Foot path from the station to the destination");
                    break;
                }

                if (iteration++ > 10)
                {
                    break;
                }

                // Step 4 : Update the current origin and repeat until the destination is reached
                currentOrigin = nextStation.Position;
                Console.WriteLine("[Step 4] Update the current origin and repeat until the destination is reached");
            }

            Console.WriteLine("Path found in " + iteration + " iterations");

            // Get the full foot path to check if it's a better option than bike
            Path fullFootPath = GetPath(origin, destination, PathType.footPath);
            Console.WriteLine("[Step] Get the full foot path to check if it's a better option than bike");

            // Compare and select the best path
            List<Path> bestPath = SelectBestPath(allPaths, fullFootPath);
            Console.WriteLine("[Final Step] Compare and select the best path");

            // Create the responce object
            return CreateBikingResponse(allPaths); // TODO : bestPath
        }

        // Method to get the closest station from two positions
        private StationInfo[] GetClosestStation(Position origin, Position destination, List<StationInfo> allStation)
        {
            StationInfo departingStation = null;
            StationInfo arrivalStation = null;
            StationInfo nextNearStation = null;

            double minDistance = double.MaxValue;
            foreach (var station in allStation.Where(s => s.AvailableBikes > 0).ToList())
            {
                double distance = CalculateDistance(origin.Lat, origin.Lng, station.Position.Lat, station.Position.Lng);

                if (distance < minDistance)
                {
                    minDistance = distance;
                    departingStation = station;
                }
            }
            minDistance = double.MaxValue;
            double arrivalDistance = double.MaxValue;
            foreach (var station in allStation.Where(s => s.AvailableBikeStands > 0).ToList())
            {
                double distance = CalculateDistance(destination.Lat, destination.Lng, station.Position.Lat, station.Position.Lng);

                if (station.ContractName == departingStation.ContractName && distance < minDistance && station.Number != departingStation.Number)
                {
                    minDistance = distance;
                    arrivalStation = station;
                    arrivalDistance = distance;
                }
            }
            minDistance = double.MaxValue;
            foreach (var station in allStation.Where(s => s.AvailableBikes > 0).ToList())
            {
                double distanceFromOrigin = CalculateDistance(origin.Lat, origin.Lng, station.Position.Lat, station.Position.Lng);
                double distanceFromDestination = CalculateDistance(destination.Lat, destination.Lng, station.Position.Lat, station.Position.Lng);

                if (station.ContractName != arrivalStation.ContractName && distanceFromDestination < minDistance && arrivalDistance > distanceFromDestination)
                {
                    minDistance = distanceFromDestination;
                    nextNearStation = station;
                }
            }

            StationInfo[] funcResponse = new StationInfo[] { departingStation, arrivalStation, nextNearStation };
            return funcResponse;
        }

        // Method to get the position from an string address 
        private Position getPositionFromAddress(string address)
        {
            string responseBody = proxyServiceClient.GetAddressInfo(address);
            double[] coords = JsonConvert.DeserializeObject<double[]>(responseBody);

            Position positionResult = new Position();
            if (responseBody != null)
            {
                positionResult.Lat = coords[1];
                positionResult.Lng = coords[0];
            }
            else
            {
                throw new Exception("No position found for this address " + address);
            }

            return positionResult;
        }

        // Method to calculate the distance between two positions in a straight line
        static double CalculateDistance(double lat1, double lon1, double lat2, double lon2)
        {
            return Math.Sqrt(Math.Pow(lat2 - lat1, 2) + Math.Pow(lon2 - lon1, 2));
        }

        // Method to get the (Foot or Cycle) path between two positions
        private Path GetPath(Position start, Position end, PathType pathType)
        {
            string responseBody = proxyServiceClient.GetRouteInfo(start.Lat, start.Lng, end.Lat, end.Lng, pathType.GetString());

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
        private List<Path> SelectBestPath(List<Path> allPaths, Path fullFootPath)
        {
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

        [DataMember]
        public StationInfo departingStation;

        [DataMember]
        public StationInfo arrivalStation;

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
