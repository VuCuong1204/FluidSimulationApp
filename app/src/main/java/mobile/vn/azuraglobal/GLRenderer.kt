package mobile.vn.azuraglobal

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class GLRenderer : GLSurfaceView.Renderer {
    private var redValue = 1f

    //    private lateinit var mTriangle: Triangle
//    private lateinit var mSquare: Square2
    override fun onSurfaceCreated(p0: GL10?, p1: EGLConfig?) {
//        // initialize a triangle
//        mTriangle = Triangle()
//        // initialize a square
//        mSquare = Square()
        GLES20.glClearColor(redValue, 0f, 0f, 1f)
    }

    override fun onSurfaceChanged(p0: GL10?, p1: Int, p2: Int) {
        GLES20.glViewport(0, 0, p1, p2)
    }

    override fun onDrawFrame(p0: GL10?) {
        GLES20.glClearColor(redValue, 0f, 0f, 1f)
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)
    }
}
