package cz.cvut.czm.upf.connectors.awt;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.Window;
import cz.cvut.czm.upf.core.UIElement;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtWindow<T extends AwtWindow> extends Window<T> {
    protected AwtFrameConnector awt;

    public AwtWindow()
    {
        awt =new AwtFrameConnector();
        awt.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                awt.dispose();
                System.exit(0);
            }
        });
        awt.setSize(300,300);
        Dimension dim=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        awt.setLocation(dim.width/2-150,dim.height/2-150);
    }

    @Override
    public T setVisible(boolean visibility) {
        awt.setVisible(visibility);
        return super.setVisible(visibility);
    }

    @Override
    public T setTitle(String title) {
        awt.setTitle(title);
        return getThis();
    }

    @Override
    public String getTitle() {
        return awt.getTitle();
    }
}
