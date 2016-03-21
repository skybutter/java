
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FieldType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FieldType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Character"/>
 *     &lt;enumeration value="Numeric"/>
 *     &lt;enumeration value="Price"/>
 *     &lt;enumeration value="Security"/>
 *     &lt;enumeration value="Date"/>
 *     &lt;enumeration value="Time"/>
 *     &lt;enumeration value="Date/Time"/>
 *     &lt;enumeration value="Bulk"/>
 *     &lt;enumeration value="Month/Year"/>
 *     &lt;enumeration value="Boolean"/>
 *     &lt;enumeration value="Currency"/>
 *     &lt;enumeration value="Integer"/>
 *     &lt;enumeration value="Real"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FieldType")
@XmlEnum
public enum FieldType {

    @XmlEnumValue("Character")
    CHARACTER("Character"),
    @XmlEnumValue("Numeric")
    NUMERIC("Numeric"),
    @XmlEnumValue("Price")
    PRICE("Price"),
    @XmlEnumValue("Security")
    SECURITY("Security"),
    @XmlEnumValue("Date")
    DATE("Date"),
    @XmlEnumValue("Time")
    TIME("Time"),
    @XmlEnumValue("Date/Time")
    DATE_TIME("Date/Time"),
    @XmlEnumValue("Bulk")
    BULK("Bulk"),
    @XmlEnumValue("Month/Year")
    MONTH_YEAR("Month/Year"),
    @XmlEnumValue("Boolean")
    BOOLEAN("Boolean"),
    @XmlEnumValue("Currency")
    CURRENCY("Currency"),
    @XmlEnumValue("Integer")
    INTEGER("Integer"),
    @XmlEnumValue("Real")
    REAL("Real");
    private final String value;

    FieldType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FieldType fromValue(String v) {
        for (FieldType c: FieldType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
