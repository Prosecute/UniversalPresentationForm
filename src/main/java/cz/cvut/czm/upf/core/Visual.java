package cz.cvut.czm.upf.core;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.dependency.DependencyObject;
import cz.cvut.czm.upf.core.media.*;
import cz.cvut.czm.upf.core.media.transforms.Transform;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Visual<T extends Visual> extends DependencyObject<T> {

    //region Constructors
    public Visual(){}
    public Visual(Visual objectTocopy)
    {
        super(objectTocopy);
        for(Object visual:objectTocopy.visualChilds)
            try {
                visualChilds.add((Visual) visual.getClass().getConstructor(visual.getClass()).newInstance(visual));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
    }
    //endregion

    private Visual visualParrent;
    private List<Visual> visualChilds=new ArrayList<Visual>();
    private Image buffer;
    private Rect renderRect;

    protected Visual getVisualParrent()
    {
        return visualParrent;
    }
    protected T setVisualParrent(Visual visual)
    {
        this.visualParrent=visual;
        visual.addVisualChild(this);
        return getThis();
    }
    Visual getVisualChild(int index)
    {
        return visualChilds.get(index);
    }
    protected int getVisualChildCount()
    {
        return visualChilds.size();
    }
    protected T addVisualChild(Visual visual)
    {
        if(!visualChilds.contains(visual))
            visualChilds.add(visual);
        return getThis();
    }

    public Transform transformToVisual(Visual visual)
    {
        Transform transform= transformToDescendant(visual);
        if(transform==null)
            transform=transformToAncestor(visual);
        return transform;
    }
    public Transform transformToDescendant(Visual visual)
    {
        return null;
    }
    public Transform transformToAncestor(Visual visual)
    {
        return null;
    }

    public Point pointFromScreen(Point point)
    {
        return null;
    }

    public Point pointToScreen(Point point)
    {
        return null;
    }


    public RenderJob.RenderJobManager renderer = new RenderJob.RenderJobManager();

    public final void render(DrawingContext dc)
    {
        if(buffer==null)
            buffer=dc.GetConfiguration().createImage((int)renderRect.width,(int)renderRect.height);
        renderer.render(buffer.getDrawingContext());
        dc.DrawImage(null,buffer,renderRect);
        for(Visual visual:visualChilds)
            visual.render(dc);
    }
    public Rect getRenderRect() {
        return renderRect;
    }

}
