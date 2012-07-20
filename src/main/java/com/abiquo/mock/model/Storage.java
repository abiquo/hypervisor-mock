package com.abiquo.mock.model;

import java.util.UUID;

import org.virtualbox.StorageBus;

public class Storage
{
    private String id;

    private StorageBus bus;

    private String name;

    public Storage()
    {
        id = UUID.randomUUID().toString();
    }

    public String getId()
    {
        return id;
    }

    public StorageBus getBus()
    {
        return bus;
    }

    public void setBus(StorageBus bus)
    {
        this.bus = bus;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
