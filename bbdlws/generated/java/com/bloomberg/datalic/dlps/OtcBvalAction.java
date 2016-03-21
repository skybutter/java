
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OtcBvalAction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OtcBvalAction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="insert"/>
 *     &lt;enumeration value="update"/>
 *     &lt;enumeration value="unwind"/>
 *     &lt;enumeration value="reprice"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OtcBvalAction")
@XmlEnum
public enum OtcBvalAction {

    @XmlEnumValue("insert")
    INSERT("insert"),
    @XmlEnumValue("update")
    UPDATE("update"),
    @XmlEnumValue("unwind")
    UNWIND("unwind"),
    @XmlEnumValue("reprice")
    REPRICE("reprice");
    private final String value;

    OtcBvalAction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OtcBvalAction fromValue(String v) {
        for (OtcBvalAction c: OtcBvalAction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
