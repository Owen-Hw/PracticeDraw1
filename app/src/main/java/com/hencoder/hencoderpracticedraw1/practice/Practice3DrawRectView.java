package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice3DrawRectView extends View {

    Paint oPaint = new Paint();

    public Practice3DrawRectView(Context context) {
        super(context);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice3DrawRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawRect() 方法画矩形
        oPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(100,100,500,500,oPaint);

        oPaint.setColor(Color.BLACK);
        oPaint.setStyle(Paint.Style.STROKE);
        oPaint.setStrokeWidth(5);
        canvas.drawRect(700,100,1100,500,oPaint);

//        oPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawRect(600,600,1100,1100,oPaint);
    }
}
