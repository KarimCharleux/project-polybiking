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
        async public Task<string> Add(int num1, int num2)
        {
            try
            {
                HttpResponseMessage response = await client.GetAsync("https://api.openrouteservice.org/v2/directions/driving-car?api_key=5b3ce3597851110001cf6248bed9f6d656c54925b8cc6fb2f745876f&start=8.681495,49.41461&end=8.687872,49.420318");
                response.EnsureSuccessStatusCode();
                string responseBody = await response.Content.ReadAsStringAsync();
                
                JObject responseJson = JObject.Parse(responseBody);
                JObject elfiturs = (JObject) responseJson["features"];
                foreach(var prop  in elfiturs.Properties())
                {
                    Console.WriteLine(prop.Name);
                }
                string geometryType = responseJson["features"].ToString();
                return geometryType;
            }
            catch (HttpRequestException e)
            {
                Console.WriteLine("\nException Caught!");
                Console.WriteLine("Message :{0} ", e.Message);
            }
            return "l7wa";
        }

    }

}
