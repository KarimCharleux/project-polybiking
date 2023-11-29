
package com.soap.ws.client.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfPath complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType name="ArrayOfPath">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="Path" type="{http://schemas.datacontract.org/2004/07/PolyBiking}Path" maxOccurs="unbounded" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfPath", propOrder = {
    "path"
})
public class ArrayOfPath {

    @XmlElement(name = "Path", nillable = true)
    protected List<Path> path;

    /**
     * Gets the value of the path property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the path property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPath().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Path }
     * 
     * 
     * @return
     *     The value of the path property.
     */
    public List<Path> getPath() {
        if (path == null) {
            path = new ArrayList<>();
        }
        return this.path;
    }

}
