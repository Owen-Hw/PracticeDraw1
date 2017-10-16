package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    Paint oPaint = new Paint();

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        oPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(100, 100, 500, 300, 255, 105, true, oPaint);
        canvas.drawArc(100, 100, 500, 300, 20, 150, false, oPaint);

        oPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(100, 100, 500, 300, 180, 60, false, oPaint);
    }
}
