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
import cz.cvut.czm.upf.core.media.*;
import cz.cvut.czm.upf.core.media.Vector;

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


    //region Sizing

    public volatile Float width,height,maxwidth,minwidth,maxheight,minheight;
    public volatile Margin margin;

    @Override
    protected final void measure(Vector availableSize) {
        float x=availableSize.x;
        float y=availableSize.y;
        if(margin==null) {}
        if(margin.left!=null && margin.right!=null)
            x = x - margin.left - margin.right;
        else if(margin.left==null && margin.right==null)
            x = maxwidth!=null && x>maxwidth?maxwidth:( minwidth!=null && x<minwidth)?minwidth:(width!=null)?width:x;
        else if(margin.left!=null){}

    }

    @Override
    protected final void arrange(Rect desiredLocation) {

    }
    protected Vector arrangeOverwrite(Vector finalSize) { return finalSize;}
    protected void measureOverwrite(Vector availableSize) {}
    //endregion

}
