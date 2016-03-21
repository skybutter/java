
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetCompanyHeaders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCompanyHeaders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="creditrisk" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dateformat" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}DateFormat" minOccurs="0"/>
 *         &lt;element name="programflag" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}ProgramFlag" minOccurs="0"/>
 *         &lt;element name="rundate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secid" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}InstrumentType" minOccurs="0"/>
 *         &lt;element name="sn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="specialchar" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}SpecialChar" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usernumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="version" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Version" minOccurs="0"/>
 *         &lt;element name="ws" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="yellowkey" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}MarketSector" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCompanyHeaders", propOrder = {

})
public class GetCompanyHeaders
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected boolean creditrisk;
    protected DateFormat dateformat;
    protected ProgramFlag programflag;
    protected String rundate;
    protected InstrumentType secid;
    protected Integer sn;
    protected SpecialChar specialchar;
    protected String time;
    protected Integer usernumber;
    protected Version version;
    protected Integer ws;
    protected MarketSector yellowkey;

    /**
     * Gets the value of the creditrisk property.
     * 
     */
    public boolean isCreditrisk() {
        return creditrisk;
    }

    /**
     * Sets the value of the creditrisk property.
     * 
     */
    public void setCreditrisk(boolean value) {
        this.creditrisk = value;
    }

    /**
     * Gets the value of the dateformat property.
     * 
     * @return
     *     possible object is
     *     {@link DateFormat }
     *     
     */
    public DateFormat getDateformat() {
        return dateformat;
    }

    /**
     * Sets the value of the dateformat property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateFormat }
     *     
     */
    public void setDateformat(DateFormat value) {
        this.dateformat = value;
    }

    /**
     * Gets the value of the programflag property.
     * 
     * @return
     *     possible object is
     *     {@link ProgramFlag }
     *     
     */
    public ProgramFlag getProgramflag() {
        return programflag;
    }

    /**
     * Sets the value of the programflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProgramFlag }
     *     
     */
    public void setProgramflag(ProgramFlag value) {
        this.programflag = value;
    }

    /**
     * Gets the value of the rundate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRundate() {
        return rundate;
    }

    /**
     * Sets the value of the rundate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRundate(String value) {
        this.rundate = value;
    }

    /**
     * Gets the value of the secid property.
     * 
     * @return
     *     possible object is
     *     {@link InstrumentType }
     *     
     */
    public InstrumentType getSecid() {
        return secid;
    }

    /**
     * Sets the value of the secid property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstrumentType }
     *     
     */
    public void setSecid(InstrumentType value) {
        this.secid = value;
    }

    /**
     * Gets the value of the sn property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSn() {
        return sn;
    }

    /**
     * Sets the value of the sn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSn(Integer value) {
        this.sn = value;
    }

    /**
     * Gets the value of the specialchar property.
     * 
     * @return
     *     possible object is
     *     {@link SpecialChar }
     *     
     */
    public SpecialChar getSpecialchar() {
        return specialchar;
    }

    /**
     * Sets the value of the specialchar property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpecialChar }
     *     
     */
    public void setSpecialchar(SpecialChar value) {
        this.specialchar = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTime(String value) {
        this.time = value;
    }

    /**
     * Gets the value of the usernumber property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUsernumber() {
        return usernumber;
    }

    /**
     * Sets the value of the usernumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUsernumber(Integer value) {
        this.usernumber = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Version }
     *     
     */
    public Version getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Version }
     *     
     */
    public void setVersion(Version value) {
        this.version = value;
    }

    /**
     * Gets the value of the ws property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWs() {
        return ws;
    }

    /**
     * Sets the value of the ws property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWs(Integer value) {
        this.ws = value;
    }

    /**
     * Gets the value of the yellowkey property.
     * 
     * @return
     *     possible object is
     *     {@link MarketSector }
     *     
     */
    public MarketSector getYellowkey() {
        return yellowkey;
    }

    /**
     * Sets the value of the yellowkey property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarketSector }
     *     
     */
    public void setYellowkey(MarketSector value) {
        this.yellowkey = value;
    }

}
