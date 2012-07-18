package com.abiquo.mock.domain;

import java.math.BigInteger;
import java.util.Map;
import java.util.Map.Entry;

import com.abiquo.aimstub.Datastore;
import com.abiquo.mock.configuration.ConfigurationService;
import com.abiquo.mock.model.HostInfo;
import com.abiquo.mock.model.NetworkInterface;

public class DomainService
{

    private static DomainService domainService;

    ConfigurationService configurationService;

    private final HostInfo hostInfo;

    private DomainService()
    {
        configurationService = ConfigurationService.getInstance();
        hostInfo = initalizeHostInfo();
    }

    private HostInfo initalizeHostInfo()
    {
        HostInfo host = new HostInfo();
        host.setName(configurationService.pathvalue(String.class, "Host", "name"));
        host.setCores(configurationService.pathvalue(Integer.class, "Host", "cores"));
        host.setMemory(configurationService.pathvalue(Integer.class, "Host", "memory"));
        host.setVersion(configurationService.pathvalue(String.class, "Host", "version"));
        host = initializeDatastores(host);
        host = initializeNetworkinterfaces(host);
        return host;
    }

    private HostInfo initializeNetworkinterfaces(HostInfo host)
    {

        Map<String, Object> datastores =
            configurationService.pathvalue(Map.class, "Host", "networkinterfaces");
        for (Entry<String, Object> e : datastores.entrySet())
        {
            Map<String, Object> ee = (Map<String, Object>) e.getValue();
            NetworkInterface networkInterface = new NetworkInterface();
            String name = (String) ee.get("name");
            String mac = (String) ee.get("mac");
            networkInterface.setName(name);
            networkInterface.setMac(mac);
            host.getNetworkInterfaces().add(networkInterface);
        }

        return host;
    }

    private HostInfo initializeDatastores(HostInfo host)
    {

        Map<String, Object> datastores =
            configurationService.pathvalue(Map.class, "Host", "datastores");
        for (Entry<String, Object> e : datastores.entrySet())
        {
            Map<String, Object> ee = (Map<String, Object>) e.getValue();
            String device = (String) ee.get("device");
            String type = (String) ee.get("type");
            Long available = getLong(ee.get("available"));
            String path = (String) ee.get("path");
            Long size = getLong(ee.get("size"));
            host.getDatastores().add(new Datastore(device, path, type, size, available));
        }

        return host;
    }

    private Long getLong(Object number)
    {
        if (number instanceof Integer)
        {
            return Long.valueOf((Integer) number);
        }
        if (number instanceof Long)
        {
            return (Long) number;
        }
        if (number instanceof BigInteger)
        {
            return ((BigInteger) number).longValue();
        }
        return null;
    }

    public static HostInfo getInstance()
    {
        if (domainService == null)
        {
            domainService = new DomainService();
        }
        return domainService.hostInfo;
    }
}
