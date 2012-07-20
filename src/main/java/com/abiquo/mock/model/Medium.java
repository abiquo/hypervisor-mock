package com.abiquo.mock.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.virtualbox.DeviceType;
import org.virtualbox.MediumState;

public class Medium
{
    private String id;

    private String format;

    private long variant;

    private String location;

    private boolean closed;

    private DeviceType deviceType;

    private Set<String> attachedTo;

    private MediumState state;

    public Medium()
    {
        id = UUID.randomUUID().toString();
        state = MediumState.CREATED;
    }

    public String getId()
    {
        return id;
    }

    public void setUuid(String uuid)
    {
        this.id = uuid;
    }

    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    public long getVariant()
    {
        return variant;
    }

    public void setVariant(long variant)
    {
        this.variant = variant;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public boolean isClosed()
    {
        return closed;
    }

    public void setClosed(boolean closed)
    {
        this.closed = closed;
    }

    public DeviceType getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType)
    {
        this.deviceType = deviceType;
    }

    public Set<String> getAttachedTo()
    {
        if (attachedTo == null)
        {
            attachedTo = new HashSet<String>();
        }
        return attachedTo;
    }

    public MediumState getState()
    {
        return state;
    }

    public void setState(MediumState state)
    {
        this.state = state;
    }

}
