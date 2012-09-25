package com.abiquo.mock.domain;

import java.math.BigInteger;
import java.util.Map;
import java.util.Map.Entry;

import com.abiquo.aimstub.Datastore;
import com.abiquo.mock.configuration.ConfigurationService;
import com.abiquo.mock.configuration.Constants;
import com.abiquo.mock.model.HostInfo;
import com.abiquo.mock.model.NetworkInterface;

public class DomainService
{

    private static DomainService domainService;

    private final ConfigurationService configurationService;

    private final HostInfo hostInfo;

    public static HostInfo getInstance()
    {
        if (domainService == null)
        {
            domainService = new DomainService();
        }
        return domainService.hostInfo;
    }

    private DomainService()
    {
        configurationService = ConfigurationService.getInstance();
        hostInfo = initalizeHostInfo();
    }

    private HostInfo initalizeHostInfo()
    {
        HostInfo host = new HostInfo();
        host.setName(configurationService.pathvalue(String.class, Constants.HOST, Constants.NAME));
        host.setCores(configurationService
            .pathvalue(Integer.class, Constants.HOST, Constants.CORES));
        host.setMemory(configurationService.pathvalue(Integer.class, Constants.HOST,
            Constants.MEMORY));
        host.setVersion(configurationService.pathvalue(String.class, Constants.HOST,
            Constants.VERSION));
        host = initializeDatastores(host);
        host = initializeNetworkinterfaces(host);
        return host;
    }

    private HostInfo initializeNetworkinterfaces(HostInfo host)
    {

        Map<String, Object> datastores =
            configurationService.pathvalue(Map.class, Constants.HOST, Constants.NETWORKINTERFACES);
        for (Entry<String, Object> e : datastores.entrySet())
        {
            Map<String, Object> ee = (Map<String, Object>) e.getValue();
            NetworkInterface networkInterface = new NetworkInterface();
            String name = (String) ee.get(Constants.NAME);
            String mac = (String) ee.get(Constants.MAC);
            networkInterface.setName(name);
            networkInterface.setMac(mac);
            host.getNetworkInterfaces().add(networkInterface);
        }

        return host;
    }

    private HostInfo initializeDatastores(HostInfo host)
    {

        Map<String, Object> datastores =
            configurationService.pathvalue(Map.class, Constants.HOST, Constants.DATASTORES);
        for (Entry<String, Object> e : datastores.entrySet())
        {
            Map<String, Object> ee = (Map<String, Object>) e.getValue();
            String device = (String) ee.get(Constants.DEVICE);
            String type = (String) ee.get(Constants.TYPE);
            Long available = getLong(ee.get(Constants.AVAILABLE));
            String path = (String) ee.get(Constants.PATH);
            Long size = getLong(ee.get(Constants.SIZE));
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

}
