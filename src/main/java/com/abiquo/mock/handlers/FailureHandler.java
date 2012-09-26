package com.abiquo.mock.handlers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

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
 * This handler applies fail.
 * 
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 */
public class FailureHandler implements LogicalHandler<LogicalMessageContext>
{

    private static final Logger LOG = LoggerFactory.getLogger(FailureHandler.class);

    private static final Map<String, Long> cache = Collections
        .synchronizedMap(new HashMap<String, Long>());

    private static volatile JAXBContext jaxbContext;

    private final Random r = new Random();

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
            System.out.println("Inbound message:");
            LogicalMessage lm = context.getMessage();

            try
            {
                Object payload = lm.getPayload(getJaxbContext());
                LOG.debug("Checking failure for {} ", payload.getClass().getSimpleName());

                checkFailure(payload.getClass().getSimpleName());
            }
            catch (JAXBException e)
            {
                LOG.error("Error in delay {} {}", new Object[] {e.getClass(), e.getMessage()});

                System.out.println(e + " " + e.getMessage());
            }

            System.out.println("Time Elapsed fail "
                + (System.currentTimeMillis() - currentTimeMillis) + "ms");
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

    /** This method checks if there is a fail condition and add exception to the payload. */
    private void checkFailure(String method)
    {
        List<Map<String, Object>> fails =
            ConfigurationService.getInstance().pathvalue(List.class, Constants.BEHAVIOR,
                method.substring(0, 1).toLowerCase().concat(method.substring(1)),
                Constants.FAILURES);

        System.out.println("failure: " + method);
        if (fails == null)
        {
            return;
        }
        for (Map<String, Object> o : fails)
        {
            for (Entry<String, Object> e : o.entrySet())
            {
                LOG.debug("Failure {}, ratio {}", new Object[] {e.getKey(), e.getValue()});
                System.out.println("Failure" + e.getKey() + ", ratio {}" + e.getValue());
                
            }
        }
    }

    @Override
    public void close(final MessageContext context)
    {

    }
}
