﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


// add the WCF ServiceModel namespace 
using System.ServiceModel;
using System.ServiceModel.Description;

namespace ConsoleApp_for_Self_Hosted_WS
{
    class Program
    {
        static void Main(string[] args)
        {
            Uri httpUrl = new Uri("http://localhost:3000/MyService/PolyBikingService");

            ServiceHost host = new ServiceHost(typeof(PolyBikingService), httpUrl);

            host.AddServiceEndpoint(typeof(IPolyBikingService), new WSHttpBinding(), ""); 

            ServiceMetadataBehavior smb = new ServiceMetadataBehavior();
            smb.HttpGetEnabled = true;
            host.Description.Behaviors.Add(smb);
            
            host.Open();

            Console.WriteLine("Service is host at " + DateTime.Now.ToString());
            Console.WriteLine("Host is running... Press <Enter> key to stop");
            Console.ReadLine();

        }
    }
}
