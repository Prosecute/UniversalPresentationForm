package cz.cvut.czm.upf.connectors.awt;
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

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AwtDrawingConfiguration extends DrawingConfiguration {

    GraphicsConfiguration configuration;
    public AwtDrawingConfiguration()
    {
        configuration=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    public static AwtDrawingConfiguration getDefault()
    {
        return new AwtDrawingConfiguration();
    }

    @Override
    public Image createImage(int width, int height, String... params) {
        List<String> param= Arrays.asList(params);
        if(param.contains("volatile"))
            return new AwtImage(configuration.createCompatibleVolatileImage(width,height));
        else
            return new AwtImage(configuration.createCompatibleImage(width,height));

    }
}
