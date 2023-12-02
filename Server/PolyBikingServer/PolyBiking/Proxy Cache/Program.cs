using System;
using System.ServiceModel;
using System.ServiceModel.Description;

namespace Proxy_Cache_Server
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Uri httpUrl = new Uri("http://localhost:3001/MyService/ProxyService");

            ServiceHost host = new ServiceHost(typeof(ProxyService), httpUrl);

            host.AddServiceEndpoint(typeof(IProxyService), new WSHttpBinding(), ""); 

            ServiceMetadataBehavior smb = new ServiceMetadataBehavior();
            smb.HttpGetEnabled = true;
            host.Description.Behaviors.Add(smb);
            
            host.Open();

            Console.WriteLine("Service Proxy is hosted at " + DateTime.Now.ToString() + " to " + httpUrl);
            Console.WriteLine("Host is running... Press <Enter> key to stop\n");
            Console.ReadLine();
        }
    }
}
