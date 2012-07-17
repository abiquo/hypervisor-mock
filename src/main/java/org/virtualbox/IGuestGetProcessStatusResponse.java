
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
 *         &lt;element name="exitcode" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="flags" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="returnval" type="{http://www.virtualbox.org/}ExecuteProcessStatus"/>
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
    "exitcode",
    "flags",
    "returnval"
})
@XmlRootElement(name = "IGuest_getProcessStatusResponse")
public class IGuestGetProcessStatusResponse {

    @XmlSchemaType(name = "unsignedInt")
    protected long exitcode;
    @XmlSchemaType(name = "unsignedInt")
    protected long flags;
    @XmlElement(required = true)
    protected ExecuteProcessStatus returnval;

    /**
     * Gets the value of the exitcode property.
     * 
     */
    public long getExitcode() {
        return exitcode;
    }

    /**
     * Sets the value of the exitcode property.
     * 
     */
    public void setExitcode(long value) {
        this.exitcode = value;
    }

    /**
     * Gets the value of the flags property.
     * 
     */
    public long getFlags() {
        return flags;
    }

    /**
     * Sets the value of the flags property.
     * 
     */
    public void setFlags(long value) {
        this.flags = value;
    }

    /**
     * Gets the value of the returnval property.
     * 
     * @return
     *     possible object is
     *     {@link ExecuteProcessStatus }
     *     
     */
    public ExecuteProcessStatus getReturnval() {
        return returnval;
    }

    /**
     * Sets the value of the returnval property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecuteProcessStatus }
     *     
     */
    public void setReturnval(ExecuteProcessStatus value) {
        this.returnval = value;
    }

}
