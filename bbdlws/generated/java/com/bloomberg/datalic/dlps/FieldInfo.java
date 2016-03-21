
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for FieldInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FieldInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mnemonic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dlCategory" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}DLCategory" minOccurs="0"/>
 *         &lt;element name="definition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="marketsectors" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}MarketSector" maxOccurs="10" minOccurs="0"/>
 *         &lt;element name="standardWidth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="standardDecimalPlaces" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="fieldType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="backoffice" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="extendedBackoffice" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="productionDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="dlCategory2" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}DLCategory2" minOccurs="0"/>
 *         &lt;element name="psBoOpt" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FieldInfo", propOrder = {
    "id",
    "mnemonic",
    "description",
    "dlCategory",
    "definition",
    "marketsectors",
    "standardWidth",
    "standardDecimalPlaces",
    "fieldType",
    "backoffice",
    "extendedBackoffice",
    "productionDate",
    "dlCategory2",
    "psBoOpt"
})
public class FieldInfo
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected String id;
    protected String mnemonic;
    protected String description;
    protected DLCategory dlCategory;
    protected String definition;
    protected List<MarketSector> marketsectors;
    protected Integer standardWidth;
    protected Integer standardDecimalPlaces;
    protected String fieldType;
    protected Boolean backoffice;
    protected Boolean extendedBackoffice;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar productionDate;
    protected DLCategory2 dlCategory2;
    protected Boolean psBoOpt;

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
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the dlCategory property.
     * 
     * @return
     *     possible object is
     *     {@link DLCategory }
     *     
     */
    public DLCategory getDlCategory() {
        return dlCategory;
    }

    /**
     * Sets the value of the dlCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link DLCategory }
     *     
     */
    public void setDlCategory(DLCategory value) {
        this.dlCategory = value;
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinition(String value) {
        this.definition = value;
    }

    /**
     * Gets the value of the marketsectors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the marketsectors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarketsectors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MarketSector }
     * 
     * 
     */
    public List<MarketSector> getMarketsectors() {
        if (marketsectors == null) {
            marketsectors = new ArrayList<MarketSector>();
        }
        return this.marketsectors;
    }

    /**
     * Gets the value of the standardWidth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStandardWidth() {
        return standardWidth;
    }

    /**
     * Sets the value of the standardWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStandardWidth(Integer value) {
        this.standardWidth = value;
    }

    /**
     * Gets the value of the standardDecimalPlaces property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStandardDecimalPlaces() {
        return standardDecimalPlaces;
    }

    /**
     * Sets the value of the standardDecimalPlaces property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStandardDecimalPlaces(Integer value) {
        this.standardDecimalPlaces = value;
    }

    /**
     * Gets the value of the fieldType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * Sets the value of the fieldType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldType(String value) {
        this.fieldType = value;
    }

    /**
     * Gets the value of the backoffice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBackoffice() {
        return backoffice;
    }

    /**
     * Sets the value of the backoffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBackoffice(Boolean value) {
        this.backoffice = value;
    }

    /**
     * Gets the value of the extendedBackoffice property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExtendedBackoffice() {
        return extendedBackoffice;
    }

    /**
     * Sets the value of the extendedBackoffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExtendedBackoffice(Boolean value) {
        this.extendedBackoffice = value;
    }

    /**
     * Gets the value of the productionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getProductionDate() {
        return productionDate;
    }

    /**
     * Sets the value of the productionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setProductionDate(XMLGregorianCalendar value) {
        this.productionDate = value;
    }

    /**
     * Gets the value of the dlCategory2 property.
     * 
     * @return
     *     possible object is
     *     {@link DLCategory2 }
     *     
     */
    public DLCategory2 getDlCategory2() {
        return dlCategory2;
    }

    /**
     * Sets the value of the dlCategory2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link DLCategory2 }
     *     
     */
    public void setDlCategory2(DLCategory2 value) {
        this.dlCategory2 = value;
    }

    /**
     * Gets the value of the psBoOpt property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPsBoOpt() {
        return psBoOpt;
    }

    /**
     * Sets the value of the psBoOpt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPsBoOpt(Boolean value) {
        this.psBoOpt = value;
    }

}
