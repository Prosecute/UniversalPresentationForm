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
import cz.cvut.czm.upf.core.events.keyboard.KeyEvent;
import cz.cvut.czm.upf.core.events.mouse.MouseButtonEvent;
import cz.cvut.czm.upf.core.events.mouse.MouseEvent;
import cz.cvut.czm.upf.core.events.mouse.MouseWheelEvent;
import cz.cvut.czm.upf.core.geometry.Geometry;
import cz.cvut.czm.upf.core.media.Color;
import cz.cvut.czm.upf.core.media.Rect;
import cz.cvut.czm.upf.core.media.Vector;

public class UIElement<T extends UIElement> extends Visual<T> {


    //region Constructors
    public UIElement(){}
    public UIElement(UIElement objectTocopy)
    {
        super(objectTocopy);
        this.KeyUp=objectTocopy.KeyUp;
        this.KeyUpPreview=objectTocopy.KeyUpPreview;
        //TODO:
    }
    //endregion

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


    //region Sizing
    protected Geometry clip;
    public T setClip(Geometry clip) {this.clip=clip; return getThis();}
    public Geometry getClip() {return this.clip;}

    protected Vector measuredSize;

    public Vector getMeasuredSize()
    {
        return measuredSize;
    }

    protected Rect bounds;
    public final void measure(Vector availibleSize)
    {
        if(!visible)
            measuredSize=new Vector();
        else if(clip==null)
            measuredSize=Vector.createSmallestByAxis(clip.getBounds().getSize(),availibleSize);
        else
            measuredSize=availibleSize;
        measurePass(availibleSize);
    }
    protected void measurePass(Vector availibleSize) {}

    public final void arrange(Rect desiredLocation)
    {
        arrangePass(bounds);
    }
    protected void arrangePass(Rect desiredLocation) {}
    //endregion

    //region Visibility
    protected boolean visible = true;
    protected Color bgColor = null;
    public T setVisible(boolean visibility)
    {
        this.visible=visibility;
        return getThis();
    }
    public boolean isVisible()
    {
        return visible;
    }

    public T setBackgroundColor(Color color)
    {
        this.bgColor=color;
        return getThis();
    }
    public Color getBackgroundColor()
    {
        return this.bgColor;
    }

    //endregion

}
