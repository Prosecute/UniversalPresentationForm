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
import cz.cvut.czm.upf.core.Visual;

public abstract class DispatcherObject<T extends DispatcherObject> extends FluentObject<T> {
    public final Dispatcher dispatcher;

    //region Constructors
    public DispatcherObject(DispatcherObject objectTocopy)
    {
        super((T)objectTocopy);
        dispatcher = Dispatcher.CurrentDispatcher();
    }
    protected DispatcherObject()
    {
        dispatcher = Dispatcher.CurrentDispatcher();
    }
    //endregion

    public boolean CheckAccess()
    {
        return Thread.currentThread().equals(dispatcher.thread);
    }
    public T VerifyAccess()
    {
        if(!CheckAccess())
            throw new InvalidOperationException();
        return getThis();
    }
}
