package com.alaeddine.messadi.validator;

import com.alaeddine.messadi.src.Canvas;

public class CmdQ extends Command {
    public String getName() {
        return "q";
    }

    public int execute(String[] parameters) {
        if (this.validateLength(parameters)) {
            System.out.println("Exit...");
            System.exit(0);
        }
        return 0;
    }

    public boolean validateLength(String[] parameters) {
        if (parameters.length != Command.QUIT){
            System.out.println("Wrong parameters!");
            return false;
        }
        return true;
    }
}