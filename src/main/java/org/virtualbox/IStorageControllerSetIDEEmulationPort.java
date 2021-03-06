
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
 *         &lt;element name="_this" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="devicePosition" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="portNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "devicePosition",
    "portNumber"
})
@XmlRootElement(name = "IStorageController_setIDEEmulationPort")
public class IStorageControllerSetIDEEmulationPort {

    @XmlElement(required = true)
    protected String _this;
    protected int devicePosition;
    protected int portNumber;

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
     * Gets the value of the devicePosition property.
     * 
     */
    public int getDevicePosition() {
        return devicePosition;
    }

    /**
     * Sets the value of the devicePosition property.
     * 
     */
    public void setDevicePosition(int value) {
        this.devicePosition = value;
    }

    /**
     * Gets the value of the portNumber property.
     * 
     */
    public int getPortNumber() {
        return portNumber;
    }

    /**
     * Sets the value of the portNumber property.
     * 
     */
    public void setPortNumber(int value) {
        this.portNumber = value;
    }

}
