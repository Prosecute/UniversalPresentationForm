package cz.cvut.czm.upf.core.timeline;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.Animatable;
import cz.cvut.czm.upf.util.time.TimeSpan;


public class TimeLine<T extends TimeLine> extends Animatable<T> {

    public volatile boolean autoReverse = false;
    public volatile TimeSpan beginTime;
    public volatile float accelerationRatio, decelerationRatio, speedRatio;
    public volatile Duration duration = new Duration(true);
    public volatile FillBehavior fillBehavior = FillBehavior.HoldEnd;
    public volatile String name;


    public enum FillBehavior { HoldEnd, Stop}
}
