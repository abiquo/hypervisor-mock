
package org.virtualbox;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VBoxEventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VBoxEventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Invalid"/>
 *     &lt;enumeration value="Any"/>
 *     &lt;enumeration value="Vetoable"/>
 *     &lt;enumeration value="MachineEvent"/>
 *     &lt;enumeration value="SnapshotEvent"/>
 *     &lt;enumeration value="InputEvent"/>
 *     &lt;enumeration value="LastWildcard"/>
 *     &lt;enumeration value="OnMachineStateChanged"/>
 *     &lt;enumeration value="OnMachineDataChanged"/>
 *     &lt;enumeration value="OnExtraDataChanged"/>
 *     &lt;enumeration value="OnExtraDataCanChange"/>
 *     &lt;enumeration value="OnMediumRegistered"/>
 *     &lt;enumeration value="OnMachineRegistered"/>
 *     &lt;enumeration value="OnSessionStateChanged"/>
 *     &lt;enumeration value="OnSnapshotTaken"/>
 *     &lt;enumeration value="OnSnapshotDeleted"/>
 *     &lt;enumeration value="OnSnapshotChanged"/>
 *     &lt;enumeration value="OnGuestPropertyChanged"/>
 *     &lt;enumeration value="OnMousePointerShapeChanged"/>
 *     &lt;enumeration value="OnMouseCapabilityChanged"/>
 *     &lt;enumeration value="OnKeyboardLedsChanged"/>
 *     &lt;enumeration value="OnStateChanged"/>
 *     &lt;enumeration value="OnAdditionsStateChanged"/>
 *     &lt;enumeration value="OnNetworkAdapterChanged"/>
 *     &lt;enumeration value="OnSerialPortChanged"/>
 *     &lt;enumeration value="OnParallelPortChanged"/>
 *     &lt;enumeration value="OnStorageControllerChanged"/>
 *     &lt;enumeration value="OnMediumChanged"/>
 *     &lt;enumeration value="OnVRDEServerChanged"/>
 *     &lt;enumeration value="OnUSBControllerChanged"/>
 *     &lt;enumeration value="OnUSBDeviceStateChanged"/>
 *     &lt;enumeration value="OnSharedFolderChanged"/>
 *     &lt;enumeration value="OnRuntimeError"/>
 *     &lt;enumeration value="OnCanShowWindow"/>
 *     &lt;enumeration value="OnShowWindow"/>
 *     &lt;enumeration value="OnCPUChanged"/>
 *     &lt;enumeration value="OnVRDEServerInfoChanged"/>
 *     &lt;enumeration value="OnEventSourceChanged"/>
 *     &lt;enumeration value="OnCPUExecutionCapChanged"/>
 *     &lt;enumeration value="OnGuestKeyboard"/>
 *     &lt;enumeration value="OnGuestMouse"/>
 *     &lt;enumeration value="OnNATRedirect"/>
 *     &lt;enumeration value="OnHostPciDevicePlug"/>
 *     &lt;enumeration value="OnVBoxSVCAvailabilityChanged"/>
 *     &lt;enumeration value="OnBandwidthGroupChanged"/>
 *     &lt;enumeration value="OnGuestMonitorChanged"/>
 *     &lt;enumeration value="OnStorageDeviceChanged"/>
 *     &lt;enumeration value="Last"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VBoxEventType")
@XmlEnum
public enum VBoxEventType {

