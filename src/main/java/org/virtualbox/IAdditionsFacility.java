
package org.virtualbox;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IAdditionsFacility complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IAdditionsFacility">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classType" type="{http://www.virtualbox.org/}AdditionsFacilityClass"/>
 *         &lt;element name="lastUpdated" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="status" type="{http://www.virtualbox.org/}AdditionsFacilityStatus"/>
 *         &lt;element name="type" type="{http://www.virtualbox.org/}AdditionsFacilityType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IAdditionsFacility", propOrder = {
    "classType",
    "lastUpdated",
    "name",
    "status",
    "type"
})
public class IAdditionsFacility {

    @XmlElement(required = true)
    protected AdditionsFacilityClass classType;
    protected long lastUpdated;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected AdditionsFacilityStatus status;
    @XmlElement(required = true)
    protected AdditionsFacilityType type;

    /**
     * Gets the value of the classType property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionsFacilityClass }
     *     
     */
    public AdditionsFacilityClass getClassType() {
        return classType;
    }

    /**
     * Sets the value of the classType property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionsFacilityClass }
     *     
     */
    public void setClassType(AdditionsFacilityClass value) {
        this.classType = value;
    }

    /**
     * Gets the value of the lastUpdated property.
     * 
     */
    public long getLastUpdated() {
        return lastUpdated;
    }

    /**
     * Sets the value of the lastUpdated property.
     * 
     */
    public void setLastUpdated(long value) {
        this.lastUpdated = value;
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
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionsFacilityStatus }
     *     
     */
    public AdditionsFacilityStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionsFacilityStatus }
     *     
     */
    public void setStatus(AdditionsFacilityStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionsFacilityType }
     *     
     */
    public AdditionsFacilityType getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionsFacilityType }
     *     
     */
    public void setType(AdditionsFacilityType value) {
        this.type = value;
    }

}
