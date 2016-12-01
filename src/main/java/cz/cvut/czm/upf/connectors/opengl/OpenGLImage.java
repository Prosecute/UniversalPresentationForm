package cz.cvut.czm.upf.connectors.opengl;
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

import java.nio.FloatBuffer;

public class OpenGLImage extends Image {

    public final OpenGLDrawingContext dc;
    public final FloatBuffer buffer;

    protected OpenGLImage(OpenGLDrawingContext dc,int width,int height)
    {
        this.dc=dc;
        this.buffer=FloatBuffer.allocate(4*width*height);
    }


    @Override
    public DrawingContext getDrawingContext() {
        return dc;
    }
}
