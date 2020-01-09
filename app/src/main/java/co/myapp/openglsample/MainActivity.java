package co.myapp.openglsample;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout glView;
    private GLRenderer renderer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        glView = findViewById(R.id.glview);
        setupGL();
    }

    private void setupGL(){
        renderer = new GLRenderer();

        GLSurfaceView glSurfaceView = new GLSurfaceView(this);
        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setRenderer(renderer);
        glView.addView(glSurfaceView);
        produceFrame();
    }

    private void produceFrame(){
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.sample);
        renderer.setBitmap(bmp);
    }


}
