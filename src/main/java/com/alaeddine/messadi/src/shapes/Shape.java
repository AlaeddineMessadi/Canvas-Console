package com.alaeddine.messadi.src.shapes;

import com.alaeddine.messadi.src.Canvas;
import com.alaeddine.messadi.src.Point;

public abstract class Shape {
    protected Canvas canvas;

    public abstract void draw();

    public Shape(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
