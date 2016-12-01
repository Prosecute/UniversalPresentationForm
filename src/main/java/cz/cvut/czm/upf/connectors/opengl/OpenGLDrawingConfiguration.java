package cz.cvut.czm.upf.connectors.opengl;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.media.DrawingConfiguration;
import cz.cvut.czm.upf.core.media.Image;

public class OpenGLDrawingConfiguration extends DrawingConfiguration {

    protected final OpenGLDrawingContext dc;

    public OpenGLDrawingConfiguration(OpenGLDrawingContext dc)
    {
        this.dc=dc;
    }

    @Override
    public Image createImage(int width, int height, String... params) {
        return new OpenGLImage(dc,width,height);
    }
}
