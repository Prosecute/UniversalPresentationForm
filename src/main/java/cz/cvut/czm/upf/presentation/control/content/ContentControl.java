package cz.cvut.czm.upf.presentation.control.content;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.media.Rect;
import cz.cvut.czm.upf.core.media.Vector;
import cz.cvut.czm.upf.presentation.control.Control;

public class ContentControl<T extends ContentControl> extends Control<T> {


    //region Content
    private Object content;
    private ContentPresenter presenter;

    public T setContent(Object content)
    {
        this.content=content;
        return getThis();
    }
    public Object getContent()
    {
        return this.content;
    }

    //endregion

    //region Sizing

    @Override
    protected void measureOverwrite(Vector availableSize) {
        if(presenter==null)
        {

        }
        presenter.measurePass(availableSize);
        measuredSize=presenter.getMeasuredSize();
    }

    @Override
    protected Vector arrangeOverwrite(Vector finalSize) {
        return super.arrangeOverwrite(finalSize);
    }
    //endregion

}
