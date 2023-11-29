
package com.soap.ws.client.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Path complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="Path">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="coordinates" type="{http://schemas.datacontract.org/2004/07/PolyBiking}ArrayOfPosition" minOccurs="0"/>
 *         <element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Path", propOrder = {
    "coordinates",
    "type"
})
public class Path {

    @XmlElementRef(name = "coordinates", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPosition> coordinates;
    @XmlElementRef(name = "type", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<String> type;

    /**
     * Gets the value of the coordinates property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPosition }{@code >}
     *     
     */
    public JAXBElement<ArrayOfPosition> getCoordinates() {
        return coordinates;
    }

    /**
     * Sets the value of the coordinates property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfPosition }{@code >}
     *     
     */
    public void setCoordinates(JAXBElement<ArrayOfPosition> value) {
        this.coordinates = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setType(JAXBElement<String> value) {
        this.type = value;
    }

}
