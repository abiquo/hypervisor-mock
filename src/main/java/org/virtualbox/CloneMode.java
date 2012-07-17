
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CloneMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CloneMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="MachineState"/>
 *     &lt;enumeration value="MachineAndChildStates"/>
 *     &lt;enumeration value="AllStates"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CloneMode")
@XmlEnum
public enum CloneMode {

    @XmlEnumValue("MachineState")
    MACHINE_STATE("MachineState"),
    @XmlEnumValue("MachineAndChildStates")
    MACHINE_AND_CHILD_STATES("MachineAndChildStates"),
    @XmlEnumValue("AllStates")
    ALL_STATES("AllStates");
    private final String value;

    CloneMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CloneMode fromValue(String v) {
        for (CloneMode c: CloneMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
