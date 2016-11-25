package cz.cvut.czm.upf.layouts;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.FrameworkElement;
import cz.cvut.czm.upf.core.UIElement;
import cz.cvut.czm.upf.core.UIElementList;

public abstract class Panel<T extends Panel> extends FrameworkElement<T> {
    private final UIElementList list;

    public Panel()
    {
        list=new UIElementList(this);
    }

    public T addChild(UIElement element)
    {
        list.add(element);
        return getThis();
    }
}
