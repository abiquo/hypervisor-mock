package com.abiquo.mock.model;

import java.util.ArrayList;
import java.util.List;

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

}
