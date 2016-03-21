
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FilingStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FilingStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="mostrecent"/>
 *     &lt;enumeration value="prelim"/>
 *     &lt;enumeration value="original"/>
 *     &lt;enumeration value="restated"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FilingStatus")
@XmlEnum
public enum FilingStatus {

    @XmlEnumValue("mostrecent")
    MOSTRECENT("mostrecent"),
    @XmlEnumValue("prelim")
    PRELIM("prelim"),
    @XmlEnumValue("original")
    ORIGINAL("original"),
    @XmlEnumValue("restated")
    RESTATED("restated");
    private final String value;

    FilingStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FilingStatus fromValue(String v) {
        for (FilingStatus c: FilingStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
