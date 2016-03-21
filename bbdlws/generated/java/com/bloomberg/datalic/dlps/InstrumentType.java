
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstrumentType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InstrumentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AUSTRIAN"/>
 *     &lt;enumeration value="BB_UNIQUE"/>
 *     &lt;enumeration value="BB_GLOBAL"/>
 *     &lt;enumeration value="BELGIAN"/>
 *     &lt;enumeration value="CATS"/>
 *     &lt;enumeration value="CEDEL"/>
 *     &lt;enumeration value="CINS"/>
 *     &lt;enumeration value="COMMON_NUMBER"/>
 *     &lt;enumeration value="CUSIP"/>
 *     &lt;enumeration value="CZECH"/>
 *     &lt;enumeration value="DUTCH"/>
 *     &lt;enumeration value="EUROCLEAR"/>
 *     &lt;enumeration value="FRENCH"/>
 *     &lt;enumeration value="IRISH"/>
 *     &lt;enumeration value="ISIN"/>
 *     &lt;enumeration value="ISRAELI"/>
 *     &lt;enumeration value="ITALY"/>
 *     &lt;enumeration value="JAPAN"/>
 *     &lt;enumeration value="LUXEMBOURG"/>
 *     &lt;enumeration value="SEDOL"/>
 *     &lt;enumeration value="SPAIN"/>
 *     &lt;enumeration value="TICKER"/>
 *     &lt;enumeration value="VALOREN"/>
 *     &lt;enumeration value="WPK"/>
 *     &lt;enumeration value="BB_COMPANY"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InstrumentType")
@XmlEnum
public enum InstrumentType {

    AUSTRIAN,
    BB_UNIQUE,
    BB_GLOBAL,
    BELGIAN,
    CATS,
    CEDEL,
    CINS,
    COMMON_NUMBER,
    CUSIP,
    CZECH,
    DUTCH,
    EUROCLEAR,
    FRENCH,
    IRISH,
    ISIN,
    ISRAELI,
    ITALY,
    JAPAN,
    LUXEMBOURG,
    SEDOL,
    SPAIN,
    TICKER,
    VALOREN,
    WPK,
    BB_COMPANY;

    public String value() {
        return name();
    }

    public static InstrumentType fromValue(String v) {
        return valueOf(v);
    }

}
