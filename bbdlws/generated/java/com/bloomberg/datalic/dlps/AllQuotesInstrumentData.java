
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				The allquotes data for an instrument
 * 			
 * 
 * <p>Java class for AllQuotesInstrumentData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AllQuotesInstrumentData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instrument" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Instrument" minOccurs="0"/>
 *         &lt;element name="macro" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Macro" minOccurs="0"/>
 *         &lt;element name="pcs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quotes" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}QRMQuotes" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllQuotesInstrumentData", propOrder = {
    "instrument",
    "macro",
    "pcs",
    "quotes",
    "code"
})
public class AllQuotesInstrumentData
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Instrument instrument;
    protected Macro macro;
    protected String pcs;
    protected QRMQuotes quotes;
    @XmlElement(required = true)
    protected String code;

    /**
     * Gets the value of the instrument property.
     * 
     * @return
     *     possible object is
     *     {@link Instrument }
     *     
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * Sets the value of the instrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instrument }
     *     
     */
    public void setInstrument(Instrument value) {
        this.instrument = value;
    }

    /**
     * Gets the value of the macro property.
     * 
     * @return
     *     possible object is
     *     {@link Macro }
     *     
     */
    public Macro getMacro() {
        return macro;
    }

    /**
     * Sets the value of the macro property.
     * 
     * @param value
     *     allowed object is
     *     {@link Macro }
     *     
     */
    public void setMacro(Macro value) {
        this.macro = value;
    }

    /**
     * Gets the value of the pcs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPcs() {
        return pcs;
    }

    /**
     * Sets the value of the pcs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPcs(String value) {
        this.pcs = value;
    }

    /**
     * Gets the value of the quotes property.
     * 
     * @return
     *     possible object is
     *     {@link QRMQuotes }
     *     
     */
    public QRMQuotes getQuotes() {
        return quotes;
    }

    /**
     * Sets the value of the quotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link QRMQuotes }
     *     
     */
    public void setQuotes(QRMQuotes value) {
        this.quotes = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

}
