
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveCancelResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveCancelResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}PerSecurityResponse">
 *       &lt;sequence>
 *         &lt;element name="headers" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}CancelHeaders" minOccurs="0"/>
 *         &lt;element name="cancelResponseStatus" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}CancelResponseStatus" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveCancelResponse", propOrder = {
    "headers",
    "cancelResponseStatus"
})
public class RetrieveCancelResponse
    extends PerSecurityResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected CancelHeaders headers;
    @XmlElement(required = true)
    protected List<CancelResponseStatus> cancelResponseStatus;

    /**
     * Gets the value of the headers property.
     * 
     * @return
     *     possible object is
     *     {@link CancelHeaders }
     *     
     */
    public CancelHeaders getHeaders() {
        return headers;
    }

    /**
     * Sets the value of the headers property.
     * 
     * @param value
     *     allowed object is
     *     {@link CancelHeaders }
     *     
     */
    public void setHeaders(CancelHeaders value) {
        this.headers = value;
    }

    /**
     * Gets the value of the cancelResponseStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cancelResponseStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCancelResponseStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CancelResponseStatus }
     * 
     * 
     */
    public List<CancelResponseStatus> getCancelResponseStatus() {
        if (cancelResponseStatus == null) {
            cancelResponseStatus = new ArrayList<CancelResponseStatus>();
        }
        return this.cancelResponseStatus;
    }

}
