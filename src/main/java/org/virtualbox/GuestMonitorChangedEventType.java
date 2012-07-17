
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestMonitorChangedEventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GuestMonitorChangedEventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Enabled"/>
 *     &lt;enumeration value="Disabled"/>
 *     &lt;enumeration value="NewOrigin"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GuestMonitorChangedEventType")
@XmlEnum
public enum GuestMonitorChangedEventType {

    @XmlEnumValue("Enabled")
    ENABLED("Enabled"),
    @XmlEnumValue("Disabled")
    DISABLED("Disabled"),
    @XmlEnumValue("NewOrigin")
    NEW_ORIGIN("NewOrigin");
    private final String value;

    GuestMonitorChangedEventType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GuestMonitorChangedEventType fromValue(String v) {
        for (GuestMonitorChangedEventType c: GuestMonitorChangedEventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
