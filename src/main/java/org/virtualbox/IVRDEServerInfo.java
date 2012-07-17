
package org.virtualbox;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IVRDEServerInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IVRDEServerInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="port" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfClients" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="beginTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="endTime" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesSent" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesSentTotal" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesReceived" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="bytesReceivedTotal" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="user" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="domain" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientIP" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientVersion" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="encryptionStyle" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IVRDEServerInfo", propOrder = {
    "active",
    "port",
    "numberOfClients",
    "beginTime",
    "endTime",
    "bytesSent",
    "bytesSentTotal",
    "bytesReceived",
    "bytesReceivedTotal",
    "user",
    "domain",
    "clientName",
    "clientIP",
    "clientVersion",
    "encryptionStyle"
})
public class IVRDEServerInfo {

    protected boolean active;
    protected int port;
    @XmlSchemaType(name = "unsignedInt")
    protected long numberOfClients;
    protected long beginTime;
    protected long endTime;
    protected long bytesSent;
    protected long bytesSentTotal;
    protected long bytesReceived;
    protected long bytesReceivedTotal;
    @XmlElement(required = true)
    protected String user;
    @XmlElement(required = true)
    protected String domain;
    @XmlElement(required = true)
    protected String clientName;
    @XmlElement(required = true)
    protected String clientIP;
    @XmlSchemaType(name = "unsignedInt")
    protected long clientVersion;
    @XmlSchemaType(name = "unsignedInt")
    protected long encryptionStyle;

    /**
     * Gets the value of the active property.
     * 
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     */
    public void setActive(boolean value) {
        this.active = value;
    }

    /**
     * Gets the value of the port property.
     * 
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     */
    public void setPort(int value) {
        this.port = value;
    }

    /**
     * Gets the value of the numberOfClients property.
     * 
     */
    public long getNumberOfClients() {
        return numberOfClients;
    }

    /**
     * Sets the value of the numberOfClients property.
     * 
     */
    public void setNumberOfClients(long value) {
        this.numberOfClients = value;
    }

    /**
     * Gets the value of the beginTime property.
     * 
     */
    public long getBeginTime() {
        return beginTime;
    }

    /**
     * Sets the value of the beginTime property.
     * 
     */
    public void setBeginTime(long value) {
        this.beginTime = value;
    }

    /**
     * Gets the value of the endTime property.
     * 
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Sets the value of the endTime property.
     * 
     */
    public void setEndTime(long value) {
        this.endTime = value;
    }

    /**
     * Gets the value of the bytesSent property.
     * 
     */
    public long getBytesSent() {
        return bytesSent;
    }

    /**
     * Sets the value of the bytesSent property.
     * 
     */
    public void setBytesSent(long value) {
        this.bytesSent = value;
    }

    /**
     * Gets the value of the bytesSentTotal property.
     * 
     */
    public long getBytesSentTotal() {
        return bytesSentTotal;
    }

    /**
     * Sets the value of the bytesSentTotal property.
     * 
     */
    public void setBytesSentTotal(long value) {
        this.bytesSentTotal = value;
    }

    /**
     * Gets the value of the bytesReceived property.
     * 
     */
    public long getBytesReceived() {
        return bytesReceived;
    }

    /**
     * Sets the value of the bytesReceived property.
     * 
     */
    public void setBytesReceived(long value) {
        this.bytesReceived = value;
    }

    /**
     * Gets the value of the bytesReceivedTotal property.
     * 
     */
    public long getBytesReceivedTotal() {
        return bytesReceivedTotal;
    }

    /**
     * Sets the value of the bytesReceivedTotal property.
     * 
     */
    public void setBytesReceivedTotal(long value) {
        this.bytesReceivedTotal = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDomain(String value) {
        this.domain = value;
    }

    /**
     * Gets the value of the clientName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Sets the value of the clientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientName(String value) {
        this.clientName = value;
    }

    /**
     * Gets the value of the clientIP property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientIP() {
        return clientIP;
    }

    /**
     * Sets the value of the clientIP property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientIP(String value) {
        this.clientIP = value;
    }

    /**
     * Gets the value of the clientVersion property.
     * 
     */
    public long getClientVersion() {
        return clientVersion;
    }

    /**
     * Sets the value of the clientVersion property.
     * 
     */
    public void setClientVersion(long value) {
        this.clientVersion = value;
    }

    /**
     * Gets the value of the encryptionStyle property.
     * 
     */
    public long getEncryptionStyle() {
        return encryptionStyle;
    }

    /**
     * Sets the value of the encryptionStyle property.
     * 
     */
    public void setEncryptionStyle(long value) {
        this.encryptionStyle = value;
    }

}
