
package org.virtualbox;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ISharedFolder complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ISharedFolder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hostPath" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="accessible" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="writable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="autoMount" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lastAccessError" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ISharedFolder", propOrder = {
    "name",
    "hostPath",
    "accessible",
    "writable",
    "autoMount",
    "lastAccessError"
})
public class ISharedFolder {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String hostPath;
    protected boolean accessible;
    protected boolean writable;
    protected boolean autoMount;
    @XmlElement(required = true)
    protected String lastAccessError;

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
     * Gets the value of the hostPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostPath() {
        return hostPath;
    }

    /**
     * Sets the value of the hostPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostPath(String value) {
        this.hostPath = value;
    }

    /**
     * Gets the value of the accessible property.
     * 
     */
    public boolean isAccessible() {
        return accessible;
    }

    /**
     * Sets the value of the accessible property.
     * 
     */
    public void setAccessible(boolean value) {
        this.accessible = value;
    }

    /**
     * Gets the value of the writable property.
     * 
     */
    public boolean isWritable() {
        return writable;
    }

    /**
     * Sets the value of the writable property.
     * 
     */
    public void setWritable(boolean value) {
        this.writable = value;
    }

    /**
     * Gets the value of the autoMount property.
     * 
     */
    public boolean isAutoMount() {
        return autoMount;
    }

    /**
     * Sets the value of the autoMount property.
     * 
     */
    public void setAutoMount(boolean value) {
        this.autoMount = value;
    }

    /**
     * Gets the value of the lastAccessError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastAccessError() {
        return lastAccessError;
    }

    /**
     * Sets the value of the lastAccessError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastAccessError(String value) {
        this.lastAccessError = value;
    }

}
