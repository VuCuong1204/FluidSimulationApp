package mobile.vn.azuraglobal

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLSurfaceView

class CustomGLSurfaceView(context: Context) : GLSurfaceView(context) {
    private var glSurface: GLRenderer

    init {
        setEGLContextClientVersion(2)
        glSurface = GLRenderer()
        setRenderer(glSurface)
    }
}
