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
        ObjectCache addressCache = MemoryCache.Default;
        ObjectCache routeCache = MemoryCache.Default;
        ObjectCache stationCache = MemoryCache.Default;
        CacheItemPolicy policy = new CacheItemPolicy { AbsoluteExpiration = DateTimeOffset.Now.AddMinutes(10) };

        public Task<string> GetAddressInfo(string address)
        {
            string cachedAddress = this.addressCache[address] as string;
            if (cachedAddress == null)
            {

            }
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
