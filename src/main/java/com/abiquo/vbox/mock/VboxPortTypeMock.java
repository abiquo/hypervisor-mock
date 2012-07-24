/**
 * 
 */
package com.abiquo.vbox.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import javax.jws.WebParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.virtualbox.AccessMode;
import org.virtualbox.CPUPropertyType;
import org.virtualbox.DeviceType;
import org.virtualbox.InvalidObjectFaultMsg;
import org.virtualbox.LockType;
import org.virtualbox.MachineState;
import org.virtualbox.MediumState;
import org.virtualbox.NetworkAdapterType;
import org.virtualbox.RuntimeFaultMsg;
import org.virtualbox.SessionState;
import org.virtualbox.StorageBus;

import com.abiquo.mock.domain.DomainService;
import com.abiquo.mock.model.Medium;
import com.abiquo.mock.model.NetworkAdapter;
import com.abiquo.mock.model.NetworkInterface;
import com.abiquo.mock.model.Progress;
import com.abiquo.mock.model.Session;
import com.abiquo.mock.model.Storage;
import com.abiquo.mock.model.VirtualMachineInfo;
import com.abiquo.vbox.VboxPortTypeImpl;

/**
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 * @author <a href="mailto:enric.ruiz@abiquo.com">Enric Ruiz</a>
 */
@javax.jws.WebService(serviceName = "vboxService", portName = "vboxServicePort", targetNamespace = "http://www.virtualbox.org/Service", wsdlLocation = "wsdl/vboxwebService.wsdl", endpointInterface = "org.virtualbox.VboxPortType")
public class VboxPortTypeMock extends VboxPortTypeImpl
{

    private final static Logger LOG = LoggerFactory.getLogger(VboxPortTypeMock.class);

