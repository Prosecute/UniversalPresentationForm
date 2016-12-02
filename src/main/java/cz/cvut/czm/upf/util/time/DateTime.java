package cz.cvut.czm.upf.util.time;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class DateTime {

    private long data;

    //region Constructors
    public DateTime()
    {

    }
    public DateTime(int year,int month,int day)
    {

    }
    public DateTime(int year,int month,int day,int hour,int minute,int second)
    {

    }
    //endregion
    //region Static operations
    public static DateTime now()
    {
        return new DateTime();
    }
    //endregion
}
