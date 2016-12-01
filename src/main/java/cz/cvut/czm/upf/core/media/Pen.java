package cz.cvut.czm.upf.core.media;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class Pen {

    public Pen(Brush brush)
    {
        this(brush,1f);
    }
    public Pen(Brush brush, float thickness)
    {
        this.brush=brush;
        this.thickness=thickness;
    }

    public float thickness;
    public Brush brush;
}
