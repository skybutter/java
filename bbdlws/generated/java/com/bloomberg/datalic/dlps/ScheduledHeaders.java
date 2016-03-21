
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ScheduledHeaders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScheduledHeaders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getdataHeaders" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}GetDataHeaders" minOccurs="0"/>
 *         &lt;element name="gethistoryHeaders" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}GetHistoryHeaders" minOccurs="0"/>
 *         &lt;element name="getfundamentalsHeaders" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}GetFundamentalsHeaders" minOccurs="0"/>
 *         &lt;element name="getcompanyHeaders" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}GetCompanyHeaders" minOccurs="0"/>
 *         &lt;element name="getactionsHeaders" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}GetActionsHeaders" minOccurs="0"/>
 *         &lt;element name="getquotesHeaders" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}QuotesHeaders" minOccurs="0"/>
 *         &lt;element name="getallquotesHeaders" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}QuotesHeaders" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScheduledHeaders", propOrder = {
    "getdataHeaders",
    "gethistoryHeaders",
    "getfundamentalsHeaders",
    "getcompanyHeaders",
    "getactionsHeaders",
    "getquotesHeaders",
    "getallquotesHeaders"
})
public class ScheduledHeaders
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected GetDataHeaders getdataHeaders;
    protected GetHistoryHeaders gethistoryHeaders;
    protected GetFundamentalsHeaders getfundamentalsHeaders;
    protected GetCompanyHeaders getcompanyHeaders;
    protected GetActionsHeaders getactionsHeaders;
    protected QuotesHeaders getquotesHeaders;
    protected QuotesHeaders getallquotesHeaders;

    /**
     * Gets the value of the getdataHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link GetDataHeaders }
     *     
     */
    public GetDataHeaders getGetdataHeaders() {
        return getdataHeaders;
    }

    /**
     * Sets the value of the getdataHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetDataHeaders }
     *     
     */
    public void setGetdataHeaders(GetDataHeaders value) {
        this.getdataHeaders = value;
    }

    /**
     * Gets the value of the gethistoryHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link GetHistoryHeaders }
     *     
     */
    public GetHistoryHeaders getGethistoryHeaders() {
        return gethistoryHeaders;
    }

    /**
     * Sets the value of the gethistoryHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetHistoryHeaders }
     *     
     */
    public void setGethistoryHeaders(GetHistoryHeaders value) {
        this.gethistoryHeaders = value;
    }

    /**
     * Gets the value of the getfundamentalsHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link GetFundamentalsHeaders }
     *     
     */
    public GetFundamentalsHeaders getGetfundamentalsHeaders() {
        return getfundamentalsHeaders;
    }

    /**
     * Sets the value of the getfundamentalsHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFundamentalsHeaders }
     *     
     */
    public void setGetfundamentalsHeaders(GetFundamentalsHeaders value) {
        this.getfundamentalsHeaders = value;
    }

    /**
     * Gets the value of the getcompanyHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link GetCompanyHeaders }
     *     
     */
    public GetCompanyHeaders getGetcompanyHeaders() {
        return getcompanyHeaders;
    }

    /**
     * Sets the value of the getcompanyHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCompanyHeaders }
     *     
     */
    public void setGetcompanyHeaders(GetCompanyHeaders value) {
        this.getcompanyHeaders = value;
    }

    /**
     * Gets the value of the getactionsHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link GetActionsHeaders }
     *     
     */
    public GetActionsHeaders getGetactionsHeaders() {
        return getactionsHeaders;
    }

    /**
     * Sets the value of the getactionsHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetActionsHeaders }
     *     
     */
    public void setGetactionsHeaders(GetActionsHeaders value) {
        this.getactionsHeaders = value;
    }

    /**
     * Gets the value of the getquotesHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link QuotesHeaders }
     *     
     */
    public QuotesHeaders getGetquotesHeaders() {
        return getquotesHeaders;
    }

    /**
     * Sets the value of the getquotesHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuotesHeaders }
     *     
     */
    public void setGetquotesHeaders(QuotesHeaders value) {
        this.getquotesHeaders = value;
    }

    /**
     * Gets the value of the getallquotesHeaders property.
     * 
     * @return
     *     possible object is
     *     {@link QuotesHeaders }
     *     
     */
    public QuotesHeaders getGetallquotesHeaders() {
        return getallquotesHeaders;
    }

    /**
     * Sets the value of the getallquotesHeaders property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuotesHeaders }
     *     
     */
    public void setGetallquotesHeaders(QuotesHeaders value) {
        this.getallquotesHeaders = value;
    }

}
