
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdditionsFacilityStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AdditionsFacilityStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Inactive"/>
 *     &lt;enumeration value="Paused"/>
 *     &lt;enumeration value="PreInit"/>
 *     &lt;enumeration value="Init"/>
 *     &lt;enumeration value="Active"/>
 *     &lt;enumeration value="Terminating"/>
 *     &lt;enumeration value="Terminated"/>
 *     &lt;enumeration value="Failed"/>
 *     &lt;enumeration value="Unknown"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AdditionsFacilityStatus")
@XmlEnum
public enum AdditionsFacilityStatus {

    @XmlEnumValue("Inactive")
    INACTIVE("Inactive"),
    @XmlEnumValue("Paused")
    PAUSED("Paused"),
    @XmlEnumValue("PreInit")
    PRE_INIT("PreInit"),
    @XmlEnumValue("Init")
    INIT("Init"),
    @XmlEnumValue("Active")
    ACTIVE("Active"),
    @XmlEnumValue("Terminating")
    TERMINATING("Terminating"),
    @XmlEnumValue("Terminated")
    TERMINATED("Terminated"),
    @XmlEnumValue("Failed")
    FAILED("Failed"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    AdditionsFacilityStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AdditionsFacilityStatus fromValue(String v) {
        for (AdditionsFacilityStatus c: AdditionsFacilityStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
