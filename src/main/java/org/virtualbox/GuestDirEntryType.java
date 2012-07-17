
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GuestDirEntryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GuestDirEntryType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Unknown"/>
 *     &lt;enumeration value="Directory"/>
 *     &lt;enumeration value="File"/>
 *     &lt;enumeration value="Symlink"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GuestDirEntryType")
@XmlEnum
public enum GuestDirEntryType {

    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown"),
    @XmlEnumValue("Directory")
    DIRECTORY("Directory"),
    @XmlEnumValue("File")
    FILE("File"),
    @XmlEnumValue("Symlink")
    SYMLINK("Symlink");
    private final String value;

    GuestDirEntryType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GuestDirEntryType fromValue(String v) {
        for (GuestDirEntryType c: GuestDirEntryType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
