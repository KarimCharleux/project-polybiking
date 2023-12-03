
package com.soap.ws.client.generated;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StationInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="StationInfo">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="AvailableBikeStands" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="AvailableBikes" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="Banking" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         <element name="BikeStands" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="Bonus" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         <element name="ContractName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="LastUpdate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         <element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="Number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         <element name="Position" type="{http://schemas.datacontract.org/2004/07/PolyBiking}Position" minOccurs="0"/>
 *         <element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StationInfo", propOrder = {
    "address",
    "availableBikeStands",
    "availableBikes",
    "banking",
    "bikeStands",
    "bonus",
    "contractName",
    "lastUpdate",
    "name",
    "number",
    "position",
    "status"
})
public class StationInfo {

    @XmlElementRef(name = "Address", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<String> address;
    @XmlElement(name = "AvailableBikeStands")
    protected Integer availableBikeStands;
    @XmlElement(name = "AvailableBikes")
    protected Integer availableBikes;
    @XmlElement(name = "Banking")
    protected Boolean banking;
    @XmlElement(name = "BikeStands")
    protected Integer bikeStands;
    @XmlElement(name = "Bonus")
    protected Boolean bonus;
    @XmlElementRef(name = "ContractName", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<String> contractName;
    @XmlElementRef(name = "LastUpdate", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<Long> lastUpdate;
    @XmlElementRef(name = "Name", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<String> name;
    @XmlElement(name = "Number")
    protected Integer number;
    @XmlElementRef(name = "Position", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<Position> position;
    @XmlElementRef(name = "Status", namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAddress(JAXBElement<String> value) {
        this.address = value;
    }

    /**
     * Gets the value of the availableBikeStands property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAvailableBikeStands() {
        return availableBikeStands;
    }

    /**
     * Sets the value of the availableBikeStands property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAvailableBikeStands(Integer value) {
        this.availableBikeStands = value;
    }

    /**
     * Gets the value of the availableBikes property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAvailableBikes() {
        return availableBikes;
    }

    /**
     * Sets the value of the availableBikes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAvailableBikes(Integer value) {
        this.availableBikes = value;
    }

    /**
     * Gets the value of the banking property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBanking() {
        return banking;
    }

    /**
     * Sets the value of the banking property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBanking(Boolean value) {
        this.banking = value;
    }

    /**
     * Gets the value of the bikeStands property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBikeStands() {
        return bikeStands;
    }

    /**
     * Sets the value of the bikeStands property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBikeStands(Integer value) {
        this.bikeStands = value;
    }

    /**
     * Gets the value of the bonus property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBonus() {
        return bonus;
    }

    /**
     * Sets the value of the bonus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBonus(Boolean value) {
        this.bonus = value;
    }

    /**
     * Gets the value of the contractName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getContractName() {
        return contractName;
    }

    /**
     * Sets the value of the contractName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setContractName(JAXBElement<String> value) {
        this.contractName = value;
    }

    /**
     * Gets the value of the lastUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Sets the value of the lastUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setLastUpdate(JAXBElement<Long> value) {
        this.lastUpdate = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setName(JAXBElement<String> value) {
        this.name = value;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

    /**
     * Gets the value of the position property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Position }{@code >}
     *     
     */
    public JAXBElement<Position> getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Position }{@code >}
     *     
     */
    public void setPosition(JAXBElement<Position> value) {
        this.position = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

}
