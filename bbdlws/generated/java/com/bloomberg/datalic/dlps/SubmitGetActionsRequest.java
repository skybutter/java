
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubmitGetActionsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmitGetActionsRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headers" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}GetActionsHeaders"/>
 *         &lt;element name="instruments" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Instruments"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitGetActionsRequest", propOrder = {
    "headers",
    "instruments"
})
public class SubmitGetActionsRequest
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected GetActionsHeaders headers;
    @XmlElement(required = true)
    protected Instruments instruments;

    /**
     * Gets the value of the headers property.
     * 
     * @return
     *     possible object is
     *     {@link GetActionsHeaders }
     *     
     */
    public GetActionsHeaders getHeaders() {
        return headers;
    }

    /**
     * Sets the value of the headers property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetActionsHeaders }
     *     
     */
    public void setHeaders(GetActionsHeaders value) {
        this.headers = value;
    }

    /**
     * Gets the value of the instruments property.
     * 
     * @return
     *     possible object is
     *     {@link Instruments }
     *     
     */
    public Instruments getInstruments() {
        return instruments;
    }

    /**
     * Sets the value of the instruments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instruments }
     *     
     */
    public void setInstruments(Instruments value) {
        this.instruments = value;
    }

}
