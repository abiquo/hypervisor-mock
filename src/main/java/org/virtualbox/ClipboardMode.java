
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClipboardMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ClipboardMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Disabled"/>
 *     &lt;enumeration value="HostToGuest"/>
 *     &lt;enumeration value="GuestToHost"/>
 *     &lt;enumeration value="Bidirectional"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ClipboardMode")
@XmlEnum
public enum ClipboardMode {

    @XmlEnumValue("Disabled")
    DISABLED("Disabled"),
    @XmlEnumValue("HostToGuest")
    HOST_TO_GUEST("HostToGuest"),
    @XmlEnumValue("GuestToHost")
    GUEST_TO_HOST("GuestToHost"),
    @XmlEnumValue("Bidirectional")
    BIDIRECTIONAL("Bidirectional");
    private final String value;

    ClipboardMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ClipboardMode fromValue(String v) {
        for (ClipboardMode c: ClipboardMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
