package com.shpp.p2p.cs.aandriushchenko.assignment2;

import acm.graphics.*;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
  Task # 6: Caterpillar
  Draw a caterpillar with these conditions:
   - The ovals must put one on top of the other
   - The color of the center and the color of the border of the oval must be different
   - You may change the quantity of segments of the caterpillar.
*/
public class Assignment2Part6 extends WindowProgram {

    // Initialization of static constants:
    private static final int OVALS_QUANTITY = 6;                                // Quantity of ovals in the caterpillar
    private static final double OVAL_DIAMETER = 180;                            // Diameter of the oval
    private static final double OVAL_BORDER = 0.01 * OVAL_DIAMETER;             // Width of the oval border

    // Constants OFFSET_BETWEEN_OVALS - the distance between ovals in pair (two ovals - bottom and top)
    private static final double OFFSET_BETWEEN_OVALS_X = OVAL_DIAMETER * 0.65;  // Offset in the X between the ovals in the pair
    private static final double OFFSET_BETWEEN_OVALS_Y = OVAL_DIAMETER * 0.35;  // Offset in the Y between the ovals in the pair

    // Constants OFFSET_BETWEEN_PAIR - the distance between pairs of ovals
    private static final double OFFSET_BETWEEN_PAIR_X = OVAL_DIAMETER * 0.5;     // Offset in the X between pairs of ovals
    private static final double OFFSET_BETWEEN_PAIR_Y = -OFFSET_BETWEEN_OVALS_Y; // Offset in the Y between pairs of ovals

    // Constants of first oval position in caterpillar:
    private static final double START_X = 0;                           // Starting position in the X coordinates
    private static final double START_Y = OFFSET_BETWEEN_OVALS_Y;      // Starting position in the Y coordinates

    // Constants for oval colors:
    private static final Color OVAL_COLOR = new Color(135, 150, 20, 255);  // Color of the oval
    private static final Color BORDER_COLOR = new Color(10, 10, 10);          // Color of the oval border


    // Method run(): Set the name of the graphic window and build the caterpillar
    public void run() {
        setTitle("Caterpillar");                                       // Setting the window header to "Caterpillar"
        buildCaterpillar();                                            // Call the method to build the caterpillar
    }

    // Method buildCaterpillar(): The method for building a caterpillar
    private void buildCaterpillar() {
        double currentPositionX = START_X;                             // Current position in the X
        double currentPositionY = START_Y;                             // Current position in the Y

        // Update the current X or Y positions based on the iteration evenness:
        for (int i = 1; i <= OVALS_QUANTITY; i++) {                    // Cycle to build ovals in the caterpillar
            buildSingleOval(currentPositionX, currentPositionY);       // Call the method to build one oval
            currentPositionX += (i % 2 == 0) ? OFFSET_BETWEEN_PAIR_X : OFFSET_BETWEEN_OVALS_X;
            currentPositionY -= (i % 2 == 0) ? OFFSET_BETWEEN_PAIR_Y : OFFSET_BETWEEN_OVALS_Y;
        }
    }

    // Method buildSingleOval(): Method for drawing a single oval
    private void buildSingleOval(double x, double y) {
        // Create an oval border:
        GOval borderOval = new GOval(x, y, OVAL_DIAMETER, OVAL_DIAMETER);
        borderOval.setFilled(true);                             // Set oval border fill
        borderOval.setFillColor(BORDER_COLOR);                  // Set the fill color of the oval border/body
        add(borderOval);                                        // Add oval border to the window

        // Create an oval body:
        GOval bodyOval = new GOval(x + OVAL_BORDER, y + OVAL_BORDER, OVAL_DIAMETER - 2 * OVAL_BORDER, OVAL_DIAMETER - 2 * OVAL_BORDER);
        bodyOval.setFilled(true);                               // Set oval border fill
        bodyOval.setFillColor(OVAL_COLOR);                      // Set the fill color of the oval border/body
        add(bodyOval);                                          // Add oval body to the window
    }
}
