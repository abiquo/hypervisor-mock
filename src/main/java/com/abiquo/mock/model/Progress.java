package com.abiquo.mock.model;

import java.util.Calendar;
import java.util.UUID;

public class Progress
{
    private String description;

    private String id;

    private long progress;

    private long delay;

    private long creation;

    public Progress()
    {
        id = UUID.randomUUID().toString();
        progress = Long.valueOf(100);
    }

    public Progress(final long delay)
    {
        id = UUID.randomUUID().toString();
        this.delay = delay;
        if (delay <= 0)
        {
            progress = Long.valueOf(100);
        }
        this.creation = Calendar.getInstance().getTimeInMillis();
    }

    public String getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public long getProgress()
    {
        if (delay > 0)
        {
            calculateProgrees();
        }
        return progress;
    }

    private void calculateProgrees()
    {
        progress =
            (Calendar.getInstance().getTimeInMillis() - creation) * Long.valueOf(100) / delay;
        progress = progress > Long.valueOf(100) ? Long.valueOf(100) : progress;
    }

    public void setProgress(final long progress)
    {
        this.progress = progress;
    }

    public boolean isCompleted()
    {
        return progress == Long.valueOf(100);
    }
}
