package com.example.test2dcanvas.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

public class GraphView extends View {
    private float xA,yA,xB,yB,xC,yC,xD,yD,xE,yE,xF,yF,xG,yG,xH,yH,xI,yI,xJ,yJ,x,y;//各个点的定义
    private int r;
    ArrayList<Point> gList = new ArrayList<Point>();

    public GraphView(Context context) {
        super(context);
    }
    
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);

        int viewWidth = this.getWidth();
        int viewHeight = this.getHeight();

        Log.i("GraphView",viewWidth + "-" + viewHeight);

        Paint paint=new Paint();//定义一个画笔
        paint.setColor(Color.WHITE);//画笔颜色
        canvas.drawRect(0,0,viewWidth,viewHeight,paint);//背景颜色所设计范围
        //canvas.drawRect(700,1000,700,1000,paint);
        //paint.setStyle(Paint.Style.STROKE);//画笔风格1（空心）
        paint.setStyle(Paint.Style.STROKE);//画笔风格2（实心）
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setStrokeWidth(5);//画笔宽度

        //循环
        for (int i=0;i<100;i++){
            //五角星颜色
            paint.setColor(Color.GREEN);
            //随机生成A点坐标和五角星边长
            Random random=new Random();
            //int min=50;
            //int max=100;
            //r=random.nextInt(max)%(max-min+1)-min;
            r = 5;
            //x=(float) Math.random()*700;
            //y=(float) Math.random()*1000;
            x = random.nextInt(viewWidth);
            y = random.nextInt(viewHeight);

            //标出五角星各个点的坐标
            xA=x;
            yA=y;
            xB=x+r;
            yB=y;
            xC=(float)(x+r+r*Math.sin(Math.toRadians(18)));
            yC=(float)(y+r*Math.cos(Math.toRadians(18)));
            xD=(float) (x+r+2*r*Math.sin(Math.toRadians(18)));
            yD=y;
            xE=(float) (x+2*r+2*r*Math.sin(Math.toRadians(18)));
            yE=y;
            xF=(float) (x+2*r+2*r*Math.sin(Math.toRadians(18))-r*Math.cos(Math.toRadians(36)));
            yF=(float)(y-r*Math.sin(Math.toRadians(36)));
            xG=(float) (x+2*r+2*r*Math.sin(Math.toRadians(18))-r*Math.cos(Math.toRadians(36))+r*Math.sin(Math.toRadians(27)));
            yG=(float)(y-r*Math.sin(Math.toRadians(36))-r*Math.cos(Math.toRadians(27)));
            xH=(float)(x+r*Math.cos(Math.toRadians(36))-r*Math.sin(Math.toRadians(27))+r*Math.cos(Math.toRadians(27)));
            yH=(float)(y-r*Math.sin(Math.toRadians(36))-r*Math.cos(Math.toRadians(27))+r*Math.sin(Math.toRadians(27)));
            xI=(float)(x+r*Math.cos(Math.toRadians(36))-r*Math.sin(Math.toRadians(27)));
            yI=(float)(y-r*Math.sin(Math.toRadians(36))-r*Math.cos(Math.toRadians(27)));
            xJ=(float)(x+r*Math.cos(Math.toRadians(36)));
            yJ=(float)(y-r*Math.sin(Math.toRadians(36)));
            Path path=new Path();//定义一个绘制多边形的类
            //开始绘制五角星
            path.moveTo(xA,yA);//起始点
            path.lineTo(xB,yB);
            path.lineTo(xC,yC);
            path.lineTo(xD,yD);
            path.lineTo(xE,yE);
            path.lineTo(xF,yF);
            path.lineTo(xG,yG);
            path.lineTo(xH,yH);
            path.lineTo(xI,yI);
            path.lineTo(xJ,yJ);
            path.close();//闭合
            canvas.drawPath(path,paint);

            Point point = new Point((int)(x+r+r*Math.sin(Math.toRadians(18))),(int)(y-r*Math.sin(Math.toRadians(36))));
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(1);//画笔宽度
            paint.setColor(Color.RED);//画笔颜色
            canvas.drawText(i + 1 + "",(float) (x+r+r*Math.sin(Math.toRadians(18))),(float) (y-r*Math.sin(Math.toRadians(36))),paint);
            gList.add(point);
        }

        float xF0 = gList.get(0).getX();
        float yF0 = gList.get(0).getY();

        for(int i = 1;i < gList.size();i++) {
            System.out.println(gList.get(i).getX() + "--" + gList.get(i).getY());
            paint.setColor(Color.RED);//画笔颜色
            //canvas.drawLine(xF0,yF0,gList.get(i).getX(),gList.get(i).getY(),paint);//背景颜色所设计范围

            xF0 = gList.get(i).getX();
            yF0 = gList.get(i).getY();
        }
    }

}
