package com.abiquo.mock.service;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.abiquo.mock.configuration.ConfigurationService;
import com.abiquo.mock.configuration.Constants;
import com.abiquo.mock.domain.DomainService;
import com.abiquo.mock.model.HostInfo;
import com.abiquo.mock.model.VirtualMachineInfo;
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

    private final Random random = new Random();

    public static void main(final String args[]) throws Exception
    {

        String file = DEFAULT_CONFIG_FILE;
        if (args.length == 1)
        {
            file = args[0];
        }

        LOG.info("Loadin file {}", file);
        MayhemService mayhem = new MayhemService(file);

        Long loop =
            mayhem.config.pathvalue(Integer.valueOf(0), Number.class, Constants.BEHAVIOR,
                Constants.TICKS).longValue();

        long destroyTicks =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.DESTROY_VM_TICKS).longValue();

        long disconnectTicks =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.HYPERVISOR_DISCONNECT_TICKS).longValue();

        long aimTicks =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.AIM_DISCONNECT_TICKS).longValue();

        long createTicks =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.CREATE_VM_TICKS).longValue();

        long destroyRatio =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.DESTROY_VM_RATIO).longValue();

        long disconnectRatio =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.HYPERVISOR_DISCONNECT_RATIO).longValue();
        long aimRatio =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.AIM_DISCONNECT_RATIO).longValue();

        long createRatio =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.CREATE_VM_RATIO).longValue();

        long disconnect =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.HYPERVISOR_DISCONNECT).longValue();
        long aimdisconnect =
            mayhem.config.pathvalue(Long.MAX_VALUE, Number.class, Constants.BEHAVIOR,
                Constants.AIM_DISCONNECT).longValue();

        if (loop < 1)
        {
            throw new IllegalArgumentException("The ticks parameter shouldn't be empty or < 0");
        }

        long destElapsed = Long.valueOf(0);
        long createElapsed = Long.valueOf(0);
        long discElapsed = Long.valueOf(0);
        long aimElapsed = Long.valueOf(0);

        LOG.info("Starting mock with delay {}ms", loop);
        while (Boolean.TRUE)
        {
            LOG.debug("Loop sleep");
            Thread.sleep(loop);
            LOG.debug("Loop ok");

            destElapsed += loop;
            createElapsed += loop;
            discElapsed += loop;
            aimElapsed += loop;

            if (destroyRatio > 0 && destElapsed >= destroyTicks)
            {
                destElapsed = 0;
                mayhem.processDestroy(destroyRatio);
            }
            if (createRatio > 0 && createElapsed >= createTicks)
            {
                createElapsed = 0;
                mayhem.processCreate(createRatio);
            }
            if (disconnectRatio > 0 && discElapsed >= disconnectTicks)
            {
                discElapsed = 0;
                mayhem.processVboxDisconnect(disconnectRatio, disconnect);
            }
            if (aimRatio > 0 && aimElapsed >= aimTicks)
            {
                aimElapsed = 0;
                mayhem.processAimDisconnect(aimRatio, aimdisconnect);
            }
        }
    }

    /**
     * Shall I disconnect the vbox?
     * 
     * @param disconnectRatio ratio
     * @param disconnect ms
     * @throws InterruptedException
     * @throws IOException
     */
    private void processVboxDisconnect(final long disconnectRatio, final long disconnect)
        throws InterruptedException, IOException
    {
        if (disconnectRatio >= random.nextInt(100) + 1)
        {
            LOG.info("Stopping vbox for {}", disconnect);
            MOCK.stopVbox();

            LOG.debug("VirtualBox stopped");
            Thread.sleep(disconnect);

            LOG.debug("Starting VirtualBox");
            MOCK.startVbox();
            LOG.info("Started vbox");
        }
    }

    /**
     * Shall I disconnect the aim?
     * 
     * @param disconnectRatio ratio
     * @param disconnect ms
     * @throws Exception
     * @throws IOException
     */
    private void processAimDisconnect(final long disconnectRatio, final long disconnect)
        throws Exception
    {
        if (disconnectRatio >= random.nextInt(100) + 1)
        {
            LOG.info("Stopping aim for {}", disconnect);
            MOCK.stopAim();

            LOG.debug("aim stopped");
            Thread.sleep(disconnect);

            LOG.debug("Starting aim");
            MOCK.startAim();
            LOG.info("Started aim");
        }
    }

    /**
     * Shall I destroy a random vm?
     * 
     * @param destroyRatio ratio
     */
    private void processDestroy(final long destroyRatio)
    {
        if (domain.getVirtualMachines().size() > 0 && destroyRatio >= random.nextInt(100) + 1)
        {
            VirtualMachineInfo[] array =
                domain.getVirtualMachines().values().toArray(new VirtualMachineInfo[0]);
            VirtualMachineInfo vm = array[random.nextInt(array.length)];
            LOG.debug("Destroying virtual machine {}", vm.getId());
            domain.getVirtualMachines().remove(vm.getId());
            LOG.info("Destroying virtual machine {}", vm.getId());
        }
    }

    /**
     * Shall I create a new vm?
     * 
     * @param createRatio
     */
    private void processCreate(final long createRatio)
    {
        if (createRatio >= random.nextInt(100) + 1)
        {
            VirtualMachineInfo vm = new VirtualMachineInfo();
            vm.setSettingsFile("settingsFile");
            vm.setName("name");
            vm.setOsType("osTypeId");
            vm.setId(UUID.randomUUID().toString());
            vm.setSaved(Boolean.TRUE);
            vm.setRegistered(Boolean.TRUE);
            LOG.debug("Creating a virtual machine");
            DomainService.getInstance().getVirtualMachines().put(vm.getId(), vm);
            LOG.info("Created virtual machine {}", vm.getId());
        }
    }

    private MayhemService(final String path) throws Exception
    {
        config = ConfigurationService.getInstance(path);
        domain = DomainService.getInstance();
        MOCK = VboxPortType_VboxServicePort_Server.getInstance();
    }
}
