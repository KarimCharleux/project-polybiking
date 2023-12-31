
package com.soap.ws.client.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BikingResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="BikingResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Paths" type="{http://schemas.datacontract.org/2004/07/PolyBiking}ArrayOfPath" minOccurs="0"/>
 *         <element name="TotalDistance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         <element name="TotalDuration" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BikingResponse", propOrder = {
    "paths",
    "totalDistance",
    "totalDuration"
})
public class BikingResponse {

    @XmlElementRef(name = "Paths", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPath> paths;
    @XmlElement(name = "TotalDistance")
    protected Double totalDistance;
    @XmlElement(name = "TotalDuration")
    protected Double totalDuration;

    /**
     * Gets the value of the paths property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPath }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPath> getPaths() {
        return paths;
    }

    /**
     * Sets the value of the paths property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPath }{@code >}
     *     
     */
    public void setPaths(JAXBElement<ArrayOfPath> value) {
        this.paths = value;
    }

    /**
     * Gets the value of the totalDistance property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalDistance() {
        return totalDistance;
    }

    /**
     * Sets the value of the totalDistance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalDistance(Double value) {
        this.totalDistance = value;
    }

    /**
     * Gets the value of the totalDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTotalDuration() {
        return totalDuration;
    }

    /**
     * Sets the value of the totalDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTotalDuration(Double value) {
        this.totalDuration = value;
    }

}
