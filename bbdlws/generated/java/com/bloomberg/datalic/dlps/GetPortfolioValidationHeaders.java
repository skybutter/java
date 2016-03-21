
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetPortfolioValidationHeaders complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPortfolioValidationHeaders">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="closingvalues" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dateformat" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}DateFormat" minOccurs="0"/>
 *         &lt;element name="derived" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="diffflag" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}DiffFlag" minOccurs="0"/>
 *         &lt;element name="hist_crncy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historical" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="programflag" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}ProgramFlag" minOccurs="0"/>
 *         &lt;element name="rundate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secid" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}InstrumentType" minOccurs="0"/>
 *         &lt;element name="secmaster" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sn" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="specialchar" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}SpecialChar" minOccurs="0"/>
 *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usernumber" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="version" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Version" minOccurs="0"/>
 *         &lt;element name="ws" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="yellowkey" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}MarketSector" minOccurs="0"/>
 *         &lt;element name="exclusive_pricing_src" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="bvaltier" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}BvalTier" minOccurs="0"/>
 *         &lt;element name="bvalsnapshot" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}BvalSnapshot" minOccurs="0"/>
 *         &lt;element name="bvalsnapshotdate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bvalbeta" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="pricing_source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="portsecdes" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}PortSecDes" minOccurs="0"/>
 *         &lt;element name="prp" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPortfolioValidationHeaders", propOrder = {

})
public class GetPortfolioValidationHeaders
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Boolean closingvalues;
    protected DateFormat dateformat;
    protected Boolean derived;
    protected DiffFlag diffflag;
    @XmlElement(name = "hist_crncy")
    protected String histCrncy;
    protected Boolean historical;
    protected ProgramFlag programflag;
    protected String rundate;
    protected InstrumentType secid;
    protected Boolean secmaster;
    protected Integer sn;
    protected SpecialChar specialchar;
    protected String time;
    protected String login;
    protected Integer usernumber;
    protected Version version;
    protected Integer ws;
    protected MarketSector yellowkey;
    @XmlElement(name = "exclusive_pricing_src")
    protected Boolean exclusivePricingSrc;
    protected Integer bvaltier;
    protected BvalSnapshot bvalsnapshot;
    protected String bvalsnapshotdate;
    protected Boolean bvalbeta;
    @XmlElement(name = "pricing_source")
    protected String pricingSource;
    protected PortSecDes portsecdes;
    protected Integer prp;

    /**
     * Gets the value of the closingvalues property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClosingvalues() {
        return closingvalues;
    }

    /**
     * Sets the value of the closingvalues property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClosingvalues(Boolean value) {
        this.closingvalues = value;
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
     * Gets the value of the derived property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDerived() {
        return derived;
    }

    /**
     * Sets the value of the derived property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDerived(Boolean value) {
        this.derived = value;
    }

    /**
     * Gets the value of the diffflag property.
     * 
     * @return
     *     possible object is
     *     {@link DiffFlag }
     *     
     */
    public DiffFlag getDiffflag() {
        return diffflag;
    }

    /**
     * Sets the value of the diffflag property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiffFlag }
     *     
     */
    public void setDiffflag(DiffFlag value) {
        this.diffflag = value;
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
     * Gets the value of the historical property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isHistorical() {
        return historical;
    }

    /**
     * Sets the value of the historical property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHistorical(Boolean value) {
        this.historical = value;
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
     * Gets the value of the secmaster property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSecmaster() {
        return secmaster;
    }

    /**
     * Sets the value of the secmaster property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSecmaster(Boolean value) {
        this.secmaster = value;
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
     * Gets the value of the bvaltier property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBvaltier() {
        return bvaltier;
    }

    /**
     * Sets the value of the bvaltier property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBvaltier(Integer value) {
        this.bvaltier = value;
    }

    /**
     * Gets the value of the bvalsnapshot property.
     * 
     * @return
     *     possible object is
     *     {@link BvalSnapshot }
     *     
     */
    public BvalSnapshot getBvalsnapshot() {
        return bvalsnapshot;
    }

    /**
     * Sets the value of the bvalsnapshot property.
     * 
     * @param value
     *     allowed object is
     *     {@link BvalSnapshot }
     *     
     */
    public void setBvalsnapshot(BvalSnapshot value) {
        this.bvalsnapshot = value;
    }

    /**
     * Gets the value of the bvalsnapshotdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBvalsnapshotdate() {
        return bvalsnapshotdate;
    }

    /**
     * Sets the value of the bvalsnapshotdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBvalsnapshotdate(String value) {
        this.bvalsnapshotdate = value;
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

}
