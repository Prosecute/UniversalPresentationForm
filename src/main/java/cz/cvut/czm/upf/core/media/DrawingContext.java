package cz.cvut.czm.upf.core.media;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import java.awt.*;
import java.awt.image.renderable.RenderableImageProducer;

public abstract class DrawingContext {


    Graphics g;
    Graphics2D g2;

    protected DrawingContext()
    {

    }

    public abstract DrawingConfiguration GetConfiguration();

    public abstract DrawingContext DrawEllipse(Brush brush, Pen pen, Point point, float width, float height);

    public  abstract DrawingContext DrawRectangle(Brush brush, Pen pen, Point point, float width, float height);

    public abstract DrawingContext DrawRectangle(Brush brush, Pen pen, Rect rect);

    public abstract DrawingContext DrawText(Pen pen, FormattedText text, Point point);

    public abstract DrawingContext DrawImage(Image image,Rect rect);

    public abstract DrawingContext DrawImage(Brush brush, Image image, Rect rect);
}
