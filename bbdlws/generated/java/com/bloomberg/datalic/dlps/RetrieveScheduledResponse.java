
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RetrieveScheduledResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveScheduledResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}PerSecurityResponse">
 *       &lt;sequence>
 *         &lt;element name="responseId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fileDatas" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}ScheduledResponses" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveScheduledResponse", propOrder = {
    "responseId",
    "fileDatas"
})
public class RetrieveScheduledResponse
    extends PerSecurityResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String responseId;
    protected ScheduledResponses fileDatas;

    /**
     * Gets the value of the responseId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseId() {
        return responseId;
    }

    /**
     * Sets the value of the responseId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseId(String value) {
        this.responseId = value;
    }

    /**
     * Gets the value of the fileDatas property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledResponses }
     *     
     */
    public ScheduledResponses getFileDatas() {
        return fileDatas;
    }

    /**
     * Sets the value of the fileDatas property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledResponses }
     *     
     */
    public void setFileDatas(ScheduledResponses value) {
        this.fileDatas = value;
    }

}
