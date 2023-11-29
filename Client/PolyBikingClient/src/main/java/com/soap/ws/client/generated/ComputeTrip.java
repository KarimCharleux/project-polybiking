
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
 *         <element name="addressOrigin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="addressDestination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "addressOrigin",
    "addressDestination"
})
@XmlRootElement(name = "ComputeTrip", namespace = "http://tempuri.org/")
public class ComputeTrip {

    @XmlElementRef(name = "addressOrigin", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addressOrigin;
    @XmlElementRef(name = "addressDestination", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<String> addressDestination;

    /**
     * Gets the value of the addressOrigin property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddressOrigin() {
        return addressOrigin;
    }

    /**
     * Sets the value of the addressOrigin property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddressOrigin(JAXBElement<String> value) {
        this.addressOrigin = value;
    }

    /**
     * Gets the value of the addressDestination property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddressDestination() {
        return addressDestination;
    }

    /**
     * Sets the value of the addressDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddressDestination(JAXBElement<String> value) {
        this.addressDestination = value;
    }

}
