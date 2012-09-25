package com.abiquo.mock.handlers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.virtualbox.ObjectFactory;

import com.abiquo.mock.configuration.ConfigurationService;
import com.abiquo.mock.configuration.Constants;

public class DelayHandler implements LogicalHandler<LogicalMessageContext>
{

    private static final Logger LOG = LoggerFactory.getLogger(DelayHandler.class);

    private Number delay = -1;

    @Override
    public boolean handleFault(final LogicalMessageContext context)
    {
        logToSystemOut(context);
        return true;
    }

    @Override
    public boolean handleMessage(final LogicalMessageContext context)
    {
        logToSystemOut(context);
        return true;
    }

    private void logToSystemOut(final LogicalMessageContext context)
    {

        LogicalMessage lm = context.getMessage();
        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Object payload = lm.getPayload(jaxbContext);
            LOG.debug("Adding delay for {} ", payload.getClass().getSimpleName());
            applyDelay(payload.getClass().getSimpleName());
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }

    }

    private void applyDelay(final String method)
    {
        try
        {
            Number methodDelay = getDelay(method);
            if (methodDelay == null)
            {
                Thread.sleep(delay.longValue());
            }
            else
            {
                Thread.sleep(methodDelay.longValue());
            }
            LOG.debug("Adding delay for {} {}ms ", new Object[] {method, 0});
        }
        catch (Exception e)
        {
            LOG.error("Error applying delay {} {}",
                new Object[] {e.getClass().getSimpleName(), e.getMessage()});
        }
    }

    private Number getDelay(final String method)
    {
        Number methodDelay =
            ConfigurationService.getInstance().pathvalue(Number.class, Constants.BEHAVIOR, method,
                Constants.DELAY);
        if (methodDelay != null)
        {
            return methodDelay;
        }
        if (delay.equals(-1))
        {
            delay =
                ConfigurationService.getInstance().pathvalue(Number.class, 0, Constants.BEHAVIOR,
                    Constants.DELAY);
        }
        return delay;
    }

    @Override
    public void close(final MessageContext context)
    {

    }
}
