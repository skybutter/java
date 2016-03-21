
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MacroType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MacroType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BOND_SRCH"/>
 *     &lt;enumeration value="EQUITY_SRCH"/>
 *     &lt;enumeration value="EXCH"/>
 *     &lt;enumeration value="INDEX"/>
 *     &lt;enumeration value="PFD_SRCH"/>
 *     &lt;enumeration value="PORTFOLIO"/>
 *     &lt;enumeration value="SECTYP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MacroType")
@XmlEnum
public enum MacroType {

    BOND_SRCH,
    EQUITY_SRCH,
    EXCH,
    INDEX,
    PFD_SRCH,
    PORTFOLIO,
    SECTYP;

    public String value() {
        return name();
    }

    public static MacroType fromValue(String v) {
        return valueOf(v);
    }

}
