package cz.cvut.czm.upf.presentation;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.UIElement;
import cz.cvut.czm.upf.core.dependency.DependencyObject;

import java.util.*;

public class PresentationElement<T extends PresentationElement> extends UIElement<T> {

    private volatile DependencyObject parent;

    public T setParent(DependencyObject parent)
    {
        this.parent=parent;
        return getThis();
    }
    public DependencyObject getParent()
    {
        return parent;
    }

}
