
package com.soap.ws.client.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Position complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="Position">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Lat" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         <element name="Lng" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Position", propOrder = {
    "lat",
    "lng"
})
public class Position {

    @XmlElement(name = "Lat")
    protected Double lat;
    @XmlElement(name = "Lng")
    protected Double lng;

    /**
     * Gets the value of the lat property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLat() {
        return lat;
    }

    /**
     * Sets the value of the lat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLat(Double value) {
        this.lat = value;
    }

    /**
     * Gets the value of the lng property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLng() {
        return lng;
    }

    /**
     * Sets the value of the lng property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLng(Double value) {
        this.lng = value;
    }

}
