
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 				Scheduled Response consists of various PerSecurity files submitted
 * 				previously and scheduled for running at specified intervals
 * 			
 * 
 * <p>Java class for ScheduledResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScheduledResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headers" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}ScheduledHeaders" minOccurs="0"/>
 *         &lt;element name="fields" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Fields" minOccurs="0"/>
 *         &lt;element name="bvalfieldsets" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}BvalFieldSets" minOccurs="0"/>
 *         &lt;element name="fieldsets" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}FieldSets" minOccurs="0"/>
 *         &lt;element name="instruments" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Instruments" minOccurs="0"/>
 *         &lt;element name="responseId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}time" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScheduledResponse", propOrder = {
    "headers",
    "fields",
    "bvalfieldsets",
    "fieldsets",
    "instruments",
    "responseId",
    "time"
})
public class ScheduledResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected ScheduledHeaders headers;
    protected Fields fields;
    protected BvalFieldSets bvalfieldsets;
    protected FieldSets fieldsets;
    protected Instruments instruments;
    protected String responseId;
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar time;

    /**
     * Gets the value of the headers property.
     * 
     * @return
     *     possible object is
     *     {@link ScheduledHeaders }
     *     
     */
    public ScheduledHeaders getHeaders() {
        return headers;
    }

    /**
     * Sets the value of the headers property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScheduledHeaders }
     *     
     */
    public void setHeaders(ScheduledHeaders value) {
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
     * Gets the value of the bvalfieldsets property.
     * 
     * @return
     *     possible object is
     *     {@link BvalFieldSets }
     *     
     */
    public BvalFieldSets getBvalfieldsets() {
        return bvalfieldsets;
    }

    /**
     * Sets the value of the bvalfieldsets property.
     * 
     * @param value
     *     allowed object is
     *     {@link BvalFieldSets }
     *     
     */
    public void setBvalfieldsets(BvalFieldSets value) {
        this.bvalfieldsets = value;
    }

    /**
     * Gets the value of the fieldsets property.
     * 
     * @return
     *     possible object is
     *     {@link FieldSets }
     *     
     */
    public FieldSets getFieldsets() {
        return fieldsets;
    }

    /**
     * Sets the value of the fieldsets property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldSets }
     *     
     */
    public void setFieldsets(FieldSets value) {
        this.fieldsets = value;
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
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTime(XMLGregorianCalendar value) {
        this.time = value;
    }

}
