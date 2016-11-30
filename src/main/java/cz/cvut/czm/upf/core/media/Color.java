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
    protected byte[] color=new byte[4];

    public Color(int r,int g,int b)
    {
        this.color=tobyteArray(r,g,b,0xFF);
    }
    public Color(int r,int g,int b,int a)
    {
        this.color=tobyteArray(r,g,b,a);
    }
    public Color(String hex)
    {

    }
    public Color(byte[] rgba)
    {
        this.color=rgba;
    }

    public Color(int rgba)
    {
        this.color=tobyteArray(rgba);
    }

    public Color copy()
    {
        return new Color(this.color);
    }

    public int red()
    {
        return color[0];
    }
    public int green()
    {
        return color[1];
    }
    public int blue()
    {
        return color[2];
    }
    public int alpha()
    {
        return color[3];
    }
    public byte[] get()
    {
        return color;
    }
    public Color set(int r,int g,int b,int a)
    {
        return this;
    }
    public Color set(int r,int g,int b)
    {
        return set(r,g,b,alpha());
    }



    public static byte[] tobyteArray(int r,int g,int b,int a)
    {
        return new byte[]{(byte)r,(byte)g,(byte)b,(byte)a};
    }
    public static byte[] tobyteArray(int rgba)
    {
        return new byte[]{(byte)(rgba >> 24 & 0xFF),(byte)(rgba >> 16 & 0xFF),(byte)(rgba >> 8 & 0xFF),(byte)(rgba & 0xFF)};
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
