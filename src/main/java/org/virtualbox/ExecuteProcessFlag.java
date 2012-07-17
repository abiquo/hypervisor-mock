
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExecuteProcessFlag.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExecuteProcessFlag">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="None"/>
 *     &lt;enumeration value="WaitForProcessStartOnly"/>
 *     &lt;enumeration value="IgnoreOrphanedProcesses"/>
 *     &lt;enumeration value="Hidden"/>
 *     &lt;enumeration value="NoProfile"/>
 *     &lt;enumeration value="WaitForStdOut"/>
 *     &lt;enumeration value="WaitForStdErr"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExecuteProcessFlag")
@XmlEnum
public enum ExecuteProcessFlag {

    @XmlEnumValue("None")
    NONE("None"),
    @XmlEnumValue("WaitForProcessStartOnly")
    WAIT_FOR_PROCESS_START_ONLY("WaitForProcessStartOnly"),
    @XmlEnumValue("IgnoreOrphanedProcesses")
    IGNORE_ORPHANED_PROCESSES("IgnoreOrphanedProcesses"),
    @XmlEnumValue("Hidden")
    HIDDEN("Hidden"),
    @XmlEnumValue("NoProfile")
    NO_PROFILE("NoProfile"),
    @XmlEnumValue("WaitForStdOut")
    WAIT_FOR_STD_OUT("WaitForStdOut"),
    @XmlEnumValue("WaitForStdErr")
    WAIT_FOR_STD_ERR("WaitForStdErr");
    private final String value;

    ExecuteProcessFlag(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExecuteProcessFlag fromValue(String v) {
        for (ExecuteProcessFlag c: ExecuteProcessFlag.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
