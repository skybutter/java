
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SecondaryQualifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecondaryQualifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="secondaryQualifierType" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}SecondaryQualifierType"/>
 *         &lt;element name="secondaryQualifierOperator" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}SecondaryQualifierOperator"/>
 *         &lt;element name="secondaryQualifierValue" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecondaryQualifier", propOrder = {
    "secondaryQualifierType",
    "secondaryQualifierOperator",
    "secondaryQualifierValue"
})
public class SecondaryQualifier
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected SecondaryQualifierType secondaryQualifierType;
    @XmlElement(required = true)
    protected SecondaryQualifierOperator secondaryQualifierOperator;
    @XmlElement(required = true)
    protected String secondaryQualifierValue;

    /**
     * Gets the value of the secondaryQualifierType property.
     * 
     * @return
     *     possible object is
     *     {@link SecondaryQualifierType }
     *     
     */
    public SecondaryQualifierType getSecondaryQualifierType() {
        return secondaryQualifierType;
    }

    /**
     * Sets the value of the secondaryQualifierType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecondaryQualifierType }
     *     
     */
    public void setSecondaryQualifierType(SecondaryQualifierType value) {
        this.secondaryQualifierType = value;
    }

    /**
     * Gets the value of the secondaryQualifierOperator property.
     * 
     * @return
     *     possible object is
     *     {@link SecondaryQualifierOperator }
     *     
     */
    public SecondaryQualifierOperator getSecondaryQualifierOperator() {
        return secondaryQualifierOperator;
    }

    /**
     * Sets the value of the secondaryQualifierOperator property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecondaryQualifierOperator }
     *     
     */
    public void setSecondaryQualifierOperator(SecondaryQualifierOperator value) {
        this.secondaryQualifierOperator = value;
    }

    /**
     * Gets the value of the secondaryQualifierValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecondaryQualifierValue() {
        return secondaryQualifierValue;
    }

    /**
     * Sets the value of the secondaryQualifierValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecondaryQualifierValue(String value) {
        this.secondaryQualifierValue = value;
    }

}
