package cz.cvut.czm.upf.util.time;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.util.FluentObject;

import java.sql.Timestamp;

public class TimeSpan<T extends TimeSpan> extends FluentObject<T> {
    protected long ticks=0;

    //region Constants
    public static final long TICKS_PER_MILISECOND = 10_000l;
    public static final long TICKS_PER_SECOND = 10_000_000l;
    public static final long TICKS_PER_MINUTE = 600_000_000l;
    public static final long TICKS_PER_HOUR = 36_000_000_000l;
    public static final long TICKS_PER_DAY = 864_000_000_000l;
    public static final TimeSpan maxValue()
    {
        return new TimeSpan(Long.MAX_VALUE);
    }
    public static final TimeSpan minValue()
    {
        return new TimeSpan(Long.MIN_VALUE);
    }
    public static final TimeSpan zero()
    {
        return new TimeSpan(0l);
    }
    //endregion

    //region Constructors

    public TimeSpan(int hours,int minutes,int seconds)
    {
        this.ticks+=hours*TICKS_PER_HOUR + minutes*TICKS_PER_MINUTE + seconds*TICKS_PER_SECOND;
    }
    public TimeSpan(int days,int hours,int minutes,int seconds)
    {
        this(hours,minutes,seconds);
        this.ticks+=days*TICKS_PER_DAY;
    }
    public TimeSpan(int days,int hours,int minutes,int seconds,int miliseconds)
    {
        this(days,hours,minutes,seconds);
        this.ticks+=miliseconds*TICKS_PER_MILISECOND;
    }
    public TimeSpan(long ticks)
    {
        this.ticks=ticks;
    }
    //endregion

    //region Getters
    public int getDays()
    {
        return (int)(ticks / TICKS_PER_DAY);
    }
    public float getTotalDays()
    {
        return ((float)ticks)/TICKS_PER_DAY;
    }
    public int getHours()
    {
        return (int)((ticks%TICKS_PER_DAY)/TICKS_PER_HOUR);
    }
    public float getTotalHours()
    {
        return ((float)ticks)/TICKS_PER_HOUR;
    }
    public int getMinutes()
    {
        return (int)((ticks%TICKS_PER_HOUR)/TICKS_PER_MINUTE);
    }
    public float getTotalMinutes()
    {
        return ((float)ticks)/TICKS_PER_MINUTE;
    }
    public int getSeconds()
    {
        return (int)((ticks%TICKS_PER_MINUTE)/TICKS_PER_SECOND);
    }
    public float getTotalSeconds()
    {
        return ((float)ticks)/TICKS_PER_SECOND;
    }
    public int getMiliSeconds()
    {
        return (int)((ticks%TICKS_PER_SECOND)/TICKS_PER_MILISECOND);
    }
    public float getTotalMiliSeconds()
    {
        return ((float)ticks)/TICKS_PER_MILISECOND;
    }
    public long getTicks()
    {
        return ticks;
    }
    //endregion

    //region Operations
    public T add(TimeSpan timeSpan)
    {
        this.ticks+=timeSpan.ticks;
        return getThis();
    }
    public T subtract(TimeSpan timeSpan)
    {
        this.ticks-=timeSpan.ticks;
        return getThis();
    }
    public T negate()
    {
        this.ticks=-this.ticks;
        return getThis();
    }
    public T duration()
    {
        return this.ticks<0?negate():getThis();
    }

    public boolean greaterThan(TimeSpan b)
    {
        return this.ticks>b.ticks;
    }
    public boolean greaterThanOrEqual(TimeSpan b)
    {
        return this.ticks>=b.ticks;
    }
    public boolean lessThan(TimeSpan b)
    {
        return this.ticks<b.ticks;
    }
    public boolean lessThanOrEqual(TimeSpan b)
    {
        return this.ticks<=b.ticks;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TimeSpan)
            return this.ticks==((TimeSpan)obj).ticks;
        return super.equals(obj);
    }
    //endregion

    //region Static operations
    public static int compare(TimeSpan a, TimeSpan b)
    {
        return a.ticks==b.ticks?0:a.ticks<b.ticks?-1:1;
    }
    public static boolean equals(TimeSpan a,TimeSpan b)
    {
        return a.ticks==b.ticks;
    }
    //endregion
}
