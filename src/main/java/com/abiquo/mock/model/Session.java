package com.abiquo.mock.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.virtualbox.SessionState;
import org.virtualbox.SessionType;

public class Session
{
    private String id;

    private SessionState state;

    private SessionType type;

    /** Console is the object trhough all vm operations are performed */
    private VirtualMachineInfo virtualMachine;

    private Set<Object> data;

    public Session()
    {
        id = UUID.randomUUID().toString();
        state = SessionState.UNLOCKED;
        type = SessionType.NULL;
    }

    public String getId()
    {
        return id;
    }

    public void setId(final String id)
    {
        this.id = id;
    }

    public Set<Object> getData()
    {
        if (data == null)
        {
            data = new HashSet<Object>();
        }
        return data;
    }

    public SessionState getState()
    {
        return state;
    }

    public void setState(final SessionState state)
    {
        this.state = state;
    }

    public SessionType getType()
    {
        return type;
    }

    public void setType(final SessionType type)
    {
        this.type = type;
    }

    public String getConsole()
    {
        return virtualMachine != null ? virtualMachine.getId() : null;
    }

    public VirtualMachineInfo getVirtualMachine()
    {
        return virtualMachine;
    }

    public void setVirtualMachine(final VirtualMachineInfo virtualMachine)
    {
        this.virtualMachine = virtualMachine;
    }

}
