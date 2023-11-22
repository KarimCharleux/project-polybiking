using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Newtonsoft.Json.Linq;

namespace ConsoleApp_for_Self_Hosted_WS
{
    class PolyBikingService : IPolyBikingService
    {
        static readonly HttpClient client = new HttpClient();
        async public Task<string> Add(double[] coord1, double[] coord2)
        {
            return await GetPath(coord1, coord2);
        }
        async private Task<string> GetPath(double[] coord1, double[] coord2)
        {
            string url = $"https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&start={coord1[0]},{coord1[1]}&{coord2[0]},{coord2[1]}";
            HttpResponseMessage response = await client.GetAsync(url);
            response.EnsureSuccessStatusCode();
            string responseBody = await response.Content.ReadAsStringAsync();
            
            JObject responseJson = JObject.Parse(responseBody);
            Console.WriteLine(responseJson.ToString());
            string geometryType = responseJson["features"][0]["geometry"].ToString();
            return geometryType;

        }
    }


}
