package cz.cvut.czm.upf.core.media;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.geometry.Geometry;

import java.awt.*;
import java.awt.image.renderable.RenderableImageProducer;

public abstract class DrawingContext {

    public final int x,y,width,height;


    protected DrawingContext(float x,float y,float width,float height)
    {
        this.x=(int)x;
        this.y=(int)y;
        this.width=(int)width;
        this.height=(int)height;
    }

    public abstract DrawingConfiguration GetConfiguration();

    public abstract DrawingContext Clip(Geometry geometry);


    public abstract DrawingContext DrawEllipse(Brush brush, Pen pen, Point point, float width, float height);

    public  abstract DrawingContext DrawRectangle(Brush brush, Pen pen, Point point, float width, float height);

    public abstract DrawingContext DrawRectangle(Brush brush, Pen pen, Rect rect);

    public abstract DrawingContext DrawText(Pen pen, FormattedText text, Point point);

    public abstract DrawingContext DrawImage(Image image,Rect rect);

    public abstract DrawingContext DrawImage(Brush brush, Image image, Rect rect);
}
