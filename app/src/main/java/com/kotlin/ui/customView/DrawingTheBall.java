package com.kotlin.ui.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class DrawingTheBall extends View {

    private Rect mRect;
    private Paint bluePaint;
    private Paint redPaint;
    int mX, mY;

    public DrawingTheBall(Context context) {
        super(context);
        mRect = new Rect();

        bluePaint = new Paint();
        bluePaint.setColor(Color.BLUE);
        bluePaint.setStyle(Paint.Style.FILL);

        redPaint = new Paint();
        redPaint.setColor(Color.RED);
        redPaint.setStyle(Paint.Style.FILL);

        mX = 0;
        mY = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mRect.set(0, 0, canvas.getWidth(), canvas.getHeight() / 2);

        canvas.drawRect(mRect, bluePaint);

        if (mX < canvas.getWidth())
            mX += 10;
        else
            mX = 0;

        if (mY < (canvas.getHeight() / 2))
            mY += 10;
        else
            mY = 0;

        canvas.drawCircle(mX, mY, 20, redPaint);
        invalidate();
    }
}
