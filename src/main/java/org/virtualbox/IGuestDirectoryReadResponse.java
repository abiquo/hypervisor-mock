
package org.virtualbox;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="returnval" type="{http://www.virtualbox.org/}IGuestDirEntry"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "returnval"
})
@XmlRootElement(name = "IGuest_directoryReadResponse")
public class IGuestDirectoryReadResponse {

    @XmlElement(required = true)
    protected IGuestDirEntry returnval;

    /**
     * Gets the value of the returnval property.
     * 
     * @return
     *     possible object is
     *     {@link IGuestDirEntry }
     *     
     */
    public IGuestDirEntry getReturnval() {
        return returnval;
    }

    /**
     * Sets the value of the returnval property.
     * 
     * @param value
     *     allowed object is
     *     {@link IGuestDirEntry }
     *     
     */
    public void setReturnval(IGuestDirEntry value) {
        this.returnval = value;
    }

}