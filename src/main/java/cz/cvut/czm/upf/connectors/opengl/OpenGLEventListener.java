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
import cz.cvut.czm.upf.core.UIElement;
import cz.cvut.czm.upf.core.media.Color;
import cz.cvut.czm.upf.core.media.Colors;
import cz.cvut.czm.upf.core.media.Rect;
import cz.cvut.czm.upf.core.media.Vector;

public class OpenGLEventListener implements GLEventListener {


    protected final OpenGLWindow window;
    protected OpenGLEventListener(OpenGLWindow window)
    {
        this.window=window;
    }

    @Override
    public void init(GLAutoDrawable drawable) {

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final int width=window.window.getWidth();
        final int height=window.window.getHeight();
        clearScreen(drawable);
        UIElement content=window.getContent();
        content.measure(new Vector(width,height));
        content.arrange(new Rect(0,0,width,height));
        content.render(new OpenGLDrawingContext(drawable.getGL(),0,0,width,height));
    }

    protected void clearScreen(GLAutoDrawable drawable)
    {
        final GL gl = drawable.getGL();
        final Color color = window.getBackgroundColor()==null? Colors.white():window.getBackgroundColor();

        gl.glClearColor(color.red(),color.green(),color.blue(),color.alpha());
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        final GL2 gl= drawable.getGL().getGL2();
        gl.glViewport(0,0,width,height);
    }
}
