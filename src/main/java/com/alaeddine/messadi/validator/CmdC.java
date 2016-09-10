package com.alaeddine.messadi.validator;

import com.alaeddine.messadi.src.Canvas;

public class CmdC extends Command{
    public String getName() {
        return "c";
    }

    public int execute(String[] parameters) {
        if (!this.validate(parameters)) {
            return -1;
        }

        super.canvas = new Canvas(Integer.parseInt(parameters[0]),Integer.parseInt(parameters[1]));
        canvas.printCanvas();
        return 0;
    }

    public boolean validateLength(String[] parameters) {
        if (parameters.length != Command.CREATE){
            System.out.println("Wrong parameters to create the canvas, please check your command");
            return false;
        }
        return true;
    }

    @Override
    public boolean validate(String[] parameters) {
        if (parameters == null) {
            return false;
        }
        return validateLength(parameters) && validateTypes(parameters);
    }
}
