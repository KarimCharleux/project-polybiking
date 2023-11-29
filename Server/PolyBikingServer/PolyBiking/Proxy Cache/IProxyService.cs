using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
// add assembly System.ServiceModel  and using for the corresponding model
using System.ServiceModel;

namespace Proxy_Cache
{

    [ServiceContract()]
    public interface IProxyService
    {
        [OperationContract()]
        Task<string> GetStationInfo();

        [OperationContract()]
        Task<string> GetRouteInfo(Position start, Position end);
        [OperationContract()]
        Task<string> GetAddressInfo(string address);
    }


}
