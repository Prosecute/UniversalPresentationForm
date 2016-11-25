package cz.cvut.czm.upf.core.media;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class Rect {
    public float x,y,width,height;

    public Rect(float x, float y, float width,float height)
    {
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
    }
    public Rect(Point A, Point B)
    {
        if(A.x<B.x)
        {
            this.x=A.x;
            this.width=B.x-A.x;
        }
        else
        {
            this.x=B.x;
            this.width=A.x-B.x;
        }
        if(A.y<B.y)
        {
            this.y=A.y;
            this.height=B.y-A.y;
        }
        else
        {
            this.y=B.y;
            this.height=A.y-B.y;
        }
    }
    public Rect(Point point, Vector size)
    {
        this.x=point.x;
        this.y=point.y;
        this.width=size.x;
        this.height=size.y;
    }

    public static Rect zero()
    {
        return new Rect(0,0,0,0);
    }

    public float top()
    {
        return y;
    }
    public float bottom()
    {
        return y+height;
    }
    public float left()
    {
        return x;
    }
    public float right()
    {
        return x+width;
    }
    public Point topLeft()
    {
        return new Point(x,y);
    }
    public Point topRight()
    {
        return new Point(x+width,y);
    }
    public Point bottomLeft()
    {
        return new Point(x,y+height);
    }
    public Point bottomRight()
    {
        return new Point(x+width,y+height);
    }
    public Vector getSize()
    {
        return new Vector(width,height);
    }

}
