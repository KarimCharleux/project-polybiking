
package com.soap.ws.client.generated;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import jakarta.xml.ws.WebEndpoint;
import jakarta.xml.ws.WebServiceClient;
import jakarta.xml.ws.WebServiceException;
import jakarta.xml.ws.WebServiceFeature;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.1
 * Generated source version: 3.0
 * 
 */
@WebServiceClient(name = "PolyBikingService", targetNamespace = "http://tempuri.org/", wsdlLocation = "http://localhost:3000/MyService/PolyBikingService?wsdl")
public class PolyBikingService
    extends Service
{

    private static final URL POLYBIKINGSERVICE_WSDL_LOCATION;
    private static final WebServiceException POLYBIKINGSERVICE_EXCEPTION;
    private static final QName POLYBIKINGSERVICE_QNAME = new QName("http://tempuri.org/", "PolyBikingService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:3000/MyService/PolyBikingService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        POLYBIKINGSERVICE_WSDL_LOCATION = url;
        POLYBIKINGSERVICE_EXCEPTION = e;
    }

    public PolyBikingService() {
        super(__getWsdlLocation(), POLYBIKINGSERVICE_QNAME);
    }

    public PolyBikingService(WebServiceFeature... features) {
        super(__getWsdlLocation(), POLYBIKINGSERVICE_QNAME, features);
    }

    public PolyBikingService(URL wsdlLocation) {
        super(wsdlLocation, POLYBIKINGSERVICE_QNAME);
    }

    public PolyBikingService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, POLYBIKINGSERVICE_QNAME, features);
    }

    public PolyBikingService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PolyBikingService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IPolyBikingService
     */
    @WebEndpoint(name = "BasicHttpBinding_IPolyBikingService")
    public IPolyBikingService getBasicHttpBindingIPolyBikingService() {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IPolyBikingService"), IPolyBikingService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link jakarta.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IPolyBikingService
     */
    @WebEndpoint(name = "BasicHttpBinding_IPolyBikingService")
    public IPolyBikingService getBasicHttpBindingIPolyBikingService(WebServiceFeature... features) {
        return super.getPort(new QName("http://tempuri.org/", "BasicHttpBinding_IPolyBikingService"), IPolyBikingService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (POLYBIKINGSERVICE_EXCEPTION!= null) {
            throw POLYBIKINGSERVICE_EXCEPTION;
        }
        return POLYBIKINGSERVICE_WSDL_LOCATION;
    }

}
