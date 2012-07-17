
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SessionState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SessionState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Null"/>
 *     &lt;enumeration value="Unlocked"/>
 *     &lt;enumeration value="Locked"/>
 *     &lt;enumeration value="Spawning"/>
 *     &lt;enumeration value="Unlocking"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SessionState")
@XmlEnum
public enum SessionState {

    @XmlEnumValue("Null")
    NULL("Null"),
    @XmlEnumValue("Unlocked")
    UNLOCKED("Unlocked"),
    @XmlEnumValue("Locked")
    LOCKED("Locked"),
    @XmlEnumValue("Spawning")
    SPAWNING("Spawning"),
    @XmlEnumValue("Unlocking")
    UNLOCKING("Unlocking");
    private final String value;

    SessionState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SessionState fromValue(String v) {
        for (SessionState c: SessionState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
