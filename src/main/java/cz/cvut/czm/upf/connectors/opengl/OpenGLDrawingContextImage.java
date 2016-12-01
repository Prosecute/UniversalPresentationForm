package cz.cvut.czm.upf.connectors.opengl;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import com.jogamp.opengl.GL2;
import cz.cvut.czm.upf.core.media.*;

public class OpenGLDrawingContextImage extends OpenGLDrawingContext {

    protected final OpenGLImage image;

    protected OpenGLDrawingContextImage(OpenGLImage image,GL2 gl, float x, float y, float width, float height) {
        super(gl, x, y, width, height);
        this.image=image;
    }

    @Override
    public DrawingContext DrawEllipse(Brush brush, Pen pen, Point point, float width, float height) {
        gl.glDrawBuffer(GL2.GL_BACK);
        super.DrawEllipse(brush, pen, point, width, height);
        gl.glReadBuffer(GL2.GL_BACK);
        gl.glReadPixels(this.x,this.y,this.width,this.height,GL2.GL_RGBA,GL2.GL_UNSIGNED_BYTE,image.buffer);
        return this;
    }

    @Override
    public DrawingContext DrawRectangle(Brush brush, Pen pen, Point point, float width, float height) {
        gl.glDrawBuffer(GL2.GL_BACK);
        super.DrawRectangle(brush, pen, point, width, height);
        gl.glReadBuffer(GL2.GL_BACK);
        gl.glReadPixels(this.x,this.y,this.width,this.height,GL2.GL_RGBA,GL2.GL_UNSIGNED_BYTE,image.buffer);
        return this;
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
