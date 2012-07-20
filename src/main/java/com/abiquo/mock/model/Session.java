package com.abiquo.mock.model;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.virtualbox.SessionState;
import org.virtualbox.SessionType;

public class Session
{
    private String id;


    private SessionState state; private SessionType type;   private Set<Object> data;

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

    public void setId(String id)
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

    public void setState(SessionState state)
    {
        this.state = state;
    }

    public SessionType getType()
    {
        return type;
    }

    public void setType(SessionType type)
    {
        this.type = type;
    }

}
