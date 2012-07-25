package com.abiquo.mock.model;

import java.util.ArrayList;
import java.util.List;

import org.virtualbox.StorageBus;

public class Storage extends Medium
{
    private StorageBus bus;

    private String name;

    private List<String> ports;

    public Storage()
    {
        super();
    }

    public StorageBus getBus()
    {
        return bus;
    }

    public void setBus(final StorageBus bus)
    {
        this.bus = bus;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public List<String> getPorts()
    {
        if (ports == null)
        {
            ports = new ArrayList<String>();
        }
        return ports;
    }

    public int getPortCount()
    {
        return getPorts().size();
    }

}
