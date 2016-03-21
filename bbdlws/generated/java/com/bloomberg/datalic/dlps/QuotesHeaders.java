
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QuotesHeaders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QuotesHeaders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="daterange" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}DateRange" minOccurs="0"/>
 *         &lt;element name="datetimerange" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}DateTimeRange" minOccurs="0"/>
 *         &lt;element name="displayqrmdate" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="portsecdes" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}PortSecDes" minOccurs="0"/>
 *         &lt;element name="pricing_source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="programflag" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}ProgramFlag" minOccurs="0"/>
 *         &lt;element name="prp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="rundate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secid" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}InstrumentType" minOccurs="0"/>
 *         &lt;element name="sn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="tickexchlength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="ticklocaltz" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="tickoutputtz" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}TickOutputTz" minOccurs="0"/>
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
@XmlType(name = "QuotesHeaders", propOrder = {

})
public class QuotesHeaders
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected DateRange daterange;
    protected DateTimeRange datetimerange;
    protected Boolean displayqrmdate;
    protected String login;
    protected PortSecDes portsecdes;
    @XmlElement(name = "pricing_source")
    protected String pricingSource;
    protected ProgramFlag programflag;
    protected Integer prp;
    protected String rundate;
    protected InstrumentType secid;
    protected Integer sn;
    protected Integer tickexchlength;
    protected Boolean ticklocaltz;
    protected TickOutputTz tickoutputtz;
    protected String time;
    protected Integer usernumber;
    protected Version version;
    protected Integer ws;
    protected MarketSector yellowkey;

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
     * Gets the value of the datetimerange property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeRange }
     *     
     */
    public DateTimeRange getDatetimerange() {
        return datetimerange;
    }

    /**
     * Sets the value of the datetimerange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeRange }
     *     
     */
    public void setDatetimerange(DateTimeRange value) {
        this.datetimerange = value;
    }

    /**
     * Gets the value of the displayqrmdate property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisplayqrmdate() {
        return displayqrmdate;
    }

    /**
     * Sets the value of the displayqrmdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisplayqrmdate(Boolean value) {
        this.displayqrmdate = value;
    }

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the portsecdes property.
     * 
     * @return
     *     possible object is
     *     {@link PortSecDes }
     *     
     */
    public PortSecDes getPortsecdes() {
        return portsecdes;
    }

    /**
     * Sets the value of the portsecdes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PortSecDes }
     *     
     */
    public void setPortsecdes(PortSecDes value) {
        this.portsecdes = value;
    }

    /**
     * Gets the value of the pricingSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPricingSource() {
        return pricingSource;
    }

    /**
     * Sets the value of the pricingSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPricingSource(String value) {
        this.pricingSource = value;
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
     * Gets the value of the prp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPrp() {
        return prp;
    }

    /**
     * Sets the value of the prp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPrp(Integer value) {
        this.prp = value;
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
     * Gets the value of the tickexchlength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTickexchlength() {
        return tickexchlength;
    }

    /**
     * Sets the value of the tickexchlength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTickexchlength(Integer value) {
        this.tickexchlength = value;
    }

    /**
     * Gets the value of the ticklocaltz property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isTicklocaltz() {
        return ticklocaltz;
    }

    /**
     * Sets the value of the ticklocaltz property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTicklocaltz(Boolean value) {
        this.ticklocaltz = value;
    }

    /**
     * Gets the value of the tickoutputtz property.
     * 
     * @return
     *     possible object is
     *     {@link TickOutputTz }
     *     
     */
    public TickOutputTz getTickoutputtz() {
        return tickoutputtz;
    }

    /**
     * Sets the value of the tickoutputtz property.
     * 
     * @param value
     *     allowed object is
     *     {@link TickOutputTz }
     *     
     */
    public void setTickoutputtz(TickOutputTz value) {
        this.tickoutputtz = value;
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
