package cz.cvut.czm.upf.core.media;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.events.EventListener;
import cz.cvut.czm.upf.core.events.EventManager;

import java.util.ArrayList;
import java.util.List;

public interface RenderJob {

    public void render(DrawingContext dc);


    public static class RenderJobManager
    {

        protected List<RenderJob> listeners;

        public RenderJobManager add(RenderJob job)
        {
            if(listeners==null)
                listeners=new ArrayList<>(); // Memory optimalization = Lazy loading
            listeners.add(job);
            return this;
        }
        public RenderJobManager remove(RenderJob listener)
        {
            if(listeners==null)
                return this; // Memory optimalization = Lazy loading
            listeners.remove(listener);
            return this;
        }

        public RenderJobManager render(DrawingContext dc)
        {
            if(listeners==null)
                return this; // Memory optimalization = Lazy loading
            listeners.stream().forEach(l->l.render(dc));
            return this;
        }

        public RenderJobManager removeAll()
        {
            if(listeners==null)
                return this; // Memory optimalization = Lazy loading
            listeners.clear();
            return this;
        }
    }
}
