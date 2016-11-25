package cz.cvut.czm.upf.core.events.mouse;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.io.InputDevice;
import cz.cvut.czm.upf.core.io.MouseDevice;

public class MouseButtonEvent extends MouseEvent {

    public final int clickCount;
    public final MouseDevice.MouseButtonType changedButton;
    public final MouseDevice.MouseButtonState buttonState;

    public MouseButtonEvent(MouseDevice device, int clickCount, MouseDevice.MouseButtonType button)
    {
        super(device);
        this.clickCount=clickCount;
        this.changedButton=button;
        this.buttonState=device.button(button);
    }

}
