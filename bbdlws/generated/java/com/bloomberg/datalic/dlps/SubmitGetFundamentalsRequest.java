
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubmitGetFundamentalsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmitGetFundamentalsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headers" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}GetFundamentalsHeaders"/>
 *         &lt;element name="fields" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Fields"/>
 *         &lt;element name="instruments" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}FundInstruments"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitGetFundamentalsRequest", propOrder = {
    "headers",
    "fields",
    "instruments"
})
public class SubmitGetFundamentalsRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected GetFundamentalsHeaders headers;
    @XmlElement(required = true)
    protected Fields fields;
    @XmlElement(required = true)
    protected FundInstruments instruments;

    /**
     * Gets the value of the headers property.
     * 
     * @return
     *     possible object is
     *     {@link GetFundamentalsHeaders }
     *     
     */
    public GetFundamentalsHeaders getHeaders() {
        return headers;
    }

    /**
     * Sets the value of the headers property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFundamentalsHeaders }
     *     
     */
    public void setHeaders(GetFundamentalsHeaders value) {
        this.headers = value;
    }

    /**
     * Gets the value of the fields property.
     * 
     * @return
     *     possible object is
     *     {@link Fields }
     *     
     */
    public Fields getFields() {
        return fields;
    }

    /**
     * Sets the value of the fields property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fields }
     *     
     */
    public void setFields(Fields value) {
        this.fields = value;
    }

    /**
     * Gets the value of the instruments property.
     * 
     * @return
     *     possible object is
     *     {@link FundInstruments }
     *     
     */
    public FundInstruments getInstruments() {
        return instruments;
    }

    /**
     * Sets the value of the instruments property.
     * 
     * @param value
     *     allowed object is
     *     {@link FundInstruments }
     *     
     */
    public void setInstruments(FundInstruments value) {
        this.instruments = value;
    }

}
