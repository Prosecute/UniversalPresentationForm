package cz.cvut.czm.upf.core.geometry;

import cz.cvut.czm.upf.core.media.Rect;

import java.awt.*;

/**
 * Created by Fry on 29.11.2016.
 */
public class RectangleGeometry extends Geometry {
    private Rect area;

    public RectangleGeometry(Rect area)
    {
        this.area=area.copy();
    }
    public RectangleGeometry(float x,float y,float width,float height)
    {
        this.area=new Rect(x,y,width,height);
    }



    public Rect toRect()
    {
        return area.copy();
    }

    public Rect getBounds() {
        return area;
    }
}
