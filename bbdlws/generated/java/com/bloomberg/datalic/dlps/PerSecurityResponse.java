
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PerSecurityResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PerSecurityResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="statusCode" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}ResponseStatus"/>
 *         &lt;element name="requestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PerSecurityResponse", propOrder = {
    "statusCode",
    "requestId"
})
@XmlSeeAlso({
    GetPortfolioValidationResponse.class,
    RetrieveScheduledResponse.class,
    RetrieveGetDataResponse.class,
    GetCorrectionsResponse.class,
    RetrieveGetAllQuotesResponse.class,
    SubmitGetAllQuotesResponse.class,
    SubmitOtcBvalDealsUploadResponse.class,
    RetrieveGetFundamentalsResponse.class,
    SubmitCancelResponse.class,
    SubmitGetActionsResponse.class,
    SubmitMmktBvalDealsUploadResponse.class,
    RetrieveCancelResponse.class,
    RetrieveOtcBvalDealsUploadResponse.class,
    SubmitGetDataResponse.class,
    SubmitGetQuotesResponse.class,
    SubmitOtcbvalUploadResponse.class,
    RetrieveGetCompanyResponse.class,
    SubmitGetCompanyResponse.class,
    RetrieveOtcbvalUploadResponse.class,
    RetrieveMmktBvalDealsUploadResponse.class,
    RetrieveGetHistoryResponse.class,
    RetrieveGetActionsResponse.class,
    GetFieldsResponse.class,
    SubmitScheduledResponse.class,
    SubmitGetHistoryResponse.class,
    SubmitGetFundamentalsResponse.class,
    RetrieveGetQuotesResponse.class
})
public class PerSecurityResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected ResponseStatus statusCode;
    @XmlElement(required = true)
    protected String requestId;

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseStatus }
     *     
     */
    public ResponseStatus getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseStatus }
     *     
     */
    public void setStatusCode(ResponseStatus value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

}
