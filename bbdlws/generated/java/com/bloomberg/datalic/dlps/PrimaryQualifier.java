
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrimaryQualifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PrimaryQualifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primaryQualifierType" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}MacroType"/>
 *         &lt;element name="primaryQualifierValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PrimaryQualifier", propOrder = {
    "primaryQualifierType",
    "primaryQualifierValue"
})
public class PrimaryQualifier
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected MacroType primaryQualifierType;
    @XmlElement(required = true)
    protected String primaryQualifierValue;

    /**
     * Gets the value of the primaryQualifierType property.
     * 
     * @return
     *     possible object is
     *     {@link MacroType }
     *     
     */
    public MacroType getPrimaryQualifierType() {
        return primaryQualifierType;
    }

    /**
     * Sets the value of the primaryQualifierType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MacroType }
     *     
     */
    public void setPrimaryQualifierType(MacroType value) {
        this.primaryQualifierType = value;
    }

    /**
     * Gets the value of the primaryQualifierValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryQualifierValue() {
        return primaryQualifierValue;
    }

    /**
     * Sets the value of the primaryQualifierValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryQualifierValue(String value) {
        this.primaryQualifierValue = value;
    }

}
