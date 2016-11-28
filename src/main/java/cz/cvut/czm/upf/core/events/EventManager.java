package cz.cvut.czm.upf.core.events;
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

public class EventManager<E extends Event> {

    protected List<EventListener<E>> listeners;

    public EventManager add(EventListener<E> listener)
    {
        if(listeners==null)
            listeners=new ArrayList<>(); // Memory optimalization = Lazy loading
        listeners.add(listener);
        return this;
    }
    public EventManager remove(EventListener<E> listener)
    {
        if(listeners==null)
            return this; // Memory optimalization = Lazy loading
        listeners.remove(listener);
        return this;
    }

    public EventManager invoke(E event)
    {
        if(listeners==null)
            return this; // Memory optimalization = Lazy loading
        listeners.stream().forEach(l->l.invoke(event));
        return this;
    }

    public EventManager removeAll()
    {
        if(listeners==null)
            return this; // Memory optimalization = Lazy loading
        listeners.clear();
        return this;
    }
}
