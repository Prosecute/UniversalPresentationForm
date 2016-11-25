package cz.cvut.czm.upf.core.threading;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import java.util.ArrayList;
import java.util.List;

public final class Dispatcher {

    public final Thread thread;

    private Dispatcher()
    {
        this.thread=Thread.currentThread();
    }




    private final static List<Dispatcher> dispatchers = new ArrayList<Dispatcher>();
    private final static Object DISPATCHER_LOCK = new Object();
    public static Dispatcher CurrentDispatcher()
    {
        Thread currentThread = Thread.currentThread();
        return FromThread(currentThread);
    }
    public static Dispatcher FromThread(Thread thread)
    {
        synchronized (DISPATCHER_LOCK) {
        for(Dispatcher dispatcher:dispatchers)
            if(dispatcher.thread.equals(thread))
                return dispatcher;
            Dispatcher dispatcher;
            dispatcher = new Dispatcher();
            dispatchers.add(dispatcher);
            return dispatcher;
        }
    }
}
