package com.alaeddine.messadi;

import com.alaeddine.messadi.src.factory.CommandFactory;
import com.alaeddine.messadi.src.Canvas;
import com.alaeddine.messadi.src.shapes.ShapeInterface;
import com.alaeddine.messadi.src.validator.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */


public class App 
{
    private static final String availableCmd = "clrbq";

    public static void main( String[] args )
    {

        Canvas canvas = null;
        printMenu();
        Scanner console = new Scanner(System.in);
        while (true){

            System.out.print("$ ");
            String userInput = console.nextLine().trim();
            if (!userInput.equals("")){
                String[] splitCmd = userInput.split(" ");
                Character cmd = splitCmd[0].toLowerCase().charAt(0);
                String[] parameters = Arrays.copyOfRange(splitCmd,1, splitCmd.length);

                CommandFactory commandFactory = new CommandFactory();
                Command command;
                if (availableCmd.indexOf(cmd) > -1) {
                    switch (cmd){
                        case 'c':
                            command = commandFactory.getCommand(cmd);
                            canvas = command.execute(parameters);
                            break;
                        case 'l' :
                            command = commandFactory.getCommand(cmd);
                            command.setCanvas(canvas);
                            canvas = command.execute(parameters);
                            break;
                        case 'r' :
                            command = commandFactory.getCommand(cmd);
                            command.setCanvas(canvas);
                            canvas = command.execute(parameters);
                            break;
                        case 'b' :
                            command = commandFactory.getCommand(cmd);
                            command.setCanvas(canvas);
                            canvas = command.execute(parameters);
                            break;
                        case 'q' :
                            Command command4 = commandFactory.getCommand(cmd);
                            command4.execute(parameters);
                            break;
                    }
                } else {
                    System.out.println("**********WRONG COMMAND TRY AGAIN ********");
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("******************************************");
        System.out.println("***********  Hello Dear Reviewer *********");
        System.out.println("******************************************");
        System.out.println("*                                        *");
        System.out.println("*                  CMD                   *");
        System.out.println("*                                        *");
        System.out.println("*   0) C 20 4         to create a convas *");
        System.out.println("*   1) L 1 2 6 2      to draw a line     *");
        System.out.println("*   2) L 6 3 6 4      to draw a line     *");
        System.out.println("*   2) R 16 1 20 3    to draw rectangle  *");
        System.out.println("*   3) B 10 3 o       bucket fill        *");
        System.out.println("*   4) extra          !?,>3$@@]|-        *");
        System.out.println("*                                        *");
        System.out.println("******************************************");
        System.out.println("*   3) Q              to Exit            *");
        System.out.println("******************************************");

//        System.out.println("******************************************");
//        System.out.println("***********  Hello Dear Reviewer *********");
//        System.out.println("******************************************");
//        System.out.println("*                                        *");
//        System.out.println("*                  CMD                   *");
//        System.out.println("*                                        *");
//        System.out.println("*   0) C w h          to create a convas *");
//        System.out.println("*   1) L x1 y1 x2 y2  to draw a line     *");
//        System.out.println("*   2) R x1 y1 x2 y2  to draw rectangle  *");
//        System.out.println("*   3) B x1 y1 color  to refill          *");
//        System.out.println("*                                        *");
//        System.out.println("******************************************");
//        System.out.println("*   3) Q              to Exit            *");
//        System.out.println("******************************************");
    }

}
