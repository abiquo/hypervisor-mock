package com.abiquo.mock.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

/**
 * @author <a href="mailto:serafin.sedano@abiquo.com">Serafin Sedano</a>
 */
public class ConfigurationService
{

    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationService.class.getName());

    private static ConfigurationService configurationService;

    private final Yaml yaml;

    private final Map<String, Object> map;

    private ConfigurationService()
    {
        InputStream inputStream = ConfigurationService.class.getResourceAsStream("/conf/vbox.yaml");

        if (inputStream == null)
        {
            LOG.error("Couldn't load configuration file vbox.yaml in conf folder!");
            throw new RuntimeException();
        }
        yaml = new Yaml();
        map = yaml.loadAs(inputStream, Map.class);
        LOG.debug("File Loaded: {}", yaml.dump(map));
    }

    private ConfigurationService(String path) throws FileNotFoundException
    {
        try
        {
            yaml = new Yaml();
            map = yaml.loadAs(new FileInputStream(new File(path)), Map.class);
            LOG.debug("File Loaded: {}", yaml.dump(map));
        }
        catch (FileNotFoundException ex)
        {
            LOG.error("Couldn't load configuration file vbox.yaml in conf folder!");
            throw ex;
        }
    }

    public static ConfigurationService getInstance()
    {
        if (configurationService == null)
        {
            configurationService = new ConfigurationService();
        }
        return configurationService;
    }

    /**
     * Only callable once.
     * 
     * @param path
     * @return
     */
    public static ConfigurationService getInstance(String path)
    {
        if (configurationService != null)
        {
            throw new RuntimeException("The instance is already created");
        }
        configurationService = new ConfigurationService();
        return configurationService;
    }

    /**
     * Returns the value instantiated accordingly for key in first level in state.
     * 
     * @param key
     * @return An instance of the type clazz. Null if no value for key.
     */
    public <T> T get(String key, Class<T> clazz)
    {
        return clazz.cast(map.get(key));
    }

    /**
     * Returns the value for key in first level in state.
     * 
     * @param key
     * @return the value or null.
     */
    public Object get(String key)
    {
        return map.get(key);
    }

    /**
     * Returns the value for key. If no key in current level it iterates all the map.
     * 
     * @param key
     * @return the value of null.
     */
    public Object value(String key)
    {

        return find(key, map);
    }

    /**
     * Returns the value for key. If no key in current level it iterates all the map. The return
     * type is of the type clazz.
     * 
     * @param key
     * @return An instance of type clazz that is eventually a value for key
     */
    public <T> T value(String key, Class<T> clazz)
    {
        return clazz.cast(find(key, map));
    }

    /**
     * Returns the value for key. If no key in current level it iterates all the map.
     * 
     * @param key
     * @return
     */
    private Object find(String key, Map<String, Object> m)
    {
        Object o = m.get(key);
        for (Entry<String, Object> e : m.entrySet())
        {
            if (o != null)
            {
                return o;
            }
            o = find(key, e.getValue());
        }

        return o;
    }

    /**
     * Returns the value for key chain.<br>
     * <code>pathvalue("Mock", "vm1", "datastore") returns map.get("Mock").get("vm1").get("datastore") </code>
     * 
     * @param keys the path to the value
     * @return
     */
    public Object pathvalue(String... keys)
    {
        return pathvalue(map, keys);
    }

    /**
     * Returns the value for key chain. The return type is of type clazz<br>
     * <code>pathvalue("Mock", "vm1", "datastore") returns map.get("Mock").get("vm1").get("datastore") </code>
     * 
     * @param keys the path to the value
     * @return
     */
    public <T> T pathvalue(Class<T> clazz, String... keys)
    {
        return clazz.cast(pathvalue(map, keys));
    }

    private Object pathvalue(Map<String, Object> m, String... keys)
    {
        if (keys == null || keys.length == 0)
        {
            return null;
        }
        Object value = m.get(keys[0]);
        if (keys.length == 1)
        {
            return value;
        }
        if (value instanceof Map)
        {
            return pathvalue((Map) value, Arrays.copyOfRange(keys, 1, keys.length));
        }

        return null;
    }

    private Object find(String key, Object e)
    {
        if (e instanceof Map)
        {
            return find(key, (Map) e);
        }
        return null;
    }

}
