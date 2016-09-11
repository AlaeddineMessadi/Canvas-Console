package com.alaeddine.messadi.src.validator;

import com.alaeddine.messadi.src.Canvas;
import com.alaeddine.messadi.src.shapes.ShapeInterface;

public abstract class Command {
    protected static final int QUIT = 0;
    protected static final int CREATE = 2;
    protected static final int LINE = 4;
    protected static final int RECTANGLE = 4;
    protected static final int FILL = 3;
    protected Canvas canvas;

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public abstract String getName();

    public abstract ShapeInterface execute(String[] parameters);

    public abstract boolean validateLength(String[] parameters);

    public boolean validate(String[] parameters) {
        if (parameters == null) {
            return false;
        }
        if (this.canvas == null) {
            System.out.println("You need to Create a Canvas first");
            return false;
        }
        return validateLength(parameters) && validateTypes(parameters);
    }

    public boolean validateTypes(String[] parameters) {
        for (int i = 0; i < parameters.length; i++) {
            if (!isInteger(parameters[i])) {
                System.out.println("Parameter (" + parameters[i] + ") is not and integer");
                return false;
            }
        }
        return true;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public boolean validateParams(String[] parameters){
        if (parameters == null){
            System.out.println("Parameters are missing");
            return false;
        }
        return true;
    }

}