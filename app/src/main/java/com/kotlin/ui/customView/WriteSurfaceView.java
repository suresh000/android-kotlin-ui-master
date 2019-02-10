package com.kotlin.ui.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class WriteSurfaceView extends SurfaceView implements Runnable {

    private Thread thread;
    private SurfaceHolder surfaceHolder;
    private boolean isItOK = false;

    private Paint linePaint = new Paint();
    private float mX, mY;

    public WriteSurfaceView(Context context) {
        super(context);
        surfaceHolder = getHolder();

        linePaint.setColor(Color.GRAY);
        linePaint.setStyle(Paint.Style.FILL);
        linePaint.setStrokeWidth(20);
    }

    @Override
    public void run() {
        while (isItOK) {
            if (!surfaceHolder.getSurface().isValid()) {
                continue;
            }

            Canvas canvas = surfaceHolder.lockCanvas();

            canvas.drawARGB(255, 255, 255, 255);

            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                mX = event.getX();
                mY = event.getY();
                break;
        }

        return true;
    }

    public void pause() {
        isItOK = false;
        while (true) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            break;
        }
        thread = null;
    }

    public void resume() {
        isItOK = true;
        thread = new Thread(this);
        thread.start();
    }
}
