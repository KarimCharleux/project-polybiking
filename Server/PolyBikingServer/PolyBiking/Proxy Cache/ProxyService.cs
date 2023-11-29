using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Caching;
using Newtonsoft.Json;
using System.Net.Http;
using Newtonsoft.Json.Linq;

namespace Proxy_Cache
{
    internal class ProxyService : IProxyService
    {
        public Task<string> GetAddressInfo(string address)
        {
            throw new NotImplementedException();
        }

        public Task<string> GetRouteInfo(double latitude, double longitude)
        {
            throw new NotImplementedException();
        }

        public Task<string> GetStationInfo(double latitude, double longitude)
        {
            throw new NotImplementedException();
        }
    }
}
