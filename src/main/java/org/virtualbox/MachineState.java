
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MachineState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MachineState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Null"/>
 *     &lt;enumeration value="PoweredOff"/>
 *     &lt;enumeration value="Saved"/>
 *     &lt;enumeration value="Teleported"/>
 *     &lt;enumeration value="Aborted"/>
 *     &lt;enumeration value="Running"/>
 *     &lt;enumeration value="Paused"/>
 *     &lt;enumeration value="Stuck"/>
 *     &lt;enumeration value="Teleporting"/>
 *     &lt;enumeration value="LiveSnapshotting"/>
 *     &lt;enumeration value="Starting"/>
 *     &lt;enumeration value="Stopping"/>
 *     &lt;enumeration value="Saving"/>
 *     &lt;enumeration value="Restoring"/>
 *     &lt;enumeration value="TeleportingPausedVM"/>
 *     &lt;enumeration value="TeleportingIn"/>
 *     &lt;enumeration value="FaultTolerantSyncing"/>
 *     &lt;enumeration value="DeletingSnapshotOnline"/>
 *     &lt;enumeration value="DeletingSnapshotPaused"/>
 *     &lt;enumeration value="RestoringSnapshot"/>
 *     &lt;enumeration value="DeletingSnapshot"/>
 *     &lt;enumeration value="SettingUp"/>
 *     &lt;enumeration value="FirstOnline"/>
 *     &lt;enumeration value="LastOnline"/>
 *     &lt;enumeration value="FirstTransient"/>
 *     &lt;enumeration value="LastTransient"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MachineState")
@XmlEnum
public enum MachineState {

    @XmlEnumValue("Null")
    NULL("Null"),
    @XmlEnumValue("PoweredOff")
    POWERED_OFF("PoweredOff"),
    @XmlEnumValue("Saved")
    SAVED("Saved"),
    @XmlEnumValue("Teleported")
    TELEPORTED("Teleported"),
    @XmlEnumValue("Aborted")
    ABORTED("Aborted"),
    @XmlEnumValue("Running")
    RUNNING("Running"),
    @XmlEnumValue("Paused")
    PAUSED("Paused"),
    @XmlEnumValue("Stuck")
    STUCK("Stuck"),
    @XmlEnumValue("Teleporting")
    TELEPORTING("Teleporting"),
    @XmlEnumValue("LiveSnapshotting")
    LIVE_SNAPSHOTTING("LiveSnapshotting"),
    @XmlEnumValue("Starting")
    STARTING("Starting"),
    @XmlEnumValue("Stopping")
    STOPPING("Stopping"),
    @XmlEnumValue("Saving")
    SAVING("Saving"),
    @XmlEnumValue("Restoring")
    RESTORING("Restoring"),
    @XmlEnumValue("TeleportingPausedVM")
    TELEPORTING_PAUSED_VM("TeleportingPausedVM"),
    @XmlEnumValue("TeleportingIn")
    TELEPORTING_IN("TeleportingIn"),
    @XmlEnumValue("FaultTolerantSyncing")
    FAULT_TOLERANT_SYNCING("FaultTolerantSyncing"),
    @XmlEnumValue("DeletingSnapshotOnline")
    DELETING_SNAPSHOT_ONLINE("DeletingSnapshotOnline"),
    @XmlEnumValue("DeletingSnapshotPaused")
    DELETING_SNAPSHOT_PAUSED("DeletingSnapshotPaused"),
    @XmlEnumValue("RestoringSnapshot")
    RESTORING_SNAPSHOT("RestoringSnapshot"),
    @XmlEnumValue("DeletingSnapshot")
    DELETING_SNAPSHOT("DeletingSnapshot"),
    @XmlEnumValue("SettingUp")
    SETTING_UP("SettingUp"),
    @XmlEnumValue("FirstOnline")
    FIRST_ONLINE("FirstOnline"),
    @XmlEnumValue("LastOnline")
    LAST_ONLINE("LastOnline"),
    @XmlEnumValue("FirstTransient")
    FIRST_TRANSIENT("FirstTransient"),
    @XmlEnumValue("LastTransient")
    LAST_TRANSIENT("LastTransient");
    private final String value;

    MachineState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MachineState fromValue(String v) {
        for (MachineState c: MachineState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
