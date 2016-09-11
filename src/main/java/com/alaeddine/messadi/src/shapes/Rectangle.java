package com.alaeddine.messadi.src.shapes;

import com.alaeddine.messadi.src.Point;

public class Rectangle implements ShapeInterface {

    private Point p1;
    private Point p2;

    public Rectangle(Point p1, Point p2) {
        super();
        this.p1 = p1;
        this.p2 = p2;
    }

    public byte[][] draw(byte[][] output) {
        for (int row = p1.getY(); row <= p2.getY(); row++) {
            for (int col = p1.getX(); col <= p2.getX(); col++) {
                if ((row == p1.getY() || row == p2.getY()) || (col == p1.getX() || col == p2.getX())) {
                    output[row][col] = 'x';
                }
            }
        }
        return output;
    }
}
