
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Periodicity.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Periodicity">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="y"/>
 *     &lt;enumeration value="q"/>
 *     &lt;enumeration value="s"/>
 *     &lt;enumeration value="a"/>
 *     &lt;enumeration value="c"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Periodicity")
@XmlEnum
public enum Periodicity {

    @XmlEnumValue("y")
    Y("y"),
    @XmlEnumValue("q")
    Q("q"),
    @XmlEnumValue("s")
    S("s"),
    @XmlEnumValue("a")
    A("a"),
    @XmlEnumValue("c")
    C("c");
    private final String value;

    Periodicity(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Periodicity fromValue(String v) {
        for (Periodicity c: Periodicity.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
