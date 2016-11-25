package cz.cvut.czm.upf.core.media.transforms;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.FluentObject;
import cz.cvut.czm.upf.core.media.Point;
import cz.cvut.czm.upf.core.media.Rect;

public abstract class Transform<T extends Transform>  extends FluentObject<T>{



    public abstract T transform(Point point);
    public abstract T transformBounds(Rect rect);

    public abstract T inverse();
    public abstract T getInversed();


}
