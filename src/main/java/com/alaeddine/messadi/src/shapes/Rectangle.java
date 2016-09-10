package com.alaeddine.messadi.src.shapes;

import com.alaeddine.messadi.src.Canvas;
import com.alaeddine.messadi.src.Point;

public class Rectangle extends Shape{
    private Point p1;
    private Point p2;
    public Rectangle(Point p1, Point p2, Canvas canvas) {
        super(canvas);
        this.p1 = p1;
        this.p2 = p2;
    }

    public void draw() {
        for (int row = p1.getY(); row <= p2.getY(); row++) {
            for (int col = p1.getX(); col <= p2.getX(); col++) {
                if ((row == p1.getY() || row == p2.getY()) || (col == p1.getX() || col == p2.getX())) {
                    super.canvas.setCharAt(new Point(col,row), 'x');
                }
            }
        }
        super.canvas.printCanvas();
    }
}
