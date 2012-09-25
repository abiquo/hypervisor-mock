package com.abiquo.mock.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.abiquo.aimstub.Datastore;

/**
 * This class holds the state of the hypervisor mock.
 * 
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 * @author <a href="mailto:enric.ruiz@abiquo.com">Enric Ruiz</a>
 * @version 1.0
 */
public class HostInfo
{
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer cores;

    /**
     * 
     */
    private Integer memory;

    /**
     * 
     */
    private String version;

    /**
     * {datastores {datastore {device, path, type, size, available}}}
     */
    private List<Datastore> datastores;

    /**
     * {networkinterfaces {networkinterface {name, mac}}}
     */
    private List<NetworkInterface> networkInterfaces;

    private Map<String, VirtualMachineInfo> virtualMachines;

    private Map<String, Session> session;

    private Map<String, Medium> mediums;

    private Map<String, Progress> tasks;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getCores()
    {
        return cores;
    }

    public void setCores(Integer cores)
    {
        this.cores = cores;
    }

    public Integer getMemory()
    {
        return memory;
    }

    public void setMemory(Integer memory)
    {
        this.memory = memory;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public List<Datastore> getDatastores()
    {
        if (datastores == null)
        {
            datastores = new ArrayList<Datastore>();
        }
        return datastores;
    }

    public List<NetworkInterface> getNetworkInterfaces()
    {
        if (networkInterfaces == null)
        {
            networkInterfaces = new ArrayList<NetworkInterface>();
        }
        return networkInterfaces;
    }

    public Map<String, VirtualMachineInfo> getVirtualMachines()
    {
        if (virtualMachines == null)
        {
            virtualMachines = new HashMap<String, VirtualMachineInfo>();
        }
        return virtualMachines;
    }

    public Map<String, Session> getSession()
    {
        if (session == null)
        {
            session = new HashMap<String, Session>();
        }
        return session;
    }

    /**
     * List of the mediums. To see where are they attached if so {@link Medium#getAttachedTo()}
     * 
     * @return mediums.
     */
    public Map<String, Medium> getMediums()
    {
        if (mediums == null)
        {
            mediums = new HashMap<String, Medium>();
        }
        return mediums;
    }

    public Map<String, Progress> getTasks()
    {
        if (tasks == null)
        {
            tasks = new HashMap<String, Progress>();
        }
        return tasks;
    }

}
