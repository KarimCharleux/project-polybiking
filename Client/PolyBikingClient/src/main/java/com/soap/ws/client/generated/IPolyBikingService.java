
package com.soap.ws.client.generated;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebService(name = "IPolyBikingService", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IPolyBikingService {


    /**
     * 
     * @param addressDestination
     * @param addressOrigin
     * @return
     *     returns com.soap.ws.client.generated.BikingResponse
     */
    @WebMethod(operationName = "ComputeTrip", action = "http://tempuri.org/IPolyBikingService/ComputeTrip")
    @WebResult(name = "ComputeTripResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "ComputeTrip", targetNamespace = "http://tempuri.org/", className = "com.soap.ws.client.generated.ComputeTrip")
    @ResponseWrapper(localName = "ComputeTripResponse", targetNamespace = "http://tempuri.org/", className = "com.soap.ws.client.generated.ComputeTripResponse")
    public BikingResponse computeTrip(
        @WebParam(name = "addressOrigin", targetNamespace = "http://tempuri.org/")
        String addressOrigin,
        @WebParam(name = "addressDestination", targetNamespace = "http://tempuri.org/")
        String addressDestination);

}
