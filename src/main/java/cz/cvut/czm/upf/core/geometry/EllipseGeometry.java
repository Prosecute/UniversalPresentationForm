package cz.cvut.czm.upf.core.geometry;

import cz.cvut.czm.upf.core.media.Point;
import cz.cvut.czm.upf.core.media.Rect;

/**
 * Created by Fry on 29.11.2016.
 */
public class EllipseGeometry extends Geometry{
    private Rect area;

    public EllipseGeometry(Rect area)
    {
        this.area=area.copy();
    }
    public EllipseGeometry(Point center,float radiusX,float radiusY)
    {
        this(new Rect(center.x-radiusX/2,center.y-radiusY,radiusX*2,radiusY*2));
    }

    public Rect getBounds() {
        return area;
    }
}
