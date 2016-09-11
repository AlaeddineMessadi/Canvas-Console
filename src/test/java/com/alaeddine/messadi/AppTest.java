package com.alaeddine.messadi;

import com.alaeddine.messadi.src.factory.CommandFactory;
import com.alaeddine.messadi.src.Canvas;
import com.alaeddine.messadi.src.shapes.Fill;
import com.alaeddine.messadi.src.shapes.Line;
import com.alaeddine.messadi.src.shapes.Rectangle;
import com.alaeddine.messadi.src.shapes.ShapeInterface;
import com.alaeddine.messadi.src.validator.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Springer Canvas App.
 */
public class AppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testCommandC() {
        CommandFactory commandFactory = new CommandFactory();
        Command cmd = commandFactory.getCommand('c');

        assertTrue(cmd instanceof CmdC);
        String[] parameters1 = {"10", "5"};
        String[] parameters2 = {"10", "5", "4"};
        String[] parameters3 = {"10", "f"};
        assertTrue(cmd.execute(parameters2) == null);
        assertTrue(cmd.execute(parameters3) == null);
        assertTrue(cmd.execute(null) == null);
        assertTrue(cmd.execute(parameters1) != null);
    }

    public void testCommandL() {
        Canvas canvas;
        CommandFactory commandFactory = new CommandFactory();
        Command cmdC = commandFactory.getCommand('c');
        Command cmdL = commandFactory.getCommand('l');

        assertTrue(cmdC instanceof CmdC);
        assertTrue(cmdL instanceof CmdL);
        String[] parametersC = {"20", "4"};
        String[] parametersL1 = {"1", "2", "6", "2"}; // correct parameters
        String[] parametersL2 = {"1", "2", "6", "2", "2"};
        String[] parametersL3 = {"1", "2", "6", "L"};
        String[] parametersL4 = {"1", "2", "6"};
        String[] parametersL5 = {"6", "3", "6", "4"}; // correct parameters

        assertTrue(cmdL.execute(parametersL1) == null);
        cmdC.execute(parametersC);
        canvas = cmdC.getCanvas();
        cmdL.setCanvas(canvas);
        assertTrue(cmdL.execute(parametersL2) == null);
        assertTrue(cmdL.execute(parametersL3) == null);
        assertTrue(cmdL.execute(parametersL4) == null);
        assertTrue(cmdL.execute(parametersL1) != null);
        assertTrue(cmdL.execute(parametersL5) != null);
    }

    public void testCommandR() {
        Canvas canvas;
        CommandFactory commandFactory = new CommandFactory();
        Command cmdC = commandFactory.getCommand('c');
        Command cmdL = commandFactory.getCommand('r');

        assertTrue(cmdC instanceof CmdC);
        assertTrue(cmdL instanceof CmdR);
        String[] parametersC = {"20", "4"};
        String[] parametersR1 = {"16", "1", "20", "3"}; // correct parameters
        String[] parametersR2 = {"16", "1", "20", "3", "2"};
        String[] parametersR3 = {"16", "1", "20", "L"};
        String[] parametersR4 = {"16", "1", "20"};

        assertTrue(cmdL.execute(parametersR1) == null);
        cmdC.execute(parametersC);
        canvas = cmdC.getCanvas();
        cmdL.setCanvas(canvas);
        assertTrue(cmdL.execute(parametersR2) == null);
        assertTrue(cmdL.execute(parametersR3) == null);
        assertTrue(cmdL.execute(parametersR4) == null);

        assertTrue(cmdL.execute(parametersR1) != null);
    }

    public void testCommandB() {
        Canvas canvas;
        CommandFactory commandFactory = new CommandFactory();
        Command cmdC = commandFactory.getCommand('c');
        Command cmdB = commandFactory.getCommand('b');

        assertTrue(cmdC instanceof CmdC);
        assertTrue(cmdB instanceof CmdB);
        String[] parametersC = {"20", "4"};
        String[] parametersB1 = {"10", "3", "O"}; // correct parameters
        String[] parametersB2 = {"10", "3", "O", "2"};
        String[] parametersB3 = {"10", "B", "O"};
        String[] parametersB4 = {"10", "3"};

        assertTrue(cmdB.execute(parametersB1) == null);
        cmdC.execute(parametersC);
        canvas = cmdC.getCanvas();
        cmdB.setCanvas(canvas);
        assertTrue(cmdB.execute(parametersB2) == null);
        assertTrue(cmdB.execute(parametersB3) == null);
        assertTrue(cmdB.execute(parametersB4) == null);
        assertTrue( cmdB.execute(parametersB1) != null);
    }

    public void testApp() {
        Canvas canvas;
        CommandFactory commandFactory = new CommandFactory();
        Command cmd = commandFactory.getCommand('c');

        assertTrue(cmd instanceof CmdC);

        String[] parametersC = {"20", "4"};
        String[] parametersL1 = {"1", "2", "6", "2"};
        String[] parametersL2 = {"6", "3", "6", "4"};
        String[] parametersR = {"16", "1", "20", "3"};
        String[] parametersB = {"10", "3", "o"};

        // create
        assertTrue(cmd.execute(parametersC) != null);
        canvas = cmd.getCanvas();

        // line
        cmd = commandFactory.getCommand('l');
        assertTrue(cmd instanceof CmdL);
        cmd.setCanvas(canvas);
        assertTrue(cmd.execute(parametersL1) != null);
        assertTrue(cmd.execute(parametersL2) != null);

        // rectangle
        cmd = commandFactory.getCommand('r');
        assertTrue(cmd instanceof CmdR);
        cmd.setCanvas(canvas);
        assertTrue(cmd.execute(parametersR) != null);

        // bucket fill
        cmd = commandFactory.getCommand('b');
        assertTrue(cmd instanceof CmdB);
        cmd.setCanvas(canvas);
        assertTrue(cmd.execute(parametersB) != null);
    }
}
