
package org.virtualbox;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IGuestDirEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IGuestDirEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nodeId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.virtualbox.org/}GuestDirEntryType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IGuestDirEntry", propOrder = {
    "nodeId",
    "name",
    "type"
})
public class IGuestDirEntry {

    protected long nodeId;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected GuestDirEntryType type;

    /**
     * Gets the value of the nodeId property.
     * 
     */
    public long getNodeId() {
        return nodeId;
    }

    /**
     * Sets the value of the nodeId property.
     * 
     */
    public void setNodeId(long value) {
        this.nodeId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link GuestDirEntryType }
     *     
     */
    public GuestDirEntryType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link GuestDirEntryType }
     *     
     */
    public void setType(GuestDirEntryType value) {
        this.type = value;
    }

}
