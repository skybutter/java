
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MarketSector.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MarketSector">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Govt"/>
 *     &lt;enumeration value="Corp"/>
 *     &lt;enumeration value="Mtge"/>
 *     &lt;enumeration value="M-Mkt"/>
 *     &lt;enumeration value="Muni"/>
 *     &lt;enumeration value="Pfd"/>
 *     &lt;enumeration value="Equity"/>
 *     &lt;enumeration value="Comdty"/>
 *     &lt;enumeration value="Index"/>
 *     &lt;enumeration value="Curncy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MarketSector")
@XmlEnum
public enum MarketSector {

    @XmlEnumValue("Govt")
    GOVT("Govt"),
    @XmlEnumValue("Corp")
    CORP("Corp"),
    @XmlEnumValue("Mtge")
    MTGE("Mtge"),
    @XmlEnumValue("M-Mkt")
    M_MKT("M-Mkt"),
    @XmlEnumValue("Muni")
    MUNI("Muni"),
    @XmlEnumValue("Pfd")
    PFD("Pfd"),
    @XmlEnumValue("Equity")
    EQUITY("Equity"),
    @XmlEnumValue("Comdty")
    COMDTY("Comdty"),
    @XmlEnumValue("Index")
    INDEX("Index"),
    @XmlEnumValue("Curncy")
    CURNCY("Curncy");
    private final String value;

    MarketSector(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MarketSector fromValue(String v) {
        for (MarketSector c: MarketSector.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
