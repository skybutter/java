
package com.bloomberg.datalic.dlps;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DateFormat.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="DateFormat">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="mmddyy"/>
 *     &lt;enumeration value="yyddmm"/>
 *     &lt;enumeration value="mmyydd"/>
 *     &lt;enumeration value="dmmyy"/>
 *     &lt;enumeration value="yyyyddmm"/>
 *     &lt;enumeration value="mmyyyydd"/>
 *     &lt;enumeration value="yyyymmdd"/>
 *     &lt;enumeration value="yymmdd"/>
 *     &lt;enumeration value="ddyymm"/>
 *     &lt;enumeration value="mmddyyyy"/>
 *     &lt;enumeration value="yyyy/mm/dd"/>
 *     &lt;enumeration value="ddyyyymm"/>
 *     &lt;enumeration value="dd-mmm-yy"/>
 *     &lt;enumeration value="ddmmyyyy"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "DateFormat")
@XmlEnum
public enum DateFormat {

    @XmlEnumValue("mmddyy")
    MMDDYY("mmddyy"),
    @XmlEnumValue("yyddmm")
    YYDDMM("yyddmm"),
    @XmlEnumValue("mmyydd")
    MMYYDD("mmyydd"),
    @XmlEnumValue("dmmyy")
    DMMYY("dmmyy"),
    @XmlEnumValue("yyyyddmm")
    YYYYDDMM("yyyyddmm"),
    @XmlEnumValue("mmyyyydd")
    MMYYYYDD("mmyyyydd"),
    @XmlEnumValue("yyyymmdd")
    YYYYMMDD("yyyymmdd"),
    @XmlEnumValue("yymmdd")
    YYMMDD("yymmdd"),
    @XmlEnumValue("ddyymm")
    DDYYMM("ddyymm"),
    @XmlEnumValue("mmddyyyy")
    MMDDYYYY("mmddyyyy"),
    @XmlEnumValue("yyyy/mm/dd")
    YYYY_MM_DD("yyyy/mm/dd"),
    @XmlEnumValue("ddyyyymm")
    DDYYYYMM("ddyyyymm"),
    @XmlEnumValue("dd-mmm-yy")
    DD_MMM_YY("dd-mmm-yy"),
    @XmlEnumValue("ddmmyyyy")
    DDMMYYYY("ddmmyyyy");
    private final String value;

    DateFormat(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static DateFormat fromValue(String v) {
        for (DateFormat c: DateFormat.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
