package cz.cvut.czm.upf.connectors.opengl;
///////////////////////////////////////////////////////////////////////////////
//
//Author: Jiri Fryc
//
//Licence: AGPL v3
//
//This file is part of upf, which is part of Prosecutor. 
///////////////////////////////////////////////////////////////////////////////


import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import cz.cvut.czm.upf.Window;
import cz.cvut.czm.upf.framework.control.TextBox;
import cz.cvut.czm.upf.framework.layouts.Canvas;

public class OpenGLWindow<T extends OpenGLWindow> extends Window<T> {

    public final GLWindow window;

    public OpenGLWindow()
    {
        GLProfile profile = GLProfile.getDefault();
        GLCapabilities cap = new GLCapabilities(profile);
        this.window = GLWindow.create(cap);

        // Create a animator that drives canvas' display() at the specified FPS.
        final FPSAnimator animator = new FPSAnimator(window, 60, true);

        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent arg0) {
                // Use a dedicate thread to run the stop() to ensure that the
                // animator stops before program exits.
                new Thread() {
                    @Override
                    public void run() {
                        if (animator.isStarted())
                            animator.stop();    // stop the animator loop
                        System.exit(0);
                    }
                }.start();
            }
        });
        animator.start();
        window.setVisible(true);
    }

    @Override
    public T setTitle(String title) {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    public static void main(String... args)
    {
        OpenGLWindow win=new OpenGLWindow();
        win.setContent(new Canvas()
                .addChild(new TextBox()));
        win.setVisible(true);
    }
}
