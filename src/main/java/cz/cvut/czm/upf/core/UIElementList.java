package cz.cvut.czm.upf.core;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.layouts.Panel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UIElementList extends ArrayList<UIElement> {
    UIElement parent;

    public UIElementList(UIElement parent)
    {
        this.parent=parent;
    }

    @Override
    public boolean addAll(int index, Collection<? extends UIElement> c) {
        if(c.stream().anyMatch(e->e.getVisualParrent()!=null))
            throw new UIElementAlreadyAddedException();
        c.stream().forEach(e->{e.setVisualParrent(parent);});
        return super.addAll(index, c);
    }

    @Override
    public boolean addAll(Collection<? extends UIElement> c) {
        if(c.stream().anyMatch(e->e.getVisualParrent()!=null))
            throw new UIElementAlreadyAddedException();
        c.stream().forEach(e->{e.setVisualParrent(parent);});
        return super.addAll(c);
    }

    @Override
    public boolean add(UIElement element) {
        if(element.getVisualParrent()!=null)
            throw new UIElementAlreadyAddedException();
        element.setVisualParrent(parent);
        return super.add(element);
    }

    @Override
    public void add(int index, UIElement element) {
        if(element.getVisualParrent()!=null)
            throw new UIElementAlreadyAddedException();
        element.setVisualParrent(parent);
        super.add(index, element);
    }
}
