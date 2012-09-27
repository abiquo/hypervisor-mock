package com.abiquo.mock.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.virtualbox.InvalidObjectFault;
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

    private static final Map<String, List<Object[]>> cache = Collections
        .synchronizedMap(new HashMap<String, List<Object[]>>());

    private static volatile JAXBContext jaxbContext;

    private final Random random = new Random();

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
            LOG.trace("Inbound message:");
            LogicalMessage lm = context.getMessage();

            try
            {
                Object payload = lm.getPayload(getJaxbContext());
                LOG.debug("Checking failure for {} ", payload.getClass().getSimpleName());
                String message = checkFailure(payload.getClass().getSimpleName());
                if (message != null)
                {
                    InvalidObjectFault faultMsg = new InvalidObjectFault();
                    faultMsg.setBadObjectID(message);
                    lm.setPayload(faultMsg, getJaxbContext());
                    return Boolean.FALSE;
                }
            }
            catch (JAXBException e)
            {
                LOG.error("Error in delay {} {}", new Object[] {e.getClass(), e.getMessage()});

            }
            LOG.trace("Time Elapsed fail {}ms", System.currentTimeMillis() - currentTimeMillis);
        }

        return true;
    }

    private String checkFailure(final String method)
    {
        List<Object[]> list = cache.get(method);
        if (list == null)
        {
            list = addToCache(method);

            cache.put(method, list);
        }

        for (Object[] o : list)
        {
            Integer ratio = (Integer) o[1];
            String msg = (String) o[3];

            if (ratio > 0 && ratio >= random.nextInt(101))
            {

                LOG.info("Error raised method {} {} {} {}", o);

                return msg;
            }
        }
        return null;
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
    private List<Object[]> addToCache(final String method)
    {
        List<Map<String, Object>> fails =
            ConfigurationService.getInstance().pathvalue(List.class, Constants.BEHAVIOR,
                method.substring(0, 1).toLowerCase().concat(method.substring(1)),
                Constants.FAILURES);

        List<Object[]> list = new ArrayList<Object[]>();
        if (fails == null)
        {
            return list;
        }
        for (Map<String, Object> o : fails)
        {
            // These entries are : ratio, message and exception
            try
            {
                String exc = (String) o.remove(Constants.EXCEPTION);
                String msg = (String) o.remove(Constants.MESSAGE);
                Set<Entry<String, Object>> e = o.entrySet();
                if (e.size() != 1)
                {
                    continue;
                }
                Entry<String, Object>[] array = e.toArray(new Entry[0]);
                String description = array[0].getKey();
                Integer ratio = (Integer) array[0].getValue();

                Object[] fail = new Object[] {description, ratio, exc, msg};
                list.add(fail);
            }
            catch (ClassCastException e)
            {
                LOG.error("Error in ratio, expecting a number", e);
            }
        }
        return list;
    }

    @Override
    public void close(final MessageContext context)
    {

    }
}
