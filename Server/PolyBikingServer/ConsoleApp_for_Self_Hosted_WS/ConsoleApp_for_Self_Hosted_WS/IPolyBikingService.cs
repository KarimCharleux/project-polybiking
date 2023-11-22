using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
// add assembly System.ServiceModel  and using for the corresponding model
using System.ServiceModel;

namespace ConsoleApp_for_Self_Hosted_WS
{

    [ServiceContract()]
    public interface IPolyBikingService
    {
        [OperationContract()]
        Task<string> Add(int num1, int num2);
    }


}
