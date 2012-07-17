
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CleanupMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CleanupMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="UnregisterOnly"/>
 *     &lt;enumeration value="DetachAllReturnNone"/>
 *     &lt;enumeration value="DetachAllReturnHardDisksOnly"/>
 *     &lt;enumeration value="Full"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CleanupMode")
@XmlEnum
public enum CleanupMode {

    @XmlEnumValue("UnregisterOnly")
    UNREGISTER_ONLY("UnregisterOnly"),
    @XmlEnumValue("DetachAllReturnNone")
    DETACH_ALL_RETURN_NONE("DetachAllReturnNone"),
    @XmlEnumValue("DetachAllReturnHardDisksOnly")
    DETACH_ALL_RETURN_HARD_DISKS_ONLY("DetachAllReturnHardDisksOnly"),
    @XmlEnumValue("Full")
    FULL("Full");
    private final String value;

    CleanupMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CleanupMode fromValue(String v) {
        for (CleanupMode c: CleanupMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
