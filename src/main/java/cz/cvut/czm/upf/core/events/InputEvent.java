package cz.cvut.czm.upf.core.events;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.io.InputDevice;

import java.util.Date;

public class InputEvent extends Event {
    public final InputDevice device;
    public final Date timestamp;

    public InputEvent(InputDevice device)
    {
        this.device=device;
        timestamp=new Date();
    }
}
