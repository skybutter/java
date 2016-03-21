
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				The Corporate Actions data for an instrument
 * 			
 * 
 * <p>Java class for ActionsInstrumentData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActionsInstrumentData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instrument" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Instrument" minOccurs="0"/>
 *         &lt;element name="macro" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Macro" minOccurs="0"/>
 *         &lt;element name="standardFields" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}ActionStandardFields" minOccurs="0"/>
 *         &lt;element name="data" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}Data" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionsInstrumentData", propOrder = {
    "code",
    "instrument",
    "macro",
    "standardFields",
    "data"
})
public class ActionsInstrumentData
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    @XmlElement(required = true)
    protected String code;
    protected Instrument instrument;
    protected Macro macro;
    protected ActionStandardFields standardFields;
    protected List<Data> data;

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the instrument property.
     * 
     * @return
     *     possible object is
     *     {@link Instrument }
     *     
     */
    public Instrument getInstrument() {
        return instrument;
    }

    /**
     * Sets the value of the instrument property.
     * 
     * @param value
     *     allowed object is
     *     {@link Instrument }
     *     
     */
    public void setInstrument(Instrument value) {
        this.instrument = value;
    }

    /**
     * Gets the value of the macro property.
     * 
     * @return
     *     possible object is
     *     {@link Macro }
     *     
     */
    public Macro getMacro() {
        return macro;
    }

    /**
     * Sets the value of the macro property.
     * 
     * @param value
     *     allowed object is
     *     {@link Macro }
     *     
     */
    public void setMacro(Macro value) {
        this.macro = value;
    }

    /**
     * Gets the value of the standardFields property.
     * 
     * @return
     *     possible object is
     *     {@link ActionStandardFields }
     *     
     */
    public ActionStandardFields getStandardFields() {
        return standardFields;
    }

    /**
     * Sets the value of the standardFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActionStandardFields }
     *     
     */
    public void setStandardFields(ActionStandardFields value) {
        this.standardFields = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the data property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Data }
     * 
     * 
     */
    public List<Data> getData() {
        if (data == null) {
            data = new ArrayList<Data>();
        }
        return this.data;
    }

}
