package com.alaeddine.messadi.src.shapes;

import com.alaeddine.messadi.src.Point;

public class Fill implements ShapeInterface {
    private Point p;
    private byte color;

    public Fill(Point p, byte color) {
        this.p = p;
        this.color = color;
    }

    public byte[][] draw(byte[][] output) {
        bucketFill(output,this.p);
        return output;
    }

    /**
     * BucketFill Method, Fill empty spaces to the edge of other shapes
     * @param output byte[][]
     * @param p Point
     */
    private void bucketFill(byte[][] output, Point p) {
        int currentColor = output[p.getY()][p.getX()];
        if (currentColor == ' ') {
            output[p.getY()][p.getX()] = this.color;
            bucketFill(output, new Point(p.getX()+1, p.getY()));
            bucketFill(output, new Point(p.getX()-1, p.getY()));
            bucketFill(output, new Point(p.getX(), p.getY()+1));
            bucketFill(output, new Point(p.getX()+1, p.getY()-1));
        }
    }

}
