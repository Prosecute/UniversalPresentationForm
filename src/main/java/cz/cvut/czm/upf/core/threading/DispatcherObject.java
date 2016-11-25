package cz.cvut.czm.upf.core.threading;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.FluentObject;

public abstract class DispatcherObject<T extends DispatcherObject> extends FluentObject<T> {
    public final Dispatcher dispatcher;

    protected DispatcherObject()
    {
        dispatcher = Dispatcher.CurrentDispatcher();
    }

    public boolean CheckAccess()
    {
        return Thread.currentThread().equals(dispatcher.thread);
    }
    public T VerifyAccess()
    {
        if(!CheckAccess())
            throw new InvalidOperationException();
        return GetThis();
    }
}
