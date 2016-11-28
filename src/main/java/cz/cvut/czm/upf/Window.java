package cz.cvut.czm.upf;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.connectors.awt.AwtWindow;
import cz.cvut.czm.upf.presentation.PresentationElement;
import cz.cvut.czm.upf.presentation.control.content.ContentControl;


public abstract class Window<T extends Window> extends ContentControl<T> {



    public static Window createAwtWindow()
    {
        return new AwtWindow();
    }

    public abstract T setTitle(String title);
    public abstract String getTitle();
}
