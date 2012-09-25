package com.abiquo.mock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abiquo.mock.configuration.ConfigurationService;
import com.abiquo.mock.configuration.Constants;
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

    private final HostInfo domain;

    private final ConfigurationService config;

    private final VboxPortType_VboxServicePort_Server MOCK;

    public static void main(final String args[]) throws java.lang.Exception
    {
        MayhemService mayhem = new MayhemService();

        int loop = mayhem.config.pathvalue(Integer.class, Constants.BEHAVIOR, Constants.TICKS);
        while (true)
        {
            int i = 0;
        }
    }

    private MayhemService() throws Exception
    {
        MOCK = VboxPortType_VboxServicePort_Server.getInstance();
        domain = DomainService.getInstance();
        config = ConfigurationService.getInstance();
    }
}
