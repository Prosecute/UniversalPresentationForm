package cz.cvut.czm.upf.core;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class FluentObject<T extends FluentObject> extends Object {

    public T getThis()
    {
        return (T)this;
    }
}
