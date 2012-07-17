
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SessionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SessionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Null"/>
 *     &lt;enumeration value="WriteLock"/>
 *     &lt;enumeration value="Remote"/>
 *     &lt;enumeration value="Shared"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SessionType")
@XmlEnum
public enum SessionType {

    @XmlEnumValue("Null")
    NULL("Null"),
    @XmlEnumValue("WriteLock")
    WRITE_LOCK("WriteLock"),
    @XmlEnumValue("Remote")
    REMOTE("Remote"),
    @XmlEnumValue("Shared")
    SHARED("Shared");
    private final String value;

    SessionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SessionType fromValue(String v) {
        for (SessionType c: SessionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
