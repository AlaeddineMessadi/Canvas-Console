package com.alaeddine.messadi.src.shapes;

import com.alaeddine.messadi.src.Point;

public class Line implements ShapeInterface {

    private Point p1;
    private Point p2;


    public Line(Point p1, Point p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Draw Line using Bresenham Algorithm
     */
    public byte[][] draw(byte[][] output) {

        output[p1.getY()][p1.getX()] = 'x';
        output[p2.getY()][p2.getX()] = 'x';

        drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY(), output);
        return output;
    }

    // Recursive function drawLine
    private void drawLine(int x0, int y0, int x1, int y1, byte[][] output) {
        int xMid, yMid;

        xMid = (x0 + x1) / 2;
        yMid = (y0 + y1) / 2;

        if ((x0 == xMid && y0 == yMid) || (x1 == xMid && y1 == yMid)) return;
        // insert the char to matrix
        output[yMid][xMid] = 'x';

        drawLine(x0, y0, xMid, yMid, output);
        drawLine(xMid, yMid, x1, y1, output);
    }
}
