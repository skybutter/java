
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PortSecDes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PortSecDes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="adjusted"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PortSecDes")
@XmlEnum
public enum PortSecDes {

    @XmlEnumValue("adjusted")
    ADJUSTED("adjusted");
    private final String value;

    PortSecDes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PortSecDes fromValue(String v) {
        for (PortSecDes c: PortSecDes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
