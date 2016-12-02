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
    protected float[] color=new float[4];

    public Color(float r,float g,float b)
    {
        this.color=new float[]{r,g,b,1.0f};
    }
    public Color(float r,float g,float b,float a)
    {
        this.color=new float[]{r,g,b,a};
    }
    public Color(String hex)
    {

    }
    public Color(float[] rgba)
    {
        this.color=rgba;
    }

    public Color(int rgba)
    {
        this.color=toFloatArray(rgba);
    }

    public Color copy()
    {
        return new Color(this.color);
    }

    public float red()
    {
        return color[0];
    }
    public float green()
    {
        return color[1];
    }
    public float blue()
    {
        return color[2];
    }
    public float alpha()
    {
        return color[3];
    }
    public float[] get()
    {
        return color;
    }
    public Color set(float r,float g,float b,float a)
    {
        this.color=new float[]{r,g,b,a};
        return this;
    }
    public Color set(float r,float g,float b)
    {
        return set(r,g,b,color[3]);
    }



    public static float[] toFloatArray(int r,int g,int b,int a)
    {
        return new float[]{r/255.0f,g/255.0f,b/255.0f,a/255.0f};
    }
    public static float[] toFloatArray(int rgba)
    {
        return new float[]{(rgba >> 24 & 0xFF)/255.0f,(rgba >> 16 & 0xFF)/255.0f,(rgba >> 8 & 0xFF)/255.0f,(rgba & 0xFF)/255.0f};
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
