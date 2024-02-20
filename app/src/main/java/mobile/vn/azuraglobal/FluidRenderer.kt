package mobile.vn.azuraglobal

import android.opengl.GLES20
import android.opengl.GLSurfaceView
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class FluidRenderer : GLSurfaceView.Renderer {
    private val triangle: Triangle = Triangle()

    override fun onSurfaceCreated(unused: GL10?, config: EGLConfig?) {

    }

    override fun onDrawFrame(unused: GL10?) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)
        triangle.draw()
    }

    override fun onSurfaceChanged(unused: GL10?, width: Int, height: Int) {
        unused?.apply {
            glViewport(0, 0, width, height)

            // make adjustments for screen ratio
            val ratio: Float = width.toFloat() / height.toFloat()

            glMatrixMode(GL10.GL_PROJECTION)            // set matrix to projection mode
            glLoadIdentity()                            // reset the matrix to its default state
            glFrustumf(-ratio, ratio, -1f, 1f, 3f, 7f)  // apply the projection matrix
        }
    }

    companion object {
        fun loadShader(type: Int, shaderCode: String): Int {
            // Tạo shader
            val shader = GLES20.glCreateShader(type)

            // Thêm mã shader vào shader object
            GLES20.glShaderSource(shader, shaderCode)

            // Biên dịch shader
            GLES20.glCompileShader(shader)

            // Kiểm tra lỗi biên dịch
            val compileStatus = IntArray(1)
            GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compileStatus, 0)
            if (compileStatus[0] == 0) {
                val log = GLES20.glGetShaderInfoLog(shader)
                GLES20.glDeleteShader(shader)
                throw RuntimeException("Could not compile shader: $log")
            }

            return shader
        }
    }
}