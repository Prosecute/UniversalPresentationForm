package cz.cvut.czm.upf.core.media;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


public class Color {
    private int color;

    public Color(int r,int g,int b)
    {
        this.color=toIntColor(r,g,b);
    }
    public Color(int r,int g,int b,int a)
    {
        this.color=toIntColor(r,g,b,a);
    }
    public Color(String hex)
    {

    }
    public Color(int rgba)
    {
        this.color=rgba;
    }

    public Color copy()
    {
        return new Color(this.color);
    }

    public int red()
    {
        return color >> 24 & 0xFF;
    }
    public int green()
    {
        return color >> 16 & 0xFF;
    }
    public int blue()
    {
        return color >> 8 & 0xFF;
    }
    public int alpha()
    {
        return color & 0xFF;
    }
    public Color set(int r,int g,int b,int a)
    {
        return this;
    }
    public Color set(int r,int g,int b)
    {
        return set(r,g,b,alpha());
    }



    public static int toIntColor(byte r,byte g,byte b,byte a)
    {
        int ret= r;
        ret = (ret << 8) | g;
        ret = (ret << 8) | b;
        ret = (ret << 8) | a;
        return ret;
    }
    public static int toIntColor(byte r,byte g,byte b)
    {
        return toIntColor(r,g,b,(byte)0xFF);
    }
    public static int toIntColor(int r,int g,int b,int a)
    {
        return toIntColor((byte)r,(byte)g,(byte)b,(byte)a);
    }
    public static int toIntColor(int r,int g,int b)
    {
        return toIntColor((byte)r,(byte)g,(byte)b,(byte)0xFF);
    }

}
