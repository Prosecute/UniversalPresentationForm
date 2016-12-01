package cz.cvut.czm.upf.framework.control.content;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.UIElement;
import cz.cvut.czm.upf.core.media.Vector;
import cz.cvut.czm.upf.framework.control.Control;

public class ContentControl<T extends ContentControl> extends Control<T> {


    //region Content
    private UIElement content;

    public T setContent(UIElement content)
    {
        this.content=content;
        return getThis();
    }
    public UIElement getContent()
    {
        return this.content;
    }

    //endregion

    //region Sizing

    @Override
    protected void measureOverwrite(Vector availableSize) {
        if(content==null)
        {

        }
        content.measurePass(availableSize);
        measuredSize=content.getMeasuredSize();
    }

    @Override
    protected Vector arrangeOverwrite(Vector finalSize) {
        return super.arrangeOverwrite(finalSize);
    }
    //endregion

}
