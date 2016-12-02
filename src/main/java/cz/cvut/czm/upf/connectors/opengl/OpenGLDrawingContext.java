package cz.cvut.czm.upf.connectors.opengl;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import cz.cvut.czm.upf.core.geometry.Geometry;
import cz.cvut.czm.upf.core.media.*;

public class OpenGLDrawingContext extends DrawingContext {

    GL2 gl;
    OpenGLDrawingConfiguration conf;

    protected OpenGLDrawingContext(GL gl, float x, float y, float width, float height) {
        super(x, y, width, height);
        this.gl=gl.getGL2();
        gl.glScissor(this.x,this.y,this.width,this.height);
        conf=new OpenGLDrawingConfiguration(this);
    }

    @Override
    public DrawingConfiguration GetConfiguration() {
        return conf;
    }

    @Override
    public DrawingContext Clip(Geometry geometry) {
        return this;
    }

    private void prepBrush(Brush brush)
    {
        switch (brush.type())
        {
            case "solidColor": gl.glColor4fv(((SolidColorBrush)brush).color.get(),0);
                break;
        }
    }
    private void prepPen(Pen pen)
    {
        gl.glLineWidth(pen.thickness);
        prepBrush(pen.brush);
    }


    @Override
    public DrawingContext DrawEllipse(Brush brush, Pen pen, Point point, float width, float height) {

        return null;
    }
    private final static double DEG2RAD = 3.14159f/180.0f;
    private void drawEllipse(float x,float y,double w,double h)
    {
        gl.glBegin(GL2.GL_LINE_LOOP);
        for(int i=0;i<360;i++)
        {
            double deg=DEG2RAD*i;
            gl.glVertex2d(Math.cos(deg)*x,Math.sin(deg)*y);
        }
        gl.glEnd();
    }

    @Override
    public DrawingContext DrawRectangle(Brush brush, Pen pen, Point point, float width, float height) {
        return null;
    }

    @Override
    public DrawingContext DrawRectangle(Brush brush, Pen pen, Rect rect) {
        return null;
    }

    @Override
    public DrawingContext DrawText(Pen pen, FormattedText text, Point point) {
        return null;
    }

    @Override
    public DrawingContext DrawImage(Image image, Rect rect) {
        return null;
    }

    @Override
    public DrawingContext DrawImage(Brush brush, Image image, Rect rect) {
        return null;
    }

}
