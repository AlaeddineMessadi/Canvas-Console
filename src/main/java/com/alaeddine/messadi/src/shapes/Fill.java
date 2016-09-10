package com.alaeddine.messadi.src.shapes;

import com.alaeddine.messadi.src.Canvas;
import com.alaeddine.messadi.src.Point;

public class Fill extends Shape {
    private Point p;
    private Character color;

    public Fill(Point p, Character color, Canvas canvas) {
        super(canvas);
        this.p = p;
        this.color = color;
    }

    public void draw() {
        bucketFill(super.canvas,this.p);
        super.canvas.printCanvas();
    }

    /**
     * BucketFill Method, Fill empty spaces to the edge of other shapes
     * @param canvas Canvas
     * @param p Point
     */
    private void bucketFill(Canvas canvas, Point p) {

        int currentColor = canvas.getValueAt(p);
        if (currentColor == ' ') {
            canvas.setCharAt(new Point(p.getX(),p.getY()), this.color);
            bucketFill(canvas, new Point(p.getX()+1, p.getY()));
            bucketFill(canvas, new Point(p.getX()-1, p.getY()));
            bucketFill(canvas, new Point(p.getX(), p.getY()+1));
            bucketFill(canvas, new Point(p.getX()+1, p.getY()-1));
        }
    }

}
