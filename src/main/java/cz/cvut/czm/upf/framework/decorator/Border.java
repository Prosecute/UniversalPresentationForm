package cz.cvut.czm.upf.framework.decorator;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import cz.cvut.czm.upf.core.media.*;

public class Border<T extends Border> extends Decorator<T> {

    public Pen borderPen;

    public Border()
    {
        this.renderer.add(dc -> {
            dc.DrawRectangle(null,borderPen,bounds);
        });
    }

    @Override
    protected Vector measureOverwrite(Vector availableSize) {
        child.measure(availableSize);
        return child.getMeasuredSize().copy().add(new Vector(borderPen.thickness,borderPen.thickness));
    }

    @Override
    protected Vector arrangeOverwrite(Vector finalSize) {
        final float startPos=borderPen.thickness/2.0f;
        child.arrange(new Rect(startPos,startPos,finalSize.x-borderPen.thickness,finalSize.y-borderPen.thickness));
        Rect rect=child.getRenderRect();
        return new Vector(rect.x+rect.width+startPos,rect.y+rect.height+startPos);
    }


}
