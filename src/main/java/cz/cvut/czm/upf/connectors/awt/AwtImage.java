package cz.cvut.czm.upf.connectors.awt;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.media.DrawingContext;
import cz.cvut.czm.upf.core.media.Image;

import java.awt.image.VolatileImage;

public class AwtImage extends Image{

    protected java.awt.Image img;

    @Override
    public DrawingContext getDrawingContext() {
        return new AwtDrawingContext(this);
    }

    public AwtImage(java.awt.Image image)
    {
        this.img=image;
    }
}
