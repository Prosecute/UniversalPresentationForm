package cz.cvut.czm.upf.presentation.layouts;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.presentation.PresentationElement;
import cz.cvut.czm.upf.core.UIElement;
import cz.cvut.czm.upf.core.UIElementList;

public abstract class Panel<T extends Panel> extends PresentationElement<T> {
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
