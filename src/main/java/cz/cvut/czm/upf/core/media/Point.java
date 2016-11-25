package cz.cvut.czm.upf.core.media;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class Point {
    public float x,y;

    public Point()
    {
        this(0,0);
    }
    public Point(float x,float y)
    {
        this.x=x;
        this.y=y;
    }

    public static boolean compare(Point A, Point B)
    {
        return A.x==B.x && A.y==B.y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass()))
            return compare(this,(Point)obj);
        return super.equals(obj);
    }
}
