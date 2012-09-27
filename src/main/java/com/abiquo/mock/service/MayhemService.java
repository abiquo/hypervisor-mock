package com.abiquo.mock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abiquo.mock.configuration.ConfigurationService;
import com.abiquo.mock.domain.DomainService;
import com.abiquo.mock.model.HostInfo;
import com.abiquo.vbox.VboxPortType_VboxServicePort_Server;

/**
 * This is the main class of the Mock. This starts the mocks and checks periodically to apply some
 * fun!
 * 
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 */
public class MayhemService
{

    private final static Logger LOG = LoggerFactory.getLogger(MayhemService.class);

    private final static String DEFAULT_CONFIG_FILE = "/conf/vbox.yaml";

    private final HostInfo domain;

    private final ConfigurationService config;

    private final VboxPortType_VboxServicePort_Server MOCK;

    public static void main(final String args[]) throws Exception
    {

        String file = DEFAULT_CONFIG_FILE;
        if (args.length == 1)
        {
            file = args[0];
        }
        MayhemService mayhem = new MayhemService(file);

        Long loop = 1000l; // mayhem.config.pathvalue(Integer.valueOf(0), Number.class,
                           // Constants.BEHAVIOR, Constants.TICKS).longValue();
        if (loop < 1)
        {
            throw new IllegalArgumentException("The ticks parameter shouldn't be empty or < 0");
        }
        while (true)
        {
            int i = 0;
        }
    }

    private MayhemService(final String path) throws Exception
    {
        config = ConfigurationService.getInstance(path);
        domain = DomainService.getInstance();
        MOCK = VboxPortType_VboxServicePort_Server.getInstance();
    }
}
