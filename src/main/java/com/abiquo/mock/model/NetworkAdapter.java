package com.abiquo.mock.model;

import java.util.UUID;

/**
 * {networkinterface {name, mac}}
 * 
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 * @author <a href="mailto:enric.ruiz@abiquo.com">Enric Ruiz</a>
 * @version 1.0
 */
public class NetworkAdapter
{

    private final String uuid;

    /**
     * 
     */
    private String name;

    private NetworkInterface networkInterface;

    private long slot;

    public NetworkAdapter()
    {
        uuid = UUID.randomUUID().toString();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public String getId()
    {
        return uuid;
    }

    public long getSlot()
    {
        return slot;
    }

    public void setSlot(long slot)
    {
        this.slot = slot;
    }

    public NetworkInterface getNetworkInterface()
    {
        return networkInterface;
    }

    public void setNetworkInterface(NetworkInterface networkInterface)
    {
        this.networkInterface = networkInterface;
    }
}
