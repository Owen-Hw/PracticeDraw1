package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Practice11PieChartView extends View {


    Paint oPaint;
    private int rectangleNum;
    private List<MobileData> oMobileData;
    private int oRadius;
    private String[] mColors = {"#2196f3", "#009688", "#9e9e9e", "#9c27b0", "#509e6a", "#f44336", "#ffc107"};
    private float oPerDegree;
    private int oArcMargin = 2;


    public Practice11PieChartView(Context context) {
        super(context);
        initPaint();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        //计算数据总量
        int allNum = 0;
        for (MobileData phoneData : oMobileData) {
            allNum = phoneData.data + allNum;
        }
        //将数据排序,最后画最大的,因为最大的圆心需要移动,分隔开
        Collections.sort(oMobileData, new Comparator<MobileData>() {
            @Override
            public int compare(MobileData o1, MobileData o2) {
                return o1.data - o2.data;
            }
        });
        //每份占比多少度,总共是360度,去除7个饼之间的间隙
        oPerDegree = (360 - 6 * oArcMargin) / (float) allNum;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        oRadius = (getMeasuredHeight() - 100) / 3;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        oPaint.setAntiAlias(true);
        int left = 60;
        int right = left + oRadius * 2;
        int top = 20;
        int bottom = oRadius * 2;

        int lastDegree = 0;
        int sweepDegree;

        for (int i = 0; i < rectangleNum; i++) {

            oPaint.setColor(Color.parseColor(mColors[i]));
            MobileData md = oMobileData.get(i);
            sweepDegree = (int) (md.data * oPerDegree);
            if (i == rectangleNum - 1) {
                canvas.drawArc(left+10, top-10, right+10, bottom-10, lastDegree, sweepDegree, true, oPaint);
            } else {
                canvas.drawArc(left, top, right, bottom, lastDegree, sweepDegree, true, oPaint);
                lastDegree = lastDegree + sweepDegree + oArcMargin;
            }
        }
    }
}
