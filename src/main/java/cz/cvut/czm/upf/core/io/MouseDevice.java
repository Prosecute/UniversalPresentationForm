package cz.cvut.czm.upf.core.io;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class MouseDevice extends InputDevice {

    private volatile MouseButtonState left=null,middle=null,right=null;

    public MouseDevice.MouseButtonState leftButton()
    {
        return left;
    }
    public MouseDevice.MouseButtonState middleButton()
    {
        return left;
    }
    public MouseDevice.MouseButtonState rightButton()
    {
        return left;
    }

    public MouseButtonState button(MouseButtonType button) {
        switch (button)
        {
            case Middle: return middleButton();
            case Right: return rightButton();
            default: return leftButton();
        }
    }

    public enum MouseButtonState { Pressed,Released }
    public enum MouseButtonType {Left,Middle,Right}
}
