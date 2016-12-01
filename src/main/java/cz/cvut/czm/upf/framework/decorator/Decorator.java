package cz.cvut.czm.upf.framework.decorator;
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
import cz.cvut.czm.upf.framework.FrameworkElement;

public class Decorator<T extends Decorator> extends FrameworkElement<T> {

    public volatile UIElement child;

}
