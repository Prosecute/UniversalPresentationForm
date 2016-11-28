package cz.cvut.czm.upf.core;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.events.Event;
import cz.cvut.czm.upf.core.events.EventListener;
import cz.cvut.czm.upf.core.events.EventManager;
import cz.cvut.czm.upf.core.events.keyboard.KeyEvent;
import cz.cvut.czm.upf.core.events.mouse.MouseButtonEvent;
import cz.cvut.czm.upf.core.events.mouse.MouseEvent;
import cz.cvut.czm.upf.core.events.mouse.MouseWheelEvent;
import cz.cvut.czm.upf.core.media.DrawingContext;

import java.util.Collections;
import java.util.Enumeration;

public class UIElement<T extends UIElement> extends Visual<T> {

    //region Events
    public EventListener<KeyEvent> KeyUp, KeyUpPreview;
    public EventListener<KeyEvent> KeyDown, KeyDownPreview;

    public EventListener<MouseButtonEvent> MouseDown, MouseDownPreview;
    public EventListener<MouseButtonEvent> MouseUp, MouseUpPreview;
    public EventListener<MouseEvent> MouseEnter;
    public EventListener<MouseEvent> MouseLeave;
    public EventListener<MouseEvent> MouseMove, PreviewMouseMove;
    public EventListener<MouseButtonEvent> MouseLeftButtonDown, PreviewMouseLeftButtonDown;
    public EventListener<MouseButtonEvent> MouseLeftButtonUp, PreviewMouseLeftButtonUp;
    public EventListener<MouseWheelEvent> MouseWheel, PreviewMouseWheel;

    public EventListener<Event> FocusLost;
    public EventListener<Event> FocusGain;
    //endregion

    public T addChild()
    {
        return getThis();
    }
    public T removeChild()
    {
        return getThis();
    }
    public Enumeration<UIElement> childs()
    {
        return Collections.emptyEnumeration();
    }


    protected boolean visible = true;
    public T setVisible(boolean visibility)
    {
        this.visible=visibility;
        return getThis();
    }
    public boolean isVisible()
    {
        return visible;
    }

}
