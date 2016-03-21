
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AllQuotesInstrumentDatas complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AllQuotesInstrumentDatas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instrumentData" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}AllQuotesInstrumentData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllQuotesInstrumentDatas", propOrder = {
    "instrumentData"
})
public class AllQuotesInstrumentDatas
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected List<AllQuotesInstrumentData> instrumentData;

    /**
     * Gets the value of the instrumentData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the instrumentData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInstrumentData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllQuotesInstrumentData }
     * 
     * 
     */
    public List<AllQuotesInstrumentData> getInstrumentData() {
        if (instrumentData == null) {
            instrumentData = new ArrayList<AllQuotesInstrumentData>();
        }
        return this.instrumentData;
    }

}
