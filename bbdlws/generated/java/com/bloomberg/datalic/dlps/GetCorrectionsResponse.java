
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GetCorrectionsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCorrectionsResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}PerSecurityResponse">
 *       &lt;sequence>
 *         &lt;element name="headers" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}GetCorrectionsHeaders" minOccurs="0"/>
 *         &lt;element name="timestarted" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="correctionRecords" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}CorrectionRecords" minOccurs="0"/>
 *         &lt;element name="timefinished" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCorrectionsResponse", propOrder = {
    "headers",
    "timestarted",
    "correctionRecords",
    "timefinished"
})
public class GetCorrectionsResponse
    extends PerSecurityResponse
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected GetCorrectionsHeaders headers;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestarted;
    protected CorrectionRecords correctionRecords;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timefinished;

    /**
     * Gets the value of the headers property.
     * 
     * @return
     *     possible object is
     *     {@link GetCorrectionsHeaders }
     *     
     */
    public GetCorrectionsHeaders getHeaders() {
        return headers;
    }

    /**
     * Sets the value of the headers property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCorrectionsHeaders }
     *     
     */
    public void setHeaders(GetCorrectionsHeaders value) {
        this.headers = value;
    }

    /**
     * Gets the value of the timestarted property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestarted() {
        return timestarted;
    }

    /**
     * Sets the value of the timestarted property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestarted(XMLGregorianCalendar value) {
        this.timestarted = value;
    }

    /**
     * Gets the value of the correctionRecords property.
     * 
     * @return
     *     possible object is
     *     {@link CorrectionRecords }
     *     
     */
    public CorrectionRecords getCorrectionRecords() {
        return correctionRecords;
    }

    /**
     * Sets the value of the correctionRecords property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectionRecords }
     *     
     */
    public void setCorrectionRecords(CorrectionRecords value) {
        this.correctionRecords = value;
    }

    /**
     * Gets the value of the timefinished property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimefinished() {
        return timefinished;
    }

    /**
     * Sets the value of the timefinished property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimefinished(XMLGregorianCalendar value) {
        this.timefinished = value;
    }

}
