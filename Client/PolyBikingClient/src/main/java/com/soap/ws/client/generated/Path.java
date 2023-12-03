
package com.soap.ws.client.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSchemaType;
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
 *         <element name="arrivalStation" type="{http://schemas.datacontract.org/2004/07/PolyBiking}StationInfo" minOccurs="0"/>
 *         <element name="coordinates" type="{http://schemas.datacontract.org/2004/07/PolyBiking}ArrayOfPosition" minOccurs="0"/>
 *         <element name="departingStation" type="{http://schemas.datacontract.org/2004/07/PolyBiking}StationInfo" minOccurs="0"/>
 *         <element name="distance" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         <element name="duration" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         <element name="steps" type="{http://schemas.datacontract.org/2004/07/PolyBiking}ArrayOfStep" minOccurs="0"/>
 *         <element name="type" type="{http://schemas.datacontract.org/2004/07/PolyBiking}PathType" minOccurs="0"/>
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
    "arrivalStation",
    "coordinates",
    "departingStation",
    "distance",
    "duration",
    "steps",
    "type"
})
public class Path {

    @XmlElementRef(name = "arrivalStation", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<StationInfo> arrivalStation;
    @XmlElementRef(name = "coordinates", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfPosition> coordinates;
    @XmlElementRef(name = "departingStation", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<StationInfo> departingStation;
    protected Double distance;
    protected Double duration;
    @XmlElementRef(name = "steps", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfStep> steps;
    @XmlSchemaType(name = "string")
    protected PathType type;

    /**
     * Gets the value of the arrivalStation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     *     
     */
    public JAXBElement<StationInfo> getArrivalStation() {
        return arrivalStation;
    }

    /**
     * Sets the value of the arrivalStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     *     
     */
    public void setArrivalStation(JAXBElement<StationInfo> value) {
        this.arrivalStation = value;
    }

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
     * Gets the value of the departingStation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     *     
     */
    public JAXBElement<StationInfo> getDepartingStation() {
        return departingStation;
    }

    /**
     * Sets the value of the departingStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     *     
     */
    public void setDepartingStation(JAXBElement<StationInfo> value) {
        this.departingStation = value;
    }

    /**
     * Gets the value of the distance property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDistance(Double value) {
        this.distance = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDuration(Double value) {
        this.duration = value;
    }

    /**
     * Gets the value of the steps property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     *     
     */
    public JAXBElement<ArrayOfStep> getSteps() {
        return steps;
    }

    /**
     * Sets the value of the steps property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     *     
     */
    public void setSteps(JAXBElement<ArrayOfStep> value) {
        this.steps = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link PathType }
     *     
     */
    public PathType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link PathType }
     *     
     */
    public void setType(PathType value) {
        this.type = value;
    }

}
