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
import cz.cvut.czm.upf.core.media.Point;
import cz.cvut.czm.upf.core.media.transforms.Transform;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Visual<T extends Visual> extends DependencyObject<T> {

    private Visual visualParrent;
    private List<Visual> childs=new ArrayList<Visual>();

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
        return childs.get(index);
    }
    protected int getVisualChildCount()
    {
        return childs.size();
    }
    protected T addVisualChild(Visual visual)
    {
        if(!childs.contains(visual))
            childs.add(visual);
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
}
