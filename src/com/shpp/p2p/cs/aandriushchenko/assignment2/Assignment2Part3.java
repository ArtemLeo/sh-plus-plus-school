package com.shpp.p2p.cs.aandriushchenko.assignment2;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

import java.awt.*;

/*
  Problem # 3: Paw Prints
  Fill empty method drawPawprint(double x, double y) with code.
*/
public class Assignment2Part3 extends GraphicsProgram {

    // Initialization of static constants.
    // Constants that control the positions of the three fingers about the upper left corner of the foot
    private static final double FIRST_TOE_OFFSET_X = 0;              // First toe: X-offset
    private static final double FIRST_TOE_OFFSET_Y = 20;             // First toe: Y-offset
    private static final double SECOND_TOE_OFFSET_X = 30;            // Second toe: X-offset
    private static final double SECOND_TOE_OFFSET_Y = 0;             // Second toe: Y-offset
    private static final double THIRD_TOE_OFFSET_X = 60;             // Third toe: X-offset
    private static final double THIRD_TOE_OFFSET_Y = 20;             // Third toe: Y-offset

    // Heel position about the upper left corner of the foot
    private static final double HEEL_OFFSET_X = 20;                  // Heel: X-offset
    private static final double HEEL_OFFSET_Y = 40;                  // Heel: Y-offset

    // Each toe is an oval with this width and height
    private static final double TOE_WIDTH = 20;                      // Toe width
    private static final double TOE_HEIGHT = 30;                     // Toe height

    // The heel is an oval with this width and height
    private static final double HEEL_WIDTH = 40;                     // Heel width
    private static final double HEEL_HEIGHT = 60;                    // Heel height

    // The colors of the print
    public static final Color TOE_COLOR = Color.BLACK;               // Toe color
    public static final Color HEEL_COLOR = Color.BLACK;              // Heel color

    // Method run(): Draws paw prints, get window width and height and setting the window header
    public void run() {
        setTitle("PawPrints");                                           // Setting the window header to "PawPrints"
        setSize((int) (getWidth() / 2.5), (int) (getHeight() / 1.8));    // Set window width and height
        drawPawprint(20, 20);                                      // Draw first paw print
        drawPawprint(180, 70);                                     // Draw second paw print
    }

    // Method drawPawprint(): Draws three toes and heel of the paw print
    private void drawPawprint(double x, double y) {
        drawToe(x + FIRST_TOE_OFFSET_X, y + FIRST_TOE_OFFSET_Y);      // Draw first toe
        drawToe(x + SECOND_TOE_OFFSET_X, y + SECOND_TOE_OFFSET_Y);    // Draw second toe
        drawToe(x + THIRD_TOE_OFFSET_X, y + THIRD_TOE_OFFSET_Y);      // Draw third toe
        drawHeel(x + HEEL_OFFSET_X, y + HEEL_OFFSET_Y);               // Draw heel
    }

    // Method drawToe(): Draws single toe in the window
    private void drawToe(double x, double y) {
        GOval singleToe = new GOval(x, y, TOE_WIDTH, TOE_HEIGHT);           // Create an oval for the toe
        singleToe.setFilled(true);                                          // Fill the oval with color
        singleToe.setFillColor(TOE_COLOR);                                  // Set the fill color
        add(singleToe);                                                     // Add an oval to the window
    }

    // Method drawHeel(): Draws single heel in the window
    private void drawHeel(double x, double y) {
        GOval singleHeel = new GOval(x, y, HEEL_WIDTH, HEEL_HEIGHT);        // Create an oval for the heel
        singleHeel.setFilled(true);                                         // Fill the oval with color
        singleHeel.setFillColor(HEEL_COLOR);                                // Set the fill color
        add(singleHeel);                                                    // Add an oval to the window
    }

    // Method main(): Create an object of the class and run the program
    public static void main(String[] args) {
        new Assignment2Part3().start(args);
    }
}