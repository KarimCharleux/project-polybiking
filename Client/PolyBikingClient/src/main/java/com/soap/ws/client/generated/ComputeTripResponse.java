
package com.soap.ws.client.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ComputeTripResult" type="{http://schemas.datacontract.org/2004/07/PolyBiking}BikingResponse" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "computeTripResult"
})
@XmlRootElement(name = "ComputeTripResponse", namespace = "http://tempuri.org/")
public class ComputeTripResponse {

    @XmlElementRef(name = "ComputeTripResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<BikingResponse> computeTripResult;

    /**
     * Gets the value of the computeTripResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BikingResponse }{@code >}
     *     
     */
    public JAXBElement<BikingResponse> getComputeTripResult() {
        return computeTripResult;
    }

    /**
     * Sets the value of the computeTripResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BikingResponse }{@code >}
     *     
     */
    public void setComputeTripResult(JAXBElement<BikingResponse> value) {
        this.computeTripResult = value;
    }

}
