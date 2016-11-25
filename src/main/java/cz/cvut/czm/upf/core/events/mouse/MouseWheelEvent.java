package cz.cvut.czm.upf.core.events.mouse;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.io.MouseDevice;

public class MouseWheelEvent extends MouseEvent {

    public float delta;

    public MouseWheelEvent(MouseDevice device, float delta)
    {
        super(device);
        this.delta=delta;
    }

}
