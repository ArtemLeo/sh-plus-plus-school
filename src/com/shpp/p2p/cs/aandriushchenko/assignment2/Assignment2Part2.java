package com.shpp.p2p.cs.aandriushchenko.assignment2;

import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Assignment2Part2 extends GraphicsProgram {

    // Initialization of static constants
    public static final int APPLICATION_WIDTH = 300;          // Width of the application window
    public static final int APPLICATION_HEIGHT = 300;         // Height of the application window
    public static final int CIRCLE_DIAM = 100;                // Diameter of circles
    public static final Color CIRCLES_COLOR = Color.BLACK;    // Color of circles
    public static final Color RECT_COLOR = Color.WHITE;       // Color of the rectangle

    public void run() {
        setTitle("IllusoryContours");                      // Setting the window header to "IllusoryContours"
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);    // Set window size
        double canvasWidth = getWidth();                   // Get width of the panel, on which the graphic is drawn
        double canvasHeight = getHeight();                 // Get height of the panel, on which the graphic is drawn

        // Coordinates for the circles:
        int[][] circleCoordinates = {
                {0, 0},                                                                   // Circle 1: Upper left
                {(int) (canvasWidth - CIRCLE_DIAM), 0},                                   // Circle 2: Upper right
                {(int) (canvasWidth - CIRCLE_DIAM), (int) (canvasHeight - CIRCLE_DIAM)},  // Circle 3: Bottom right
                {0, (int) (canvasHeight - CIRCLE_DIAM)}                                   // Circle 4: Bottom left
        };

        for (int[] coords : circleCoordinates) {
            GOval circle = new GOval(coords[0], coords[1], CIRCLE_DIAM, CIRCLE_DIAM);     // Create circles
            circle.setFilled(true);                                                       // Fill in the circle
            circle.setColor(CIRCLES_COLOR);                                               // Set circle color
            add(circle);                                                                  // Add a circle to display
        }

        // Draw the rectangle:
        GRect rectangle = new GRect(CIRCLE_DIAM / 2,           // Create a rectangle
                CIRCLE_DIAM / 2,
                canvasWidth - CIRCLE_DIAM,
                canvasHeight - CIRCLE_DIAM);
        rectangle.setFilled(true);                                // Fill in the rectangle
        rectangle.setColor(RECT_COLOR);                           // Set rectangle color
        add(rectangle);                                           // Add a rectangle to display
    }

    // Method main(): Create an object of the class and run the program
    public static void main(String[] args) {
        new Assignment2Part2().start();
    }
}
