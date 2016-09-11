package com.alaeddine.messadi.src.validator;

import com.alaeddine.messadi.src.Point;
import com.alaeddine.messadi.src.shapes.Fill;
import com.alaeddine.messadi.src.shapes.ShapeInterface;

public class CmdB extends Command{


    public String getName() {
        return "b";
    }

    public ShapeInterface execute(String[] parameters) {
        if (!this.validate(parameters)) {
            return null;
        }
        Point p = new Point(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        ShapeInterface fill = new Fill(p, (byte)parameters[2].charAt(0));
        canvas.addShape(fill);
        canvas.printCanvas();
        return fill;
    }

    public boolean validateLength(String[] parameters) {
        if (parameters.length != Command.FILL){
            System.out.println("Wrong parameters to Fill canvas, please check your command");
            return false;
        }
        return true;
    }

    @Override
    public boolean validateTypes(String[] parameters) {
        for (int i = 0; i < parameters.length-1; i++) {
            if (!isInteger(parameters[i])) {
                System.out.println("Parameter (" + parameters[i] + ") is not and integer");
                return false;
            }
        }
        return true;
    }

}
