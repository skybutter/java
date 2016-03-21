
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFundamentalsHeaders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFundamentalsHeaders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="filingstatus" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}FilingStatus" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="daterange" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}DateRange"/>
 *         &lt;element name="periodicity" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Periodicity" minOccurs="0"/>
 *         &lt;element name="consolidated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="adjusted" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="programflag" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}ProgramFlag" minOccurs="0"/>
 *         &lt;element name="rundate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secid" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}InstrumentType" minOccurs="0"/>
 *         &lt;element name="sn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "GetFundamentalsHeaders", propOrder = {

})
public class GetFundamentalsHeaders
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected FilingStatus filingstatus;
    protected String currency;
    @XmlElement(required = true)
    protected DateRange daterange;
    protected Periodicity periodicity;
    protected Boolean consolidated;
    protected Boolean adjusted;
    protected ProgramFlag programflag;
    protected String rundate;
    protected String time;
    protected InstrumentType secid;
    protected Integer sn;
    protected Integer usernumber;
    protected Version version;
    protected Integer ws;
    protected MarketSector yellowkey;

    /**
     * Gets the value of the filingstatus property.
     * 
     * @return
     *     possible object is
     *     {@link FilingStatus }
     *     
     */
    public FilingStatus getFilingstatus() {
        return filingstatus;
    }

    /**
     * Sets the value of the filingstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingStatus }
     *     
     */
    public void setFilingstatus(FilingStatus value) {
        this.filingstatus = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the daterange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRange }
     *     
     */
    public DateRange getDaterange() {
        return daterange;
    }

    /**
     * Sets the value of the daterange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRange }
     *     
     */
    public void setDaterange(DateRange value) {
        this.daterange = value;
    }

    /**
     * Gets the value of the periodicity property.
     * 
     * @return
     *     possible object is
     *     {@link Periodicity }
     *     
     */
    public Periodicity getPeriodicity() {
        return periodicity;
    }

    /**
     * Sets the value of the periodicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Periodicity }
     *     
     */
    public void setPeriodicity(Periodicity value) {
        this.periodicity = value;
    }

    /**
     * Gets the value of the consolidated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConsolidated() {
        return consolidated;
    }

    /**
     * Sets the value of the consolidated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConsolidated(Boolean value) {
        this.consolidated = value;
    }

    /**
     * Gets the value of the adjusted property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAdjusted() {
        return adjusted;
    }

    /**
     * Sets the value of the adjusted property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAdjusted(Boolean value) {
        this.adjusted = value;
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
