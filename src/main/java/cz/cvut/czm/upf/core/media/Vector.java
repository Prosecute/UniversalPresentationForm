package cz.cvut.czm.upf.core.media;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.FluentObject;

public class Vector<T extends Vector> extends FluentObject<T> {
    public volatile float x,y;

    public Vector()
    {

    }
    public Vector(float x,float y)
    {
        this.x=x;
        this.y=y;
    }

    public T add(Vector B)
    {
        this.x+=B.x;
        this.y+=B.y;
        return getThis();
    }
    public T copy()
    {
        return (T)new Vector(this.x,this.y);
    }

    public T apply(Point A)
    {
        A.x+=this.x;
        A.y+=this.y;
        return getThis();
    }
    public T apply(Rect rect)
    {
        rect.x+=this.x;
        rect.y+=this.y;
        return getThis();
    }

    public T inverse()
    {
        this.x=-this.x;
        this.y=-this.y;
        return getThis();
    }
    public T getInversed()
    {
        return (T)new Vector(-this.x,-this.y);
    }

    public static Vector createSmallestByAxis(Vector... vectors)
    {
        float w,h;
        for(Vector vector:vectors)
        {
            w=w<vector.x?w:vector.x;
            h=h<vector.y?h:vector.y;
        }
        return new Vector(w,h);
    }

    public boolean compare(Vector B)
    {
        return compare(this,B);
    }
    public static boolean compare(Vector A, Vector B)
    {
        return A.x==B.x && A.y==B.y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass()))
            return compare(this,(Vector)obj);
        return super.equals(obj);
    }
}
