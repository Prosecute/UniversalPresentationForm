package cz.cvut.czm.upf.util;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class FluentObject<T extends FluentObject> extends Object {

    public FluentObject()
    {

    }
    public FluentObject(T objectToCopy)
    {

    }

    public T getThis()
    {
        return (T)this;
    }

}
