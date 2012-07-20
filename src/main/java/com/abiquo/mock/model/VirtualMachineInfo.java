package com.abiquo.mock.model;

import java.util.HashMap;
import java.util.Map;

import org.virtualbox.CPUPropertyType;
import org.virtualbox.MachineState;

public class VirtualMachineInfo
{

    private String id;

    private String settingsFile;

    private String name;

    private String osType;

    private boolean forceOverwrite;

    /**
     * This field is set to true once the vm has been registered (iVirtualBoxRegisterMachine)
     */
    private boolean registered;

    private MachineState machineState;

    private Map<String, Storage> storages;

    /**
     * Until the code iMachineSaveSettings is called
     */
    private boolean saved;

    /**
     * Original location of the disk
     */
    private String diskSourceLocation;

    private long cpu;

    private long memory;

    private Map<CPUPropertyType, Boolean> cpuProps;

    private String remoteDesktop;
    
    private int remoteDesktopPort;

    private Map<String, NetworkAdapter> networkAdapters;

    public VirtualMachineInfo()
    {
        saved = Boolean.FALSE;
        registered = Boolean.FALSE;
        machineState = MachineState.NULL;

    }

    /**
     * This field is set to true once the vm has been registered (iVirtualBoxRegisterMachine)
     */
    public boolean isRegistered()
    {
        return registered;
    }

    /**
     * This field is set to true once the vm has been registered (iVirtualBoxRegisterMachine)
     */
    public void setRegistered(boolean registered)
    {
        this.registered = registered;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getSettingsFile()
    {
        return settingsFile;
    }

    public void setSettingsFile(String settingsFile)
    {
        this.settingsFile = settingsFile;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getOsType()
    {
        return osType;
    }

    public void setOsType(String osType)
    {
        this.osType = osType;
    }

    public boolean isForceOverwrite()
    {
        return forceOverwrite;
    }

    public void setForceOverwrite(boolean forceOverwrite)
    {
        this.forceOverwrite = forceOverwrite;
    }

    public MachineState getMachineState()
    {
        return machineState;
    }

    public void setMachineState(MachineState machineState)
    {
        this.machineState = machineState;
    }

    public boolean isSaved()
    {
        return saved;
    }

    public void setSaved(boolean saved)
    {
        this.saved = saved;
    }

    public String getDiskSourceLocation()
    {
        return diskSourceLocation;
    }

    public void setDiskSourceLocation(String diskSourceLocation)
    {
        this.diskSourceLocation = diskSourceLocation;
    }

    public long getCpu()
    {
        return cpu;
    }

    public void setCpu(long cpu)
    {
        this.cpu = cpu;
    }

    public long getMemory()
    {
        return memory;
    }

    public void setMemory(long memory)
    {
        this.memory = memory;
    }

    public Map<String, Storage> getStorages()
    {
        if (storages == null)
        {
            storages = new HashMap<String, Storage>();
        }
        return storages;
    }

    public Map<CPUPropertyType, Boolean> getCpuProps()
    {

        if (cpuProps == null)
        {
            cpuProps = new HashMap<CPUPropertyType, Boolean>();

        }
        return cpuProps;
    }

    public String getRemoteDesktop()
    {
        return remoteDesktop;
    }

    public void setRemoteDesktop(String remoteDesktop)
    {
        this.remoteDesktop = remoteDesktop;
    }

    public Map<String, NetworkAdapter> getNetworkAdapters()
    {
        if (networkAdapters == null)
        {
            networkAdapters = new HashMap<String, NetworkAdapter>();
        }
        return networkAdapters;
    }

    public int getRemoteDesktopPort()
    {
        return remoteDesktopPort;
    }

    public void setRemoteDesktopPort(int remoteDesktopPort)
    {
        this.remoteDesktopPort = remoteDesktopPort;
    }

}
