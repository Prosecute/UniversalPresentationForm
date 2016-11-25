package cz.cvut.czm.upf.core.media.transforms;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.media.Point;
import cz.cvut.czm.upf.core.media.Rect;
import cz.cvut.czm.upf.core.media.Vector;

public class TranslateTransform<T extends TranslateTransform> extends Transform<T> {

    public Vector vector;

    public  TranslateTransform(float x,float y)
    {
        this(new Vector(x,y));
    }
    public TranslateTransform()
    {
        this(new Vector());
    }
    public TranslateTransform(Vector vector)
    {
        this.vector=vector;
    }

    public T transform(Point point) {
        vector.apply(point);
        return getThis();
    }

    public T transformBounds(Rect rect) {
        vector.apply(rect);
        return getThis();
    }

    public T inverse() {
        vector.inverse();
        return getThis();
    }
    public T getInversed()
    {
        return (T)new TranslateTransform(vector.getInversed());
    }
}