    @XmlEnumValue("Invalid")
    INVALID("Invalid"),
    @XmlEnumValue("Any")
    ANY("Any"),
    @XmlEnumValue("Vetoable")
    VETOABLE("Vetoable"),
    @XmlEnumValue("MachineEvent")
    MACHINE_EVENT("MachineEvent"),
    @XmlEnumValue("SnapshotEvent")
    SNAPSHOT_EVENT("SnapshotEvent"),
    @XmlEnumValue("InputEvent")
    INPUT_EVENT("InputEvent"),
    @XmlEnumValue("LastWildcard")
    LAST_WILDCARD("LastWildcard"),
    @XmlEnumValue("OnMachineStateChanged")
    ON_MACHINE_STATE_CHANGED("OnMachineStateChanged"),
    @XmlEnumValue("OnMachineDataChanged")
    ON_MACHINE_DATA_CHANGED("OnMachineDataChanged"),
    @XmlEnumValue("OnExtraDataChanged")
    ON_EXTRA_DATA_CHANGED("OnExtraDataChanged"),
    @XmlEnumValue("OnExtraDataCanChange")
    ON_EXTRA_DATA_CAN_CHANGE("OnExtraDataCanChange"),
    @XmlEnumValue("OnMediumRegistered")
    ON_MEDIUM_REGISTERED("OnMediumRegistered"),
    @XmlEnumValue("OnMachineRegistered")
    ON_MACHINE_REGISTERED("OnMachineRegistered"),
    @XmlEnumValue("OnSessionStateChanged")
    ON_SESSION_STATE_CHANGED("OnSessionStateChanged"),
    @XmlEnumValue("OnSnapshotTaken")
    ON_SNAPSHOT_TAKEN("OnSnapshotTaken"),
    @XmlEnumValue("OnSnapshotDeleted")
    ON_SNAPSHOT_DELETED("OnSnapshotDeleted"),
    @XmlEnumValue("OnSnapshotChanged")
    ON_SNAPSHOT_CHANGED("OnSnapshotChanged"),
    @XmlEnumValue("OnGuestPropertyChanged")
    ON_GUEST_PROPERTY_CHANGED("OnGuestPropertyChanged"),
    @XmlEnumValue("OnMousePointerShapeChanged")
    ON_MOUSE_POINTER_SHAPE_CHANGED("OnMousePointerShapeChanged"),
    @XmlEnumValue("OnMouseCapabilityChanged")
    ON_MOUSE_CAPABILITY_CHANGED("OnMouseCapabilityChanged"),
    @XmlEnumValue("OnKeyboardLedsChanged")
    ON_KEYBOARD_LEDS_CHANGED("OnKeyboardLedsChanged"),
    @XmlEnumValue("OnStateChanged")
    ON_STATE_CHANGED("OnStateChanged"),
    @XmlEnumValue("OnAdditionsStateChanged")
    ON_ADDITIONS_STATE_CHANGED("OnAdditionsStateChanged"),
    @XmlEnumValue("OnNetworkAdapterChanged")
    ON_NETWORK_ADAPTER_CHANGED("OnNetworkAdapterChanged"),
    @XmlEnumValue("OnSerialPortChanged")
    ON_SERIAL_PORT_CHANGED("OnSerialPortChanged"),
    @XmlEnumValue("OnParallelPortChanged")
    ON_PARALLEL_PORT_CHANGED("OnParallelPortChanged"),
    @XmlEnumValue("OnStorageControllerChanged")
    ON_STORAGE_CONTROLLER_CHANGED("OnStorageControllerChanged"),
    @XmlEnumValue("OnMediumChanged")
    ON_MEDIUM_CHANGED("OnMediumChanged"),
    @XmlEnumValue("OnVRDEServerChanged")
    ON_VRDE_SERVER_CHANGED("OnVRDEServerChanged"),
    @XmlEnumValue("OnUSBControllerChanged")
    ON_USB_CONTROLLER_CHANGED("OnUSBControllerChanged"),
    @XmlEnumValue("OnUSBDeviceStateChanged")
    ON_USB_DEVICE_STATE_CHANGED("OnUSBDeviceStateChanged"),
    @XmlEnumValue("OnSharedFolderChanged")
    ON_SHARED_FOLDER_CHANGED("OnSharedFolderChanged"),
    @XmlEnumValue("OnRuntimeError")
    ON_RUNTIME_ERROR("OnRuntimeError"),
    @XmlEnumValue("OnCanShowWindow")
    ON_CAN_SHOW_WINDOW("OnCanShowWindow"),
    @XmlEnumValue("OnShowWindow")
    ON_SHOW_WINDOW("OnShowWindow"),
    @XmlEnumValue("OnCPUChanged")
    ON_CPU_CHANGED("OnCPUChanged"),
    @XmlEnumValue("OnVRDEServerInfoChanged")
    ON_VRDE_SERVER_INFO_CHANGED("OnVRDEServerInfoChanged"),
    @XmlEnumValue("OnEventSourceChanged")
    ON_EVENT_SOURCE_CHANGED("OnEventSourceChanged"),
    @XmlEnumValue("OnCPUExecutionCapChanged")
    ON_CPU_EXECUTION_CAP_CHANGED("OnCPUExecutionCapChanged"),
    @XmlEnumValue("OnGuestKeyboard")
    ON_GUEST_KEYBOARD("OnGuestKeyboard"),
    @XmlEnumValue("OnGuestMouse")
    ON_GUEST_MOUSE("OnGuestMouse"),
    @XmlEnumValue("OnNATRedirect")
    ON_NAT_REDIRECT("OnNATRedirect"),
    @XmlEnumValue("OnHostPciDevicePlug")
    ON_HOST_PCI_DEVICE_PLUG("OnHostPciDevicePlug"),
    @XmlEnumValue("OnVBoxSVCAvailabilityChanged")
    ON_V_BOX_SVC_AVAILABILITY_CHANGED("OnVBoxSVCAvailabilityChanged"),
    @XmlEnumValue("OnBandwidthGroupChanged")
    ON_BANDWIDTH_GROUP_CHANGED("OnBandwidthGroupChanged"),
    @XmlEnumValue("OnGuestMonitorChanged")
    ON_GUEST_MONITOR_CHANGED("OnGuestMonitorChanged"),
    @XmlEnumValue("OnStorageDeviceChanged")
    ON_STORAGE_DEVICE_CHANGED("OnStorageDeviceChanged"),
    @XmlEnumValue("Last")
    LAST("Last");
    private final String value;

    VBoxEventType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VBoxEventType fromValue(String v) {
        for (VBoxEventType c: VBoxEventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
