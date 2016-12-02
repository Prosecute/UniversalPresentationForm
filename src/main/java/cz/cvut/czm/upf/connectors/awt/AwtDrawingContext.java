package cz.cvut.czm.upf.connectors.awt;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.geometry.Geometry;
import cz.cvut.czm.upf.core.media.*;
import cz.cvut.czm.upf.core.media.Image;
import cz.cvut.czm.upf.core.media.Point;

import java.awt.*;
import java.awt.Color;
import java.awt.image.ImageObserver;

public class AwtDrawingContext extends DrawingContext {

    protected Color toAwtColor(cz.cvut.czm.upf.core.media.Color color)
    {
        return new Color(color.red(),color.green(),color.blue(),color.alpha());
    }

    protected volatile AwtImage image;
    Graphics2D g2;
    Graphics g;

    public AwtDrawingContext(AwtImage image)
    {
        super(0,0,0,0); //HACK:
        this.image=image;
        this.g=image.img.getGraphics();
        this.g2=(Graphics2D) image.img.getGraphics();
    }

    private boolean prepPen(Pen pen)
    {
        if(pen==null)
            return false;
        g2.setStroke(new BasicStroke(pen.thickness)); //TODO Extend stroke/thickness functionality
        g.setColor(toAwtColor(((SolidColorBrush)pen.brush).color)); //TODO Extend brush variations
        return true;
    }
    private boolean prepBrush(Brush brush)
    {
        if(brush==null)
            return false;
        g.setColor(toAwtColor(((SolidColorBrush)brush).color));
        return true;
    }

    @Override
    public DrawingConfiguration GetConfiguration() {
        return AwtDrawingConfiguration.getDefault();
    }

    @Override
    public DrawingContext Clip(Geometry geometry) {
        return null;
    }

    @Override
    public DrawingContext DrawEllipse(Brush brush, Pen pen, Point point, float width, float height) {
        if(prepBrush(brush))
            g.fillOval((int)point.x,(int)point.y,(int)width,(int)height);
        if(prepPen(pen))
            g.drawOval((int)point.x,(int)point.y,(int)width,(int)height);
        return this;
    }

    @Override
    public DrawingContext DrawRectangle(Brush brush, Pen pen, Point point, float width, float height) {
        if(prepBrush(brush))
            g.fillRect((int)point.x,(int)point.y,(int)width,(int)height);
        if(prepPen(pen))
            g.drawRect((int)point.x,(int)point.y,(int)width,(int)height);
        return this;
    }

    @Override
    public DrawingContext DrawRectangle(Brush brush, Pen pen, Rect rect) {
        return DrawRectangle(brush,pen,rect.topLeft(),rect.width,rect.height);
    }

    @Override
    public DrawingContext DrawText(Pen pen, FormattedText text, Point point) {
        g.setFont(text.font);
        if(prepPen(pen))
            g.drawString(text.text,(int)point.x,(int)point.y);
        return this;
    }

    @Override
    public DrawingContext DrawImage(Image image, Rect rect) {
        g.drawImage(((AwtImage)image).img,(int)rect.x,(int)rect.y,(int)rect.width,(int)rect.height, ((img, infoflags, x, y, width, height) -> false));
        return this;
    }

    @Override
    public DrawingContext DrawImage(Brush brush, Image image, Rect rect) {
        if(prepBrush(brush))
            g.drawImage(((AwtImage)image).img,(int)rect.x,(int)rect.y,(int)rect.width,(int)rect.height,toAwtColor(((SolidColorBrush)brush).color), ((img, infoflags, x, y, width, height) -> false));
        return this;
    }
}
