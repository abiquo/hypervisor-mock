
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HostNetworkInterfaceStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="HostNetworkInterfaceStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Up"/>
 *     &lt;enumeration value="Down"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "HostNetworkInterfaceStatus")
@XmlEnum
public enum HostNetworkInterfaceStatus {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Up")
    UP("Up"),
    @XmlEnumValue("Down")
    DOWN("Down");
    private final String value;

    HostNetworkInterfaceStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HostNetworkInterfaceStatus fromValue(String v) {
        for (HostNetworkInterfaceStatus c: HostNetworkInterfaceStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
