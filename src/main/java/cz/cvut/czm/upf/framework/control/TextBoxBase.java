package cz.cvut.czm.upf.framework.control;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.media.Brush;
import cz.cvut.czm.upf.core.media.Colors;
import cz.cvut.czm.upf.core.media.SolidColorBrush;

public class TextBoxBase<T extends TextBoxBase> extends Control<T> {

    public volatile Brush borderBrush = new SolidColorBrush(Colors.lightSkyBlue());

    public TextBoxBase()
    {
    }

}
