package cz.cvut.czm.upf.core.events.keyboard;
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

public class KeyboardEvent extends InputEvent {


    public KeyboardEvent(InputDevice device) {
        super(device);
    }
}
