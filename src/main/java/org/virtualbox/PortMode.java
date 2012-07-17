
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PortMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PortMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Disconnected"/>
 *     &lt;enumeration value="HostPipe"/>
 *     &lt;enumeration value="HostDevice"/>
 *     &lt;enumeration value="RawFile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PortMode")
@XmlEnum
public enum PortMode {

    @XmlEnumValue("Disconnected")
    DISCONNECTED("Disconnected"),
    @XmlEnumValue("HostPipe")
    HOST_PIPE("HostPipe"),
    @XmlEnumValue("HostDevice")
    HOST_DEVICE("HostDevice"),
    @XmlEnumValue("RawFile")
    RAW_FILE("RawFile");
    private final String value;

    PortMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PortMode fromValue(String v) {
        for (PortMode c: PortMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
