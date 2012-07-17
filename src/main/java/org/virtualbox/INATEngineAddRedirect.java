
package org.virtualbox;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="_this" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="proto" type="{http://www.virtualbox.org/}NATProtocol"/>
 *         &lt;element name="hostIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="hostPort" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
 *         &lt;element name="guestIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="guestPort" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/>
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
    "_this",
    "name",
    "proto",
    "hostIp",
    "hostPort",
    "guestIp",
    "guestPort"
})
@XmlRootElement(name = "INATEngine_addRedirect")
public class INATEngineAddRedirect {

    @XmlElement(required = true)
    protected String _this;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected NATProtocol proto;
    @XmlElement(required = true)
    protected String hostIp;
    @XmlSchemaType(name = "unsignedShort")
    protected int hostPort;
    @XmlElement(required = true)
    protected String guestIp;
    @XmlSchemaType(name = "unsignedShort")
    protected int guestPort;

    /**
     * Gets the value of the this property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThis() {
        return _this;
    }

    /**
     * Sets the value of the this property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThis(String value) {
        this._this = value;
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
     * Gets the value of the proto property.
     * 
     * @return
     *     possible object is
     *     {@link NATProtocol }
     *     
     */
    public NATProtocol getProto() {
        return proto;
    }

    /**
     * Sets the value of the proto property.
     * 
     * @param value
     *     allowed object is
     *     {@link NATProtocol }
     *     
     */
    public void setProto(NATProtocol value) {
        this.proto = value;
    }

    /**
     * Gets the value of the hostIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHostIp() {
        return hostIp;
    }

    /**
     * Sets the value of the hostIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHostIp(String value) {
        this.hostIp = value;
    }

    /**
     * Gets the value of the hostPort property.
     * 
     */
    public int getHostPort() {
        return hostPort;
    }

    /**
     * Sets the value of the hostPort property.
     * 
     */
    public void setHostPort(int value) {
        this.hostPort = value;
    }

    /**
     * Gets the value of the guestIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGuestIp() {
        return guestIp;
    }

    /**
     * Sets the value of the guestIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGuestIp(String value) {
        this.guestIp = value;
    }

    /**
     * Gets the value of the guestPort property.
     * 
     */
    public int getGuestPort() {
        return guestPort;
    }

    /**
     * Sets the value of the guestPort property.
     * 
     */
    public void setGuestPort(int value) {
        this.guestPort = value;
    }

}
