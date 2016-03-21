
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BvalFieldMacro.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BvalFieldMacro">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BVAL_ALL"/>
 *     &lt;enumeration value="BVAL_BOND"/>
 *     &lt;enumeration value="BVAL_MTGE"/>
 *     &lt;enumeration value="BVAL_MUNI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BvalFieldMacro")
@XmlEnum
public enum BvalFieldMacro {

    BVAL_ALL,
    BVAL_BOND,
    BVAL_MTGE,
    BVAL_MUNI;

    public String value() {
        return name();
    }

    public static BvalFieldMacro fromValue(String v) {
        return valueOf(v);
    }

}
