
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for USBDeviceFilterAction.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="USBDeviceFilterAction">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Null"/>
 *     &lt;enumeration value="Ignore"/>
 *     &lt;enumeration value="Hold"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "USBDeviceFilterAction")
@XmlEnum
public enum USBDeviceFilterAction {

    @XmlEnumValue("Null")
    NULL("Null"),
    @XmlEnumValue("Ignore")
    IGNORE("Ignore"),
    @XmlEnumValue("Hold")
    HOLD("Hold");
    private final String value;

    USBDeviceFilterAction(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static USBDeviceFilterAction fromValue(String v) {
        for (USBDeviceFilterAction c: USBDeviceFilterAction.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
