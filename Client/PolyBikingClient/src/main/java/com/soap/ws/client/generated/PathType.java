
package com.soap.ws.client.generated;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PathType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>{@code
 * <simpleType name="PathType">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="footPath"/>
 *     <enumeration value="bikePath"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "PathType")
@XmlEnum
public enum PathType {

    @XmlEnumValue("footPath")
    FOOT_PATH("footPath"),
    @XmlEnumValue("bikePath")
    BIKE_PATH("bikePath");
    private final String value;

    PathType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PathType fromValue(String v) {
        for (PathType c: PathType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
