
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				These fields are standard for all corporate actions
 * 			
 * 
 * <p>Java class for ActionStandardFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActionStandardFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="companyId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="securityId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="actionId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="mnemonic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="flag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secIdType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="secId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marketSectorDes" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}MarketSector" minOccurs="0"/>
 *         &lt;element name="bbUnique" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="announceDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="effectiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amendDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bbGlobal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bbGlobalCompany" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="bbSecNumDes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="feedSource" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionStandardFields", propOrder = {
    "companyId",
    "securityId",
    "actionId",
    "mnemonic",
    "flag",
    "companyName",
    "secIdType",
    "secId",
    "currency",
    "marketSectorDes",
    "bbUnique",
    "announceDate",
    "effectiveDate",
    "amendDate",
    "bbGlobal",
    "bbGlobalCompany",
    "bbSecNumDes",
    "feedSource"
})
public class ActionStandardFields
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected Integer companyId;
    protected Integer securityId;
    protected Integer actionId;
    protected String mnemonic;
    protected String flag;
    protected String companyName;
    protected String secIdType;
    protected String secId;
    protected String currency;
    protected MarketSector marketSectorDes;
    protected String bbUnique;
    protected String announceDate;
    protected String effectiveDate;
    protected String amendDate;
    protected String bbGlobal;
    protected String bbGlobalCompany;
    protected String bbSecNumDes;
    protected String feedSource;

    /**
     * Gets the value of the companyId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * Sets the value of the companyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCompanyId(Integer value) {
        this.companyId = value;
    }

    /**
     * Gets the value of the securityId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSecurityId() {
        return securityId;
    }

    /**
     * Sets the value of the securityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSecurityId(Integer value) {
        this.securityId = value;
    }

    /**
     * Gets the value of the actionId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getActionId() {
        return actionId;
    }

    /**
     * Sets the value of the actionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setActionId(Integer value) {
        this.actionId = value;
    }

    /**
     * Gets the value of the mnemonic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMnemonic() {
        return mnemonic;
    }

    /**
     * Sets the value of the mnemonic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMnemonic(String value) {
        this.mnemonic = value;
    }

    /**
     * Gets the value of the flag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFlag() {
        return flag;
    }

    /**
     * Sets the value of the flag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFlag(String value) {
        this.flag = value;
    }

    /**
     * Gets the value of the companyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the value of the companyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompanyName(String value) {
        this.companyName = value;
    }

    /**
     * Gets the value of the secIdType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecIdType() {
        return secIdType;
    }

    /**
     * Sets the value of the secIdType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecIdType(String value) {
        this.secIdType = value;
    }

    /**
     * Gets the value of the secId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecId() {
        return secId;
    }

    /**
     * Sets the value of the secId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecId(String value) {
        this.secId = value;
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
     * Gets the value of the marketSectorDes property.
     * 
     * @return
     *     possible object is
     *     {@link MarketSector }
     *     
     */
    public MarketSector getMarketSectorDes() {
        return marketSectorDes;
    }

    /**
     * Sets the value of the marketSectorDes property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarketSector }
     *     
     */
    public void setMarketSectorDes(MarketSector value) {
        this.marketSectorDes = value;
    }

    /**
     * Gets the value of the bbUnique property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBbUnique() {
        return bbUnique;
    }

    /**
     * Sets the value of the bbUnique property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBbUnique(String value) {
        this.bbUnique = value;
    }

    /**
     * Gets the value of the announceDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnnounceDate() {
        return announceDate;
    }

    /**
     * Sets the value of the announceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnnounceDate(String value) {
        this.announceDate = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the amendDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendDate() {
        return amendDate;
    }

    /**
     * Sets the value of the amendDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendDate(String value) {
        this.amendDate = value;
    }

    /**
     * Gets the value of the bbGlobal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBbGlobal() {
        return bbGlobal;
    }

    /**
     * Sets the value of the bbGlobal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBbGlobal(String value) {
        this.bbGlobal = value;
    }

    /**
     * Gets the value of the bbGlobalCompany property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBbGlobalCompany() {
        return bbGlobalCompany;
    }

    /**
     * Sets the value of the bbGlobalCompany property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBbGlobalCompany(String value) {
        this.bbGlobalCompany = value;
    }

    /**
     * Gets the value of the bbSecNumDes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBbSecNumDes() {
        return bbSecNumDes;
    }

    /**
     * Sets the value of the bbSecNumDes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBbSecNumDes(String value) {
        this.bbSecNumDes = value;
    }

    /**
     * Gets the value of the feedSource property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeedSource() {
        return feedSource;
    }

    /**
     * Sets the value of the feedSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeedSource(String value) {
        this.feedSource = value;
    }

}
