using System.Threading.Tasks;
using System.ServiceModel;

namespace PolyBiking
{

    [ServiceContract]
    public interface IPolyBikingService
    {
        [OperationContract]
        Task<Path[]> ComputeTrip(string addressOrigin, string addressDestination);
    }


}