    /*
     * (non-Javadoc)
     * @see org.virtualbox.VboxPortType#iMachineGetState(java.lang.String _this )*
     */
    @Override
    public org.virtualbox.MachineState iMachineGetState(java.lang.String _this)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iMachineGetState");
        // System.out.println(_this);
        VirtualMachineInfo vm = DomainService.getInstance().getVirtualMachines().get(_this);
        if (vm == null || !vm.isSaved())
        {
            throw new InvalidObjectFaultMsg("iMachineGetState: InvalidObjectFaultMsg...");
        }
        org.virtualbox.MachineState _return = vm.getMachineState();
        return _return;
    }

    /*
     * (non-Javadoc)
     * @see org.virtualbox.VboxPortType#iVirtualBoxGetMachines(java.lang.String _this )*
     */
    @Override
    public java.util.List<java.lang.String> iVirtualBoxGetMachines(java.lang.String _this)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iVirtualBoxGetMachines");
        // System.out.println(_this);
        try
        {
            java.util.List<java.lang.String> _return = new ArrayList<String>();
            for (Entry<String, VirtualMachineInfo> e : DomainService.getInstance()
                .getVirtualMachines().entrySet())
            {
                if (e.getValue().isSaved())
                {
                    _return.add(e.getKey());
                }
            }
            return _return;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
        // throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
    }

    /*
     * (non-Javadoc)
     * @see org.virtualbox.VboxPortType#iWebsessionManagerLogon(java.lang.String username
     * ,)java.lang.String password )*
     */
    @Override
    public java.lang.String iWebsessionManagerLogon(java.lang.String username,
        java.lang.String password) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iWebsessionManagerLogon");
        // System.out.println(username);
        // System.out.println(password);
        try
        {
            Session session = new Session(username, password);
            java.lang.String _return = session.getId();
            if (!DomainService.getInstance().getSession().containsKey(session.getId()))
            {
                DomainService.getInstance().getSession().put(_return, session);
            }
            return _return;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
        // throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
    }

    /*
     * (non-Javadoc)
     * @see org.virtualbox.VboxPortType#iVirtualBoxFindMachine(java.lang.String _this
     * ,)java.lang.String nameOrId )*
     */
    @Override
    public java.lang.String iVirtualBoxFindMachine(java.lang.String _this, java.lang.String nameOrId)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iVirtualBoxFindMachine");
        // System.out.println("This: " + _this);
        // System.out.println("Name: " + nameOrId);
        try
        {
            Map<String, VirtualMachineInfo> virtualMachines =
                DomainService.getInstance().getVirtualMachines();
            for (Entry<String, VirtualMachineInfo> e : virtualMachines.entrySet())
            {
                if (nameOrId.equals(e.getValue().getName()) && e.getValue().isSaved())
                {
                    java.lang.String _return = e.getValue().getId();
                    return _return;
                }
            }
            return "";
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
    }/*
      * (non-Javadoc)
      * @see org.virtualbox.VboxPortType#iVirtualBoxRegisterMachine(java.lang.String _this
      * ,)java.lang.String machine )*
      */

    @Override
    public void iVirtualBoxRegisterMachine(java.lang.String _this, java.lang.String machine)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iVirtualBoxRegisterMachine");
        // System.out.println(_this);
        // System.out.println(machine);
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(machine);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
        }
        virtualMachine.setRegistered(Boolean.TRUE);
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
    }/*
      * (non-Javadoc)
      * @see org.virtualbox.VboxPortType#iHostNetworkInterfaceGetHardwareAddress(java.lang.String
      * _this )*
      */

    @Override
    public java.lang.String iHostNetworkInterfaceGetHardwareAddress(java.lang.String _this)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iHostNetworkInterfaceGetHardwareAddress");
        // System.out.println(_this);
        try
        {
            List<NetworkInterface> networkInterfaces =
                DomainService.getInstance().getNetworkInterfaces();
            for (NetworkInterface n : networkInterfaces)
            {
                if (n.getId().equals(_this))
                {
                    return n.getMac();
                }
            }
            java.lang.String _return = "";
            return _return;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
        // throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
    }

    @Override
    public String iWebsessionManagerGetSessionObject(String refIVirtualBox) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        Session session = DomainService.getInstance().getSession().get(refIVirtualBox);
        if (session == null)
        {
            // No session, log again
            throw new InvalidObjectFaultMsg("iVirtualBoxCreateMachine: No session. InvalidObjectFaultMsg...");
        }
        return session.getId();
    }

    /*
     * (non-Javadoc)
     * @see org.virtualbox.VboxPortType#iHostGetProcessorOnlineCount(java.lang.String _this )*
     */
    @Override
    public long iHostGetProcessorOnlineCount(java.lang.String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iHostGetProcessorOnlineCount");
        // System.out.println(_this);
        try
        {
            Integer cores = DomainService.getInstance().getCores();
            long _return = Long.valueOf(cores);
            return _return;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
        // throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
    }/*
      * (non-Javadoc)
      * @see org.virtualbox.VboxPortType#iVirtualBoxGetHost(java.lang.String _this )*
      */

    @Override
    public java.lang.String iVirtualBoxGetHost(java.lang.String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iVirtualBoxGetHost");
        // System.out.println(_this);
        try
        {
            java.lang.String _return = DomainService.getInstance().getName();
            return _return;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
        // throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
    }/*
      * (non-Javadoc)
      * @see org.virtualbox.VboxPortType#iWebsessionManagerLogoff(java.lang.String refIVirtualBox )*
      */

    @Override
    public void iWebsessionManagerLogoff(java.lang.String refIVirtualBox) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        try
        {
            // DomainService.getInstance().getSession().remove(refIVirtualBox);
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }/*
      * (non-Javadoc)
      * @see org.virtualbox.VboxPortType#iHostGetMemorySize(java.lang.String _this )*
      */

    @Override
    public long iHostGetMemorySize(java.lang.String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iHostGetMemorySize");
        // System.out.println(_this);
        try
        {
            Integer memory = DomainService.getInstance().getMemory();
            long _return = Long.valueOf(memory);
            return _return;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
        // throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
    } /*
       * (non-Javadoc)
       * @see org.virtualbox.VboxPortType#iMachineGetName(java.lang.String _this )*
       */

    @Override
    public java.lang.String iMachineGetName(java.lang.String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iMachineGetName");
        // System.out.println(_this);
        VirtualMachineInfo vm = DomainService.getInstance().getVirtualMachines().get(_this);
        if (vm == null || !vm.isSaved())
        {
            throw new InvalidObjectFaultMsg("iMachineGetName: InvalidObjectFaultMsg...");
        }
        java.lang.String _return = vm.getName();
        return _return;
    }/*
      * (non-Javadoc)
      * @see org.virtualbox.VboxPortType#iHostGetNetworkInterfaces(java.lang.String _this )*
      */

    @Override
    public java.util.List<java.lang.String> iHostGetNetworkInterfaces(java.lang.String _this)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iHostGetNetworkInterfaces");
        // System.out.println(_this);
        try
        {
            java.util.List<java.lang.String> _return = new ArrayList<String>();
            List<NetworkInterface> interfaces = DomainService.getInstance().getNetworkInterfaces();
            for (NetworkInterface n : interfaces)
            {
                _return.add(n.getId());
            }
            return _return;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
        // throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
    }/*
      * (non-Javadoc)
      * @see org.virtualbox.VboxPortType#iHostNetworkInterfaceGetName(java.lang.String _this )*
      */

    @Override
    public java.lang.String iHostNetworkInterfaceGetName(java.lang.String _this)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iHostNetworkInterfaceGetName");
        // System.out.println(_this);
        try
        {
            List<NetworkInterface> networkInterfaces =
                DomainService.getInstance().getNetworkInterfaces();
            for (NetworkInterface n : networkInterfaces)
            {
                if (n.getId().equals(_this))
                {
                    return n.getName();
                }
            }
            java.lang.String _return = "";
            return _return;
        }
        catch (java.lang.Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
        // throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
    }/*
      * (non-Javadoc)
      * @see org.virtualbox.VboxPortType#iVirtualBoxGetVersion(java.lang.String _this )*
      */

    @Override
    public java.lang.String iVirtualBoxGetVersion(java.lang.String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        // LOG.info("Executing operation iVirtualBoxGetVersion");
        // System.out.println(_this);
        java.lang.String _return = DomainService.getInstance().getVersion();
        return _return;
        // throw new RuntimeFaultMsg("RuntimeFaultMsg...");
        // throw new InvalidObjectFaultMsg("InvalidObjectFaultMsg...");
    }

    /*
     * Only one virtual machine per session allowed. (non-Javadoc)
     * @see org.virtualbox.VboxPortType#iVirtualBoxCreateMachine(java.lang.String _this
     * ,)java.lang.String settingsFile ,)java.lang.String name ,)java.lang.String osTypeId
     * ,)java.lang.String id ,)boolean forceOverwrite )*
     */
    @Override
    public java.lang.String iVirtualBoxCreateMachine(java.lang.String _this,
        java.lang.String settingsFile, java.lang.String name, java.lang.String osTypeId,
        java.lang.String id, boolean forceOverwrite) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        VirtualMachineInfo vm = new VirtualMachineInfo();
        vm.setSettingsFile(settingsFile);
        vm.setName(name);
        vm.setOsType(osTypeId);
        vm.setId(id);
        vm.setForceOverwrite(forceOverwrite);
        Session session = DomainService.getInstance().getSession().get(_this);
        if (session == null)
        {
            // No session, log again
            throw new InvalidObjectFaultMsg("iVirtualBoxCreateMachine: No session. InvalidObjectFaultMsg...");
        }

        if (session.getVirtualMachine() != null)
        {
            throw new InvalidObjectFaultMsg("iVirtualBoxCreateMachine: No more virtual machines allowed per session. InvalidObjectFaultMsg...");
        }
        session.setVirtualMachine(vm);
        DomainService.getInstance().getVirtualMachines().put(vm.getId(), vm);
        java.lang.String _return = id;
        return _return;
    }

    // @Override
    // public void ivrdeServerSetVRDEProperty(String _this, String key, String value)
    // throws RuntimeFaultMsg, InvalidObjectFaultMsg
    // {
    // VirtualMachineInfo virtualMachine =
    // DomainService.getInstance().getVirtualMachines().get(_this);
    // if (virtualMachine == null)
    // {
    // throw new InvalidObjectFaultMsg("iMachinecpu no such machine id" + _this);
    // }
    // virtualMachine.setRemoteDesktopPort(Integer.valueOf(value));
    // }

    @Override
    public String iMachineGetNetworkAdapter(String _this, long slot) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachinecpu no such machine id" + _this);
        }

        if (!DomainService.getInstance().getNetworkInterfaces().isEmpty())
        {
            NetworkInterface networkInterface =
                DomainService
                    .getInstance()
                    .getNetworkInterfaces()
                    .get(
                        new Random().nextInt(DomainService.getInstance().getNetworkInterfaces()
                            .size()));

            NetworkAdapter net = new NetworkAdapter();
            net.setSlot(slot);
            net.setNetworkInterface(networkInterface);
            virtualMachine.getNetworkAdapters().put(net.getId(), net);
            return net.getId();
        }

        throw new InvalidObjectFaultMsg("iMachineGetNetworkAdapter the mock lacks of network"
            + _this);
    }

    @Override
    public void iMachineAttachDevice(String _this, String name, int controllerPort, int device,
        DeviceType type, String medium) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachinecpu no such machine id" + _this);
        }
        Medium mmedium = DomainService.getInstance().getMediums().get(medium);
        if (mmedium == null)
        {
            throw new InvalidObjectFaultMsg("iMedium: No medium " + medium
                + ". InvalidObjectFaultMsg...");
        }
        mmedium.getAttachedTo().add(virtualMachine.getId());
    }

    @Override
    public String iMachineGetVRDEServer(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachinecpu no such machine id" + _this);
        }

        String remote = UUID.randomUUID().toString();
        virtualMachine.setRemoteDesktop(remote);

        return remote;
    }

    @Override
    public String iMediumGetId(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Medium medium = DomainService.getInstance().getMediums().get(_this);
        if (medium == null)
        {
            throw new InvalidObjectFaultMsg("iMedium: No medium " + _this
                + ". InvalidObjectFaultMsg...");
        }
        return _this;
    }

    @Override
    public void iMachineSetCPUProperty(String _this, CPUPropertyType property, boolean value)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachinecpu no such machine id" + _this);
        }
        virtualMachine.getCpuProps().put(property, value);
    }

    @Override
    public String iMachineAddStorageController(String _this, String name, StorageBus connectionType)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachinecpu no such machine id" + _this);
        }

        Storage storage = new Storage();
        storage.setName(name);
        storage.setBus(connectionType);
        virtualMachine.getStorages().put(storage.getId(), storage);
        return storage.getId();
    }

    @Override
    public void iMachineSetCPUCount(String _this, long cpuCount) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachinecpu no such machine id" + _this);
        }
        virtualMachine.setCpu(cpuCount);
    }

    @Override
    public void iMachineSetMemorySize(String _this, long memorySize) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachineMemory no such machine id" + _this);
        }
        virtualMachine.setMemory(memorySize);
    }

    @Override
    public void iMediumClose(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Medium medium = DomainService.getInstance().getMediums().get(_this);
        if (medium == null)
        {
            throw new InvalidObjectFaultMsg("iMedium: No medium " + _this
                + ". InvalidObjectFaultMsg...");
        }
        if (!medium.getAttachedTo().isEmpty())
        {
            throw new InvalidObjectFaultMsg("iMedium: attached medium " + _this
                + ". InvalidObjectFaultMsg...");
        }
        medium.setClosed(Boolean.TRUE);
    }

    /** Return the progress to the task */
    @Override
    public String iMediumCloneTo(String _this, String target, long variant, String parent)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Medium medium = DomainService.getInstance().getMediums().get(_this);
        Medium mtarget = DomainService.getInstance().getMediums().get(target);
        if (medium == null || mtarget == null)
        {
            throw new InvalidObjectFaultMsg("iMediumCloneTo: No such mediums " + _this + ", "
                + target + " . InvalidObjectFaultMsg...");
        }
        mtarget.setVariant(variant);

        Progress progress = new Progress();
        DomainService.getInstance().getTasks().put(progress.getId(), progress);
        return progress.getId();
    }

    @Override
    public void iProgressWaitForCompletion(String _this, int timeout) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
    }

    @Override
    public String iVirtualBoxCreateHardDisk(String _this, String format, String location)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Session session = DomainService.getInstance().getSession().get(_this);
        if (session == null)
        {
            // No session, log again
            throw new InvalidObjectFaultMsg("iVirtualBoxCreateHardDisk: No session. InvalidObjectFaultMsg...");
        }

        Set<Object> set = session.getData();
        Medium medium = new Medium();
        medium.setLocation(location);
        medium.setDeviceType(DeviceType.HARD_DISK);
        medium.setClosed(Boolean.FALSE);

        if (session.getVirtualMachine() == null)
        {

            throw new InvalidObjectFaultMsg("iVirtualBoxCreateHardDisk: No virtual machine session. InvalidObjectFaultMsg...");
        }
        DomainService.getInstance().getMediums().put(medium.getId(), medium);
        set.add(medium);
        session.getVirtualMachine().setDiskSourceLocation(location);
        return medium.getId();
    }

    @Override
    public int iProgressGetResultCode(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Progress progress = DomainService.getInstance().getTasks().get(_this);
        if (progress == null)
        {
            // No session, log again
            throw new InvalidObjectFaultMsg("iProgressGetResultCode: No task. InvalidObjectFaultMsg...");
        }
        return 0;
    }

    @Override
    public boolean iProgressGetCompleted(String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        Progress session = DomainService.getInstance().getTasks().get(_this);
        if (session == null)
        {
            // No session, log again
            throw new InvalidObjectFaultMsg("iProgressGetCompleted: No task. InvalidObjectFaultMsg...");
        }
        return session.isCompleted();
    };

    @Override
    public String iProgressGetDescription(String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        return iProgressGetOperationDescription(_this);
    }

    @Override
    public String iProgressGetOperationDescription(String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {

        Progress progress = DomainService.getInstance().getTasks().get(_this);
        if (progress == null)
        {
            // No session, log again
            throw new InvalidObjectFaultMsg("iProgressGetOperationDescription: No task. InvalidObjectFaultMsg...");
        }

        return progress.getDescription();
    }

    @Override
    public long iProgressGetOperationPercent(String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        Progress progress = DomainService.getInstance().getTasks().get(_this);
        if (progress == null)
        {
            // No session, log again
            throw new InvalidObjectFaultMsg("iProgressGetOperationPercent: No task. InvalidObjectFaultMsg...");
        }

        return progress.getProgress();
    }

    @Override
    public String iVirtualBoxOpenMedium(String _this, String location, DeviceType deviceType,
        AccessMode accessMode, boolean forceNewUuid) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Session session = DomainService.getInstance().getSession().get(_this);
        if (session == null)
        {
            // No session, log again
            throw new InvalidObjectFaultMsg("iVirtualBoxOpenMedium: No session. InvalidObjectFaultMsg...");
        }
        Set<Object> set = session.getData();
        Medium medium = new Medium();
        medium.setLocation(location);
        medium.setDeviceType(deviceType);
        medium.setClosed(Boolean.FALSE);

        set.add(medium);
        DomainService.getInstance().getMediums().put(medium.getId(), medium);
        return medium.getId();
    }

    @Override
    public String iMediumGetFormat(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Medium medium = DomainService.getInstance().getMediums().get(_this);
        if (medium == null)
        {
            throw new InvalidObjectFaultMsg("iMediumGetFormat: No medium " + _this
                + ". InvalidObjectFaultMsg...");
        }
        return medium.getFormat();
    }

    @Override
    public long iMediumGetVariant(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Medium medium = DomainService.getInstance().getMediums().get(_this);

        if (medium == null)
        {
            throw new InvalidObjectFaultMsg("iMediumGetFormat: No medium " + _this
                + ". InvalidObjectFaultMsg...");
        }
        return medium.getVariant();
    }

    @Override
    public SessionState iSessionGetState(String _this) throws RuntimeFaultMsg,
        InvalidObjectFaultMsg
    {
        Session session = DomainService.getInstance().getSession().get(_this);

        if (session == null)
        {
            // No session, log again
            throw new InvalidObjectFaultMsg("iSessionGetState: No session. InvalidObjectFaultMsg...");
        }
        return session.getState();
    }

    @Override
    public String iSessionGetMachine(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {

        Session session = DomainService.getInstance().getSession().get(_this);
        if (session == null)
        { // No session, log again
            throw new InvalidObjectFaultMsg("iSessionGetMachine: No session. InvalidObjectFaultMsg...");
        }

        if (session.getVirtualMachine() == null)
        {

            throw new InvalidObjectFaultMsg("iSessionGetMachine: No more virtual machines. InvalidObjectFaultMsg...");
        }
        return session.getVirtualMachine().getId();
    }

    @Override
    public MediumState iMediumGetState(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Medium medium = DomainService.getInstance().getMediums().get(_this);
        if (medium == null)
        {
            throw new InvalidObjectFaultMsg("iMediumGetState: No medium " + _this
                + ". InvalidObjectFaultMsg...");
        }

        return medium.getState();
    }

    @Override
    // Cannot find dispatch method for
    // {http://www.virtualbox.org/}INetworkAdapter_attachToBridgedInterface
    public void iNetworkAdapterAttachToBridgedInterface(java.lang.String _this)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
    };

    // Cannot find dispatch method for {http://www.virtualbox.org/}INetworkAdapter_setHostInterface

    @Override
    public void iNetworkAdapterSetHostInterface(java.lang.String _this,
        java.lang.String hostInterface) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
    }

    @Override
    public void iMachineSaveSettings(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachineMemory no such machine id" + _this);
        }
        virtualMachine.setSaved(Boolean.TRUE);
    }

    @Override
    public String iMachineLaunchVMProcess(String _this, String session, String type,
        String environment) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {

        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachineLaunchVMProcess no such machine id" + _this);
        }
        virtualMachine.setMachineState(MachineState.RUNNING);
        Progress progress = new Progress();
        progress.setDescription(type + " " + environment);
        DomainService.getInstance().getTasks().put(progress.getId(), progress);
        return progress.getId();
    }

    @Override
    public void iConsolePowerButton(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // TODO Auto-generated method stub
        super.iConsolePowerButton(_this);
    }

    @Override
    public String iConsolePowerDown(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iConsolePowerDown no such machine id" + _this);
        }
        virtualMachine.setMachineState(MachineState.POWERED_OFF);
        Progress progress = new Progress();
        progress.setDescription("PowerOff ");
        DomainService.getInstance().getTasks().put(progress.getId(), progress);
        return progress.getId();
    }

    @Override
    public String iConsolePowerUp(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iConsolePowerUp no such machine id" + _this);
        }
        virtualMachine.setMachineState(MachineState.RUNNING);
        Progress progress = new Progress();
        progress.setDescription("Power");
        DomainService.getInstance().getTasks().put(progress.getId(), progress);
        return progress.getId();
    }

    @Override
    public String iConsolePowerUpPaused(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        // TODO Auto-generated method stub
        return super.iConsolePowerUpPaused(_this);
    }

    @Override
    public void iMachineLockMachine(String _this, String session, LockType lockType)
        throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Session msession = DomainService.getInstance().getSession().get(session);
        if (msession == null)
        { // No session, log again
            throw new InvalidObjectFaultMsg("iSessionGetMachine: No session. InvalidObjectFaultMsg...");
        }
        VirtualMachineInfo virtualMachine =
            DomainService.getInstance().getVirtualMachines().get(_this);
        if (virtualMachine == null)
        {
            throw new InvalidObjectFaultMsg("iMachineMemory no such machine id" + _this);
        }
        msession.getData().add(virtualMachine);
    }

    @Override
    public String iSessionGetConsole(String _this) throws RuntimeFaultMsg, InvalidObjectFaultMsg
    {
        Session session = DomainService.getInstance().getSession().get(_this);
        if (session == null)
        { // No session, log again
            throw new InvalidObjectFaultMsg("iSessionGetMachine: No session. InvalidObjectFaultMsg...");
        }
        return session.getConsole();
    }
}
