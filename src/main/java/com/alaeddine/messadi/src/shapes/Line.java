package com.alaeddine.messadi.src.shapes;

import com.alaeddine.messadi.src.Canvas;
import com.alaeddine.messadi.src.Point;

public class Line extends Shape{
    private Point p1;
    private Point p2;


    public Line(Point p1, Point p2, Canvas canvas) {
        super(canvas);
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Draw Line using Bresenham Algorithm
     */
    public void draw() {
        int x = p1.getX(), y = p1.getY(), x2 = p2.getX(), y2 = p2.getY();
        int w = x2 - x ;
        int h = y2 - y ;
        int dx1 = 0, dy1 = 0, dx2 = 0, dy2 = 0 ;
        if (w<0) dx1 = -1 ; else if (w>0) dx1 = 1 ;
        if (h<0) dy1 = -1 ; else if (h>0) dy1 = 1 ;
        if (w<0) dx2 = -1 ; else if (w>0) dx2 = 1 ;
        int longest = Math.abs(w) ;
        int shortest = Math.abs(h) ;
        if (!(longest>shortest)) {
            longest = Math.abs(h) ;
            shortest = Math.abs(w) ;
            if (h<0) dy2 = -1 ; else if (h>0) dy2 = 1 ;
            dx2 = 0 ;
        }
        int numerator = longest >> 1 ;
        for (int i=0;i<=longest;i++) {
            super.canvas.setCharAt(new Point(x,y),'x') ;
            numerator += shortest ;
            if (!(numerator<longest)) {
                numerator -= longest ;
                x += dx1 ;
                y += dy1 ;
            } else {
                x += dx2 ;
                y += dy2 ;
            }
        }

        super.canvas.printCanvas();
    }
}
