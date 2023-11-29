using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.ServiceModel;
using System.ServiceModel.Description;
using System.Text;
using System.Threading.Tasks;

namespace PolyBiking
{
    class Program
    {
        static void Main(string[] args)
        {

//            PolyBikingService service = new PolyBikingService();
 //           Path[] paths = service.ComputeTrip("Nice", "2255 route des dolines").Result;
   //         Console.WriteLine(JsonConvert.SerializeObject(paths));


            // Create a URI to serve as the base address
            // Be careful to run Visual Studio as Admistrator or to allow VS to open new port netsh command. 
            // Example : netsh http add urlacl url=http://+:3000/MyService/PolyBikingService user=DOMAIN\user
            Uri httpUrl = new Uri("http://localhost:3000/MyService/PolyBikingService");
            using (ServiceHost host = new ServiceHost(typeof(PolyBikingService), httpUrl))
            {
                // Créer et configurer un BasicHttpBinding sans sécurité
                BasicHttpBinding binding = new BasicHttpBinding();
                binding.Security.Mode = BasicHttpSecurityMode.None;

                // Ajouter le point de terminaison
                host.AddServiceEndpoint(typeof(IPolyBikingService), binding, "");

                // Démarrer le service
                host.Open();

                Console.WriteLine("Service is hosted at " + DateTime.Now.ToString());
                Console.WriteLine("Routing Server is running... Press <Enter> key to stop");
                Console.ReadLine();

                // Le service sera fermé lorsque l'utilisateur appuie sur Entrée
                host.Close();
            }
        }
    }
}
