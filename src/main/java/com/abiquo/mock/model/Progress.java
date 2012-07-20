package com.abiquo.mock.model;

import java.util.UUID;

public class Progress
{
    private String description;

    private String id;

    private long progress;

    public Progress()
    {
        id = UUID.randomUUID().toString();
        progress = Long.valueOf(100);
    }

    public String getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public long getProgress()
    {
        return progress;
    }

    public void setProgress(long progress)
    {
        this.progress = progress;
    }

    public boolean isCompleted()
    {
        return progress == Long.valueOf(100);
    }
}
