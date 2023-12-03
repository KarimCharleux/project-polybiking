using System.Threading.Tasks;
using System.ServiceModel;
using PolyBiking;

namespace ConsoleApp_for_Self_Hosted_WS
{
    [ServiceContract()]
    public interface IPolyBikingService
    {
        [OperationContract()]
        Task<BikingResponse> ComputeTrip(string addressOrigin, string addressDestination)
    }
}
