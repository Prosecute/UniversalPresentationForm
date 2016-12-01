package cz.cvut.czm.upf.core.media;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class SolidColorBrush extends Brush {
    public Color color;

    public SolidColorBrush()
    {
        this(Colors.white());
    }
    public SolidColorBrush(Color color)
    {
        this.color=color;
    }

    @Override
    public String type() {
        return "solidColor";
    }
}
