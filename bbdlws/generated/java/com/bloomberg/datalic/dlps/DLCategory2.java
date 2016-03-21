
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DLCategory2.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DLCategory2">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Security Master"/>
 *     &lt;enumeration value="Derived - Intraday"/>
 *     &lt;enumeration value="Derived - End of Day"/>
 *     &lt;enumeration value="Pricing - Intraday"/>
 *     &lt;enumeration value="Pricing - End of Day"/>
 *     &lt;enumeration value="User Entered Info."/>
 *     &lt;enumeration value="Corporate Actions"/>
 *     &lt;enumeration value="Historical Time Series"/>
 *     &lt;enumeration value="Estimates"/>
 *     &lt;enumeration value="Fundamentals"/>
 *     &lt;enumeration value="Quote Composite"/>
 *     &lt;enumeration value="Quote Composite History"/>
 *     &lt;enumeration value="Credit Risk"/>
 *     &lt;enumeration value="Packaged"/>
 *     &lt;enumeration value="Open Source"/>
 *     &lt;enumeration value="Reg SSFA"/>
 *     &lt;enumeration value="Volatility Surface"/>
 *     &lt;enumeration value="Volatility Cube"/>
 *     &lt;enumeration value="Bram Fair Value Hierarchy Leveling Tool"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DLCategory2")
@XmlEnum
public enum DLCategory2 {

    @XmlEnumValue("Security Master")
    SECURITY_MASTER("Security Master"),
    @XmlEnumValue("Derived - Intraday")
    DERIVED_INTRADAY("Derived - Intraday"),
    @XmlEnumValue("Derived - End of Day")
    DERIVED_END_OF_DAY("Derived - End of Day"),
    @XmlEnumValue("Pricing - Intraday")
    PRICING_INTRADAY("Pricing - Intraday"),
    @XmlEnumValue("Pricing - End of Day")
    PRICING_END_OF_DAY("Pricing - End of Day"),
    @XmlEnumValue("User Entered Info.")
    USER_ENTERED_INFO("User Entered Info."),
    @XmlEnumValue("Corporate Actions")
    CORPORATE_ACTIONS("Corporate Actions"),
    @XmlEnumValue("Historical Time Series")
    HISTORICAL_TIME_SERIES("Historical Time Series"),
    @XmlEnumValue("Estimates")
    ESTIMATES("Estimates"),
    @XmlEnumValue("Fundamentals")
    FUNDAMENTALS("Fundamentals"),
    @XmlEnumValue("Quote Composite")
    QUOTE_COMPOSITE("Quote Composite"),
    @XmlEnumValue("Quote Composite History")
    QUOTE_COMPOSITE_HISTORY("Quote Composite History"),
    @XmlEnumValue("Credit Risk")
    CREDIT_RISK("Credit Risk"),
    @XmlEnumValue("Packaged")
    PACKAGED("Packaged"),
    @XmlEnumValue("Open Source")
    OPEN_SOURCE("Open Source"),
    @XmlEnumValue("Reg SSFA")
    REG_SSFA("Reg SSFA"),
    @XmlEnumValue("Volatility Surface")
    VOLATILITY_SURFACE("Volatility Surface"),
    @XmlEnumValue("Volatility Cube")
    VOLATILITY_CUBE("Volatility Cube"),
    @XmlEnumValue("Bram Fair Value Hierarchy Leveling Tool")
    BRAM_FAIR_VALUE_HIERARCHY_LEVELING_TOOL("Bram Fair Value Hierarchy Leveling Tool");
    private final String value;

    DLCategory2(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DLCategory2 fromValue(String v) {
        for (DLCategory2 c: DLCategory2 .values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
