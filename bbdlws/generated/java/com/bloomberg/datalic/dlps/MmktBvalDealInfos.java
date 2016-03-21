
package com.bloomberg.datalic.dlps;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MmktBvalDealInfos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MmktBvalDealInfos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="deal" type="{http://services.bloomberg.com/datalicense/dlws/ps/20071001}MmktBvalDealInformation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MmktBvalDealInfos", propOrder = {
    "deal"
})
public class MmktBvalDealInfos
    implements Serializable
{

    private final static long serialVersionUID = 1L;
    protected List<MmktBvalDealInformation> deal;

    /**
     * Gets the value of the deal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MmktBvalDealInformation }
     * 
     * 
     */
    public List<MmktBvalDealInformation> getDeal() {
        if (deal == null) {
            deal = new ArrayList<MmktBvalDealInformation>();
        }
        return this.deal;
    }

}
