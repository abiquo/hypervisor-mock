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

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        VirtualMachineInfo other = (VirtualMachineInfo) obj;
        if (cpu != other.cpu)
        {
            return false;
        }
        if (cpuProps == null)
        {
            if (other.cpuProps != null)
            {
                return false;
            }
        }
        else if (!cpuProps.equals(other.cpuProps))
        {
            return false;
        }
        if (diskSourceLocation == null)
        {
            if (other.diskSourceLocation != null)
            {
                return false;
            }
        }
        else if (!diskSourceLocation.equals(other.diskSourceLocation))
        {
            return false;
        }
        if (forceOverwrite != other.forceOverwrite)
        {
            return false;
        }
        if (id == null)
        {
            if (other.id != null)
            {
                return false;
            }
        }
        else if (!id.equals(other.id))
        {
            return false;
        }
        if (machineState != other.machineState)
        {
            return false;
        }
        if (memory != other.memory)
        {
            return false;
        }
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else if (!name.equals(other.name))
        {
            return false;
        }
        if (networkAdapters == null)
        {
            if (other.networkAdapters != null)
            {
                return false;
            }
        }
        else if (!networkAdapters.equals(other.networkAdapters))
        {
            return false;
        }
        if (osType == null)
        {
            if (other.osType != null)
            {
                return false;
            }
        }
        else if (!osType.equals(other.osType))
        {
            return false;
        }
        if (registered != other.registered)
        {
            return false;
        }
        if (remoteDesktop == null)
        {
            if (other.remoteDesktop != null)
            {
                return false;
            }
        }
        else if (!remoteDesktop.equals(other.remoteDesktop))
        {
            return false;
        }
        if (remoteDesktopPort != other.remoteDesktopPort)
        {
            return false;
        }
        if (saved != other.saved)
        {
            return false;
        }
        if (settingsFile == null)
        {
            if (other.settingsFile != null)
            {
                return false;
            }
        }
        else if (!settingsFile.equals(other.settingsFile))
        {
            return false;
        }
        if (storages == null)
        {
            if (other.storages != null)
            {
                return false;
            }
        }
        else if (!storages.equals(other.storages))
        {
            return false;
        }
        return true;
    }

    public long getCpu()
    {
        return cpu;
    }

    public Map<CPUPropertyType, Boolean> getCpuProps()
    {

        if (cpuProps == null)
        {
            cpuProps = new HashMap<CPUPropertyType, Boolean>();

        }
        return cpuProps;
    }

    public String getDiskSourceLocation()
    {
        return diskSourceLocation;
    }

    public String getId()
    {
        return id;
    }

    public MachineState getMachineState()
    {
        return machineState;
    }

    public long getMemory()
    {
        return memory;
    }

    public String getName()
    {
        return name;
    }

    public Map<String, NetworkAdapter> getNetworkAdapters()
    {
        if (networkAdapters == null)
        {
            networkAdapters = new HashMap<String, NetworkAdapter>();
        }
        return networkAdapters;
    }

    public String getOsType()
    {
        return osType;
    }

    public String getRemoteDesktop()
    {
        return remoteDesktop;
    }

    public int getRemoteDesktopPort()
    {
        return remoteDesktopPort;
    }

    public String getSettingsFile()
    {
        return settingsFile;
    }

    public Map<String, Storage> getStorages()
    {
        if (storages == null)
        {
            storages = new HashMap<String, Storage>();
        }
        return storages;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (cpu ^ cpu >>> 32);
        result = prime * result + (cpuProps == null ? 0 : cpuProps.hashCode());
        result = prime * result + (diskSourceLocation == null ? 0 : diskSourceLocation.hashCode());
        result = prime * result + (forceOverwrite ? 1231 : 1237);
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (machineState == null ? 0 : machineState.hashCode());
        result = prime * result + (int) (memory ^ memory >>> 32);
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (networkAdapters == null ? 0 : networkAdapters.hashCode());
        result = prime * result + (osType == null ? 0 : osType.hashCode());
        result = prime * result + (registered ? 1231 : 1237);
        result = prime * result + (remoteDesktop == null ? 0 : remoteDesktop.hashCode());
        result = prime * result + remoteDesktopPort;
        result = prime * result + (saved ? 1231 : 1237);
        result = prime * result + (settingsFile == null ? 0 : settingsFile.hashCode());
        result = prime * result + (storages == null ? 0 : storages.hashCode());
        return result;
    }

    public boolean isForceOverwrite()
    {
        return forceOverwrite;
    }

    /**
     * This field is set to true once the vm has been registered (iVirtualBoxRegisterMachine)
     */
    public boolean isRegistered()
    {
        return registered;
    }

    public boolean isSaved()
    {
        return saved;
    }

    public void setCpu(final long cpu)
    {
        this.cpu = cpu;
    }

    public void setDiskSourceLocation(final String diskSourceLocation)
    {
        this.diskSourceLocation = diskSourceLocation;
    }

    public void setForceOverwrite(final boolean forceOverwrite)
    {
        this.forceOverwrite = forceOverwrite;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public void setMachineState(final MachineState machineState)
    {
        this.machineState = machineState;
    }

    public void setMemory(final long memory)
    {
        this.memory = memory;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setOsType(final String osType)
    {
        this.osType = osType;
    }

    /**
     * This field is set to true once the vm has been registered (iVirtualBoxRegisterMachine)
     */
    public void setRegistered(final boolean registered)
    {
        this.registered = registered;
    }

    public void setRemoteDesktop(final String remoteDesktop)
    {
        this.remoteDesktop = remoteDesktop;
    }

    public void setRemoteDesktopPort(final int remoteDesktopPort)
    {
        this.remoteDesktopPort = remoteDesktopPort;
    }

    public void setSaved(final boolean saved)
    {
        this.saved = saved;
    }

    public void setSettingsFile(final String settingsFile)
    {
        this.settingsFile = settingsFile;
    }

}
