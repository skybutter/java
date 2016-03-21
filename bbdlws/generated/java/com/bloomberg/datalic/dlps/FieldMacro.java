
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FieldMacro.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FieldMacro">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BO_CREDIT_RISK_COMPANY"/>
 *     &lt;enumeration value="BO_CREDIT_RISK_FITCH"/>
 *     &lt;enumeration value="BO_CREDIT_RISK_MOODY"/>
 *     &lt;enumeration value="BO_CREDIT_RISK_RATINGS1"/>
 *     &lt;enumeration value="BO_CREDIT_RISK_RATINGS2"/>
 *     &lt;enumeration value="BO_CREDIT_RISK_SP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FieldMacro")
@XmlEnum
public enum FieldMacro {

    BO_CREDIT_RISK_COMPANY("BO_CREDIT_RISK_COMPANY"),
    BO_CREDIT_RISK_FITCH("BO_CREDIT_RISK_FITCH"),
    BO_CREDIT_RISK_MOODY("BO_CREDIT_RISK_MOODY"),
    @XmlEnumValue("BO_CREDIT_RISK_RATINGS1")
    BO_CREDIT_RISK_RATINGS_1("BO_CREDIT_RISK_RATINGS1"),
    @XmlEnumValue("BO_CREDIT_RISK_RATINGS2")
    BO_CREDIT_RISK_RATINGS_2("BO_CREDIT_RISK_RATINGS2"),
    BO_CREDIT_RISK_SP("BO_CREDIT_RISK_SP");
    private final String value;

    FieldMacro(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FieldMacro fromValue(String v) {
        for (FieldMacro c: FieldMacro.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
