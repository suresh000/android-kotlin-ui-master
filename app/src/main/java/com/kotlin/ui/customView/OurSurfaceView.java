package com.kotlin.ui.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class OurSurfaceView extends SurfaceView implements Runnable {

    private Thread thread = null;
    private SurfaceHolder surfaceHolder;
    private boolean isItOK = false;

    private Paint whitePaint;
    private float mX, mY;

    public OurSurfaceView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        mX = 0;
        mY = 0;

        whitePaint = new Paint();
        whitePaint.setColor(Color.WHITE);
        whitePaint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void run() {
        while (isItOK) {
            if (!surfaceHolder.getSurface().isValid()) {
                continue;
            }

            Canvas canvas = surfaceHolder.lockCanvas();
            canvas.drawARGB(255, 150, 150, 10);

            canvas.drawCircle(mX, mY, 60, whitePaint);

            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mX = event.getX();
                mY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                mX = event.getX();
                mY = event.getY();
                break;
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
