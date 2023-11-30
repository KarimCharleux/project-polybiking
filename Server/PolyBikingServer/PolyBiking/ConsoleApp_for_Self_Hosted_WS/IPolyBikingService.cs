using System.Threading.Tasks;
using System.ServiceModel;

namespace PolyBiking
{
    [ServiceContract]
    public interface IPolyBikingService
    {
        [OperationContract]
        Task<BikingResponce> ComputeTrip(string addressOrigin, string addressDestination);
    }
}
