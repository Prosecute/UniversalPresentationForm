package cz.cvut.czm.upf.connectors.awt;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.*;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.ImageObserver;
import java.awt.image.VolatileImage;

public class AwtFrameConnector extends Frame {


    public class ComponentConnector extends Component
    {
        AwtDrawingContext context;
        public ComponentConnector()
        {
            AwtImage image=new AwtImage(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleVolatileImage(getWidth(),getHeight()));
            context = new AwtDrawingContext(image);
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    context.image.img = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleVolatileImage(getWidth(),getHeight());

                }
            });
        }



        @Override
        public void paint(Graphics g) {
            Image img=context.image.img;
            DummyImgObs obs=new DummyImgObs();
            g.drawImage(img,0,0,getWidth(),getHeight(),0,0,img.getWidth(obs),img.getHeight(obs),obs);
        }

        private class DummyImgObs implements ImageObserver
        {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
                return false;
            }
        }
    }
}
