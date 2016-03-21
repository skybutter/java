
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetHistoryHeaders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetHistoryHeaders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="daterange" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}DateRange" minOccurs="0"/>
 *         &lt;element name="hist_crncy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hist_period" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}HistPeriod" minOccurs="0"/>
 *         &lt;element name="hist_option" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}HistOption" minOccurs="0"/>
 *         &lt;element name="programflag" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}ProgramFlag" minOccurs="0"/>
 *         &lt;element name="pricing_source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="display_pricing_src" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="rundate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secid" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}InstrumentType" minOccurs="0"/>
 *         &lt;element name="sn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usernumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="version" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Version" minOccurs="0"/>
 *         &lt;element name="ws" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="yellowkey" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}MarketSector" minOccurs="0"/>
 *         &lt;element name="portsecdes" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}PortSecDes" minOccurs="0"/>
 *         &lt;element name="prp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="exclusive_pricing_src" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="bvalbeta" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="regfvhl" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="regtransparency" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetHistoryHeaders", propOrder = {

})
public class GetHistoryHeaders
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected DateRange daterange;
    @XmlElement(name = "hist_crncy")
    protected String histCrncy;
    @XmlElement(name = "hist_period")
    protected HistPeriod histPeriod;
    @XmlElement(name = "hist_option")
    protected HistOption histOption;
    protected ProgramFlag programflag;
    @XmlElement(name = "pricing_source")
    protected String pricingSource;
    @XmlElement(name = "display_pricing_src")
    protected Boolean displayPricingSrc;
    protected String rundate;
    protected String time;
    protected InstrumentType secid;
    protected Integer sn;
    protected String login;
    protected Integer usernumber;
    protected Version version;
    protected Integer ws;
    protected MarketSector yellowkey;
    protected PortSecDes portsecdes;
    protected Integer prp;
    @XmlElement(name = "exclusive_pricing_src")
    protected Boolean exclusivePricingSrc;
    protected Boolean bvalbeta;
    protected Boolean regfvhl;
    protected Boolean regtransparency;

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
     * Gets the value of the histCrncy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHistCrncy() {
        return histCrncy;
    }

    /**
     * Sets the value of the histCrncy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHistCrncy(String value) {
        this.histCrncy = value;
    }

    /**
     * Gets the value of the histPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link HistPeriod }
     *     
     */
    public HistPeriod getHistPeriod() {
        return histPeriod;
    }

    /**
     * Sets the value of the histPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistPeriod }
     *     
     */
    public void setHistPeriod(HistPeriod value) {
        this.histPeriod = value;
    }

    /**
     * Gets the value of the histOption property.
     * 
     * @return
     *     possible object is
     *     {@link HistOption }
     *     
     */
    public HistOption getHistOption() {
        return histOption;
    }

    /**
     * Sets the value of the histOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistOption }
     *     
     */
    public void setHistOption(HistOption value) {
        this.histOption = value;
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
     * Gets the value of the displayPricingSrc property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDisplayPricingSrc() {
        return displayPricingSrc;
    }

    /**
     * Sets the value of the displayPricingSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDisplayPricingSrc(Boolean value) {
        this.displayPricingSrc = value;
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
     * Gets the value of the exclusivePricingSrc property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExclusivePricingSrc() {
        return exclusivePricingSrc;
    }

    /**
     * Sets the value of the exclusivePricingSrc property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExclusivePricingSrc(Boolean value) {
        this.exclusivePricingSrc = value;
    }

    /**
     * Gets the value of the bvalbeta property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBvalbeta() {
        return bvalbeta;
    }

    /**
     * Sets the value of the bvalbeta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBvalbeta(Boolean value) {
        this.bvalbeta = value;
    }

    /**
     * Gets the value of the regfvhl property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRegfvhl() {
        return regfvhl;
    }

    /**
     * Sets the value of the regfvhl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRegfvhl(Boolean value) {
        this.regfvhl = value;
    }

    /**
     * Gets the value of the regtransparency property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRegtransparency() {
        return regtransparency;
    }

    /**
     * Sets the value of the regtransparency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRegtransparency(Boolean value) {
        this.regtransparency = value;
    }

}
