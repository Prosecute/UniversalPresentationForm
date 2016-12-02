package cz.cvut.czm.upf.core.timeline;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.util.time.TimeSpan;

public class Duration {

    private DurationType type;
    private TimeSpan duration;

    public Duration()
    {
        type=DurationType.automatic;
    }
    public Duration(TimeSpan timeSpan)
    {
        type=DurationType.value;
        duration=timeSpan;
    }
    public Duration(boolean forever)
    {
        type=forever?DurationType.forever:DurationType.automatic;
    }

    private enum DurationType { value, automatic, forever}
}
