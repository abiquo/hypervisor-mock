
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExecuteProcessStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExecuteProcessStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Undefined"/>
 *     &lt;enumeration value="Started"/>
 *     &lt;enumeration value="TerminatedNormally"/>
 *     &lt;enumeration value="TerminatedSignal"/>
 *     &lt;enumeration value="TerminatedAbnormally"/>
 *     &lt;enumeration value="TimedOutKilled"/>
 *     &lt;enumeration value="TimedOutAbnormally"/>
 *     &lt;enumeration value="Down"/>
 *     &lt;enumeration value="Error"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExecuteProcessStatus")
@XmlEnum
public enum ExecuteProcessStatus {

    @XmlEnumValue("Undefined")
    UNDEFINED("Undefined"),
    @XmlEnumValue("Started")
    STARTED("Started"),
    @XmlEnumValue("TerminatedNormally")
    TERMINATED_NORMALLY("TerminatedNormally"),
    @XmlEnumValue("TerminatedSignal")
    TERMINATED_SIGNAL("TerminatedSignal"),
    @XmlEnumValue("TerminatedAbnormally")
    TERMINATED_ABNORMALLY("TerminatedAbnormally"),
    @XmlEnumValue("TimedOutKilled")
    TIMED_OUT_KILLED("TimedOutKilled"),
    @XmlEnumValue("TimedOutAbnormally")
    TIMED_OUT_ABNORMALLY("TimedOutAbnormally"),
    @XmlEnumValue("Down")
    DOWN("Down"),
    @XmlEnumValue("Error")
    ERROR("Error");
    private final String value;

    ExecuteProcessStatus(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExecuteProcessStatus fromValue(String v) {
        for (ExecuteProcessStatus c: ExecuteProcessStatus.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
