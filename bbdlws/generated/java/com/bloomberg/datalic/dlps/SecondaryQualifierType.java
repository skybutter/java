
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecondaryQualifierType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SecondaryQualifierType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ACTIVE_PRICING"/>
 *     &lt;enumeration value="COUNTRY"/>
 *     &lt;enumeration value="CPN_TYP"/>
 *     &lt;enumeration value="CRNCY"/>
 *     &lt;enumeration value="EXCH_TRADED"/>
 *     &lt;enumeration value="MATURED"/>
 *     &lt;enumeration value="NET_CPN"/>
 *     &lt;enumeration value="RATE"/>
 *     &lt;enumeration value="RATING"/>
 *     &lt;enumeration value="SECURITY_DES"/>
 *     &lt;enumeration value="SECURITY_TYP"/>
 *     &lt;enumeration value="SERIES"/>
 *     &lt;enumeration value="TICKER"/>
 *     &lt;enumeration value="WAC"/>
 *     &lt;enumeration value="WALA"/>
 *     &lt;enumeration value="WAM"/>
 *     &lt;enumeration value="BVAL_OTC_FREQUENCY"/>
 *     &lt;enumeration value="BVAL_OTC_EXPIRED"/>
 *     &lt;enumeration value="BVAL_OTC_ASSET"/>
 *     &lt;enumeration value="BVAL_OTC_SNAPSHOT"/>
 *     &lt;enumeration value="BVAL_OTC_UNWOUND"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SecondaryQualifierType")
@XmlEnum
public enum SecondaryQualifierType {

    ACTIVE_PRICING,
    COUNTRY,
    CPN_TYP,
    CRNCY,
    EXCH_TRADED,
    MATURED,
    NET_CPN,
    RATE,
    RATING,
    SECURITY_DES,
    SECURITY_TYP,
    SERIES,
    TICKER,
    WAC,
    WALA,
    WAM,
    BVAL_OTC_FREQUENCY,
    BVAL_OTC_EXPIRED,
    BVAL_OTC_ASSET,
    BVAL_OTC_SNAPSHOT,
    BVAL_OTC_UNWOUND;

    public String value() {
        return name();
    }

    public static SecondaryQualifierType fromValue(String v) {
        return valueOf(v);
    }

}
