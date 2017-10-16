package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

    Paint oPaint;
    private int rectangleNum;

    private int marginTop = 20;
    private int marginLeft = 60;
    private int marginRight = 60;
    private int marginBottom = 60;

    private List<MobileData> oMobileData;
    /*xy图形的宽高*/
    private int oWidth, oHeight;
    /*柱状图形的宽度*/
    private int oPreviewWidth = 30;
    /*柱状图间隔*/
    private int oViewMargin = 15;
    /*柱状图1占比高度*/
    private int oPerHeight;

    public Practice10HistogramView(Context context) {
        super(context);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        oPaint = new Paint();
        oMobileData = new ArrayList<>();
        oMobileData.add(new MobileData("Foyo", 10));
        oMobileData.add(new MobileData("GB", 20));
        oMobileData.add(new MobileData("ICS", 30));
        oMobileData.add(new MobileData("JB", 40));
        oMobileData.add(new MobileData("Kitkat", 70));
        oMobileData.add(new MobileData("L", 80));
        oMobileData.add(new MobileData("M", 30));
        rectangleNum = oMobileData.size();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initWidth();
    }

    private void initWidth() {
        oWidth = getMeasuredWidth() - marginLeft - marginRight;
        oHeight = getMeasuredHeight() - marginTop - marginBottom;
        oPerHeight = oHeight / 100;
        oPreviewWidth = (oWidth - (rectangleNum + 1) * oViewMargin) / rectangleNum;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        /*绘制xy轴*/
        drawXY(canvas);

         /*绘制文字*/
        drawText(canvas);

            /*绘制文字*/
        drawRectangleView(canvas);
    }

    private void drawRectangleView(Canvas canvas) {
        oPaint.setColor(Color.GREEN);
        int ey = getHeight() - marginBottom;
        for (int i = 0; i < rectangleNum; i++) {
            MobileData md = oMobileData.get(i);
            int sx = (i + 1) * oViewMargin + i * oPreviewWidth + marginLeft;
            int sy = getHeight() - marginBottom - oPerHeight * md.data;
            int ex = sx + oPreviewWidth;
            canvas.drawRect(sx, sy, ex, ey, oPaint);
        }
    }

    private void drawText(Canvas canvas) {
        oPaint.setColor(Color.WHITE);
        oPaint.setTextSize(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
        oPaint.setStrokeWidth(2);
        oPaint.setTextAlign(Paint.Align.CENTER);

        int y = getHeight() - marginBottom + 40;
        for (int i = 0; i < rectangleNum; i++) {
            MobileData md = oMobileData.get(i);
            int x = (i + 1) * oViewMargin + i * oPreviewWidth + marginLeft;
            canvas.drawText(md.name, x + oPreviewWidth / 2, y, oPaint);
        }
    }

    private void drawXY(Canvas canvas) {
        oPaint.setColor(Color.WHITE);
        oPaint.setStrokeWidth(2);
        canvas.drawLine(marginLeft, marginTop, marginLeft, getHeight() - marginBottom, oPaint);
        canvas.drawLine(marginLeft, getHeight() - marginBottom, getWidth() - marginRight, getHeight() - marginBottom, oPaint);

    }
}
