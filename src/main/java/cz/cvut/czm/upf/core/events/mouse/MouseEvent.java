package cz.cvut.czm.upf.core.events.mouse;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.events.InputEvent;
import cz.cvut.czm.upf.core.io.InputDevice;
import cz.cvut.czm.upf.core.io.MouseDevice;

public class MouseEvent extends InputEvent {

    public MouseDevice.MouseButtonState left=null,middle=null,right=null;


    public MouseEvent(InputDevice device)
    {
        super(device);
    }

    public MouseDevice getMouseDevice()
    {
        return (MouseDevice)device;
    }




}
