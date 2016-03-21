
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FundInstrument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FundInstrument">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="yellowkey" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}MarketSector" minOccurs="0"/>
 *         &lt;element name="type" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}InstrumentType" minOccurs="0"/>
 *         &lt;element name="overrides" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Overrides" minOccurs="0"/>
 *         &lt;element name="period" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Period" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FundInstrument", propOrder = {
    "id",
    "yellowkey",
    "type",
    "overrides",
    "period"
})
public class FundInstrument
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String id;
    protected MarketSector yellowkey;
    protected InstrumentType type;
    protected Overrides overrides;
    protected Period period;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link InstrumentType }
     *     
     */
    public InstrumentType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link InstrumentType }
     *     
     */
    public void setType(InstrumentType value) {
        this.type = value;
    }

    /**
     * Gets the value of the overrides property.
     * 
     * @return
     *     possible object is
     *     {@link Overrides }
     *     
     */
    public Overrides getOverrides() {
        return overrides;
    }

    /**
     * Sets the value of the overrides property.
     * 
     * @param value
     *     allowed object is
     *     {@link Overrides }
     *     
     */
    public void setOverrides(Overrides value) {
        this.overrides = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link Period }
     *     
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link Period }
     *     
     */
    public void setPeriod(Period value) {
        this.period = value;
    }

}
