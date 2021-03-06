package com.abiquo.mock.model;

import java.util.UUID;

/**
 * {networkinterface {name, mac}}
 * 
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 * @author <a href="mailto:enric.ruiz@abiquo.com">Enric Ruiz</a>
 * @version 1.0
 */
public class NetworkInterface
{

    private final String uuid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String mac;

    public NetworkInterface()
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

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getId()
    {
        return uuid;
    }
}
