package com.abiquo.mock.handlers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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

/**
 * Handler that applies the delay.
 * 
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 */
public class DelayHandler implements LogicalHandler<LogicalMessageContext>
{

    private static final Logger LOG = LoggerFactory.getLogger(DelayHandler.class);

    private static final Map<String, Long> cache = Collections
        .synchronizedMap(new HashMap<String, Long>());

    private Number delay = -1;

    private static volatile JAXBContext jaxbContext;

    @Override
    public boolean handleFault(final LogicalMessageContext context)
    {
        return true;
    }

    @Override
    public boolean handleMessage(final LogicalMessageContext context)
    {
        Boolean outbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!outbound)
        {
            long currentTimeMillis = System.currentTimeMillis();
            LOG.trace("HandlerDelay: Inbound message:");
            LogicalMessage lm = context.getMessage();

            try
            {
                Object payload = lm.getPayload(getJaxbContext());
                LOG.debug("Adding delay for {} ", payload.getClass().getSimpleName());
                applyDelay(payload.getClass().getSimpleName());
            }
            catch (JAXBException e)
            {
                LOG.error("Error in delay {} {}", new Object[] {e.getClass(), e.getMessage()});
            }
            LOG.trace("Time elapsed  delay {}ms", System.currentTimeMillis() - currentTimeMillis);
        }

        return true;
    }

    private JAXBContext getJaxbContext() throws JAXBException
    {
        if (jaxbContext == null)
        {
            jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
        }
        return jaxbContext;
    }

    private void applyDelay(final String method)
    {
        try
        {
            long methodDelay = getDelay(method);
            if (methodDelay > 0)
            {
                Thread.sleep(methodDelay);
            }
            LOG.debug("Adding delay for {} {}ms ", new Object[] {method, methodDelay});
        }
        catch (Exception e)
        {
            LOG.error("Error applying delay {} {}",
                new Object[] {e.getClass().getSimpleName(), e.getMessage()});
        }
    }

    private long getDelay(final String method)
    {
        Long d = cache.get(method);

        if (d == null)
        {

            Number methodDelay =
                ConfigurationService.getInstance().pathvalue(Number.class, Constants.BEHAVIOR,
                    method.substring(0, 1).toLowerCase().concat(method.substring(1)),
                    Constants.DELAY);
            if (methodDelay != null)
            {
                d = methodDelay.longValue();
            }
            else if (delay.equals(-1))
            {
                delay =
                    ConfigurationService.getInstance().pathvalue(Integer.valueOf(0), Number.class,
                        Constants.BEHAVIOR, Constants.DELAY);
            }
            d = delay.longValue();

            cache.put(method, d);
        }

        return d;
    }

    @Override
    public void close(final MessageContext context)
    {

    }
}
