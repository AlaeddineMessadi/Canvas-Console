/*
 * Canvas class
 */
package com.alaeddine.messadi.src;

/**
 *
 * @author alaeddine
 */
public class Canvas {

    private int height;
    private int width;
    private Character canvas[][];

    /**
     * For the canvas bordure, we add two columns and two rows
     *
     * @param width int
     * @param height int
     */
    public Canvas(int width, int height) {
        this.height = height + 2;
        this.width = width + 2;
        this.canvas = new Character[this.height][this.width];
        resetCanvas();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Character[][] getCanvas() {
        return canvas;
    }

    public void setCanvas(Character[][] canvas) {
        this.canvas = canvas;
    }

    /**
     * A Method to reset the canvas, and draw the bordure
     */
    private void resetCanvas() {
        for (int row = 0; row < this.canvas.length; row++) {
            for (int col = 0; col < this.canvas[row].length; col++) {
                if (row == 0 || row == this.canvas.length - 1) {
                    this.canvas[row][col] = '-';
                } else if (col == 0 || col == this.canvas[row].length - 1) {
                    this.canvas[row][col] = '|';
                } else {
                    this.canvas[row][col] = ' ';
                }
            }
        }
    }

    /**
     * Method to render the canvas in the console
     */
    public void printCanvas() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.canvas[i][j]);
            }
            System.out.println();
        }
    }

    public boolean setCharAt(Point p, Character c) {
        if (this.getValueAt(p) != -1){
            this.canvas[p.getY()][p.getX()] = c;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to avoid IndexOutOfBoundExceptions. This method return -1 if you
     * try to access an invalid position.
     */
    public int getValueAt(Point p) {
        if (p.getY() < 0 || p.getX() < 0 || p.getY() > this.canvas.length || p.getX() > this.canvas[p.getY()].length) {
            return -1;
        } else {
            return this.canvas[p.getY()][p.getX()];
        }
    }
}
