using System.Threading.Tasks;
using System.ServiceModel;

namespace Proxy_Cache_Server
{

    [ServiceContract()]
    public interface IProxyService
    {
        [OperationContract()]
        Task<string> GetStationInfo();

        [OperationContract()]
        Task<string> GetRouteInfo(double startLat, double startLng, double endLat, double endLng, string pathType);

        [OperationContract()]
        Task<string> GetAddressInfo(string address);
    }
}