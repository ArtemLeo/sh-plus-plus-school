package com.shpp.p2p.cs.aandriushchenko.assignment2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
  Problem # 2: Illusory contours.
  Create a white rectangle on top of four black circles.
*/
public class Assignment2Part2ext extends JFrame {

    // Initialization of static constants
    public static final int APPLICATION_WIDTH = 300;          // Width of the application window
    public static final int APPLICATION_HEIGHT = 300;         // Height of the application window
    public static final int CIRCLE_DIAM = 100;                // Diameter of circles
    public static final Color CIRCLES_COLOR = Color.BLACK;    // Color of circles
    public static final Color RECT_COLOR = Color.WHITE;       // Color of the rectangle

    // Constructor Assignment2Part2(): Set the title and size of the window, add a panel for drawing
    public Assignment2Part2ext() {                            // Create a constructor
        setTitle("Illusory contours");                        // Set the application window title
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);       // Set the application window size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // Set window closing operation
        add(new RunDrawingPanel());                           // Add a panel for drawing on the window
    }

    // Class RunDrawingPanel: Set the size of the drawing panel, draw circles and a rectangle
    static class RunDrawingPanel extends JPanel {
        @Override                                        // Override the method of the JPanel superclass
        protected void paintComponent(Graphics g) {      // Using the Graphics object, which is a canvas for drawing
            super.paintComponent(g);                     // Call the method of the superclass to draw the panel
            double realCanvasWidth = getWidth();         // Get width of the panel, on which the graphic is drawn
            double realCanvasHeight = getHeight();       // Get height of the panel, on which the graphic is drawn

            // Coordinates of the top of circle 1 (upper left corner)
            int circle1X = 0;                                         // X-coordinate: left border of the panel
            int circle1Y = 0;                                         // Y-coordinate: upper border of the panel

            // Coordinates of the top of circle 2 (upper right corner)
            int circle2X = (int) (realCanvasWidth - CIRCLE_DIAM);     // X: right panel border minus circle diameter
            int circle2Y = 0;                                         // Y-coordinate: upper border of the panel

            // Coordinates of the top of circle 3 (bottom right corner)
            int circle3X = (int) (realCanvasWidth - CIRCLE_DIAM);     // X: right border minus circle diameter
            int circle3Y = (int) (realCanvasHeight - CIRCLE_DIAM);    // Y: bottom border minus the circle diameter

            // Coordinates of the top of circle 4 (bottom left corner)
            int circle4X = 0;                                         // X-coordinate: left border of the panel
            int circle4Y = (int) (realCanvasHeight - CIRCLE_DIAM);    // Y: bottom border minus the circle diameter

            // Draw circles
            g.setColor(CIRCLES_COLOR);                                     // Sets the color for the circles
            g.fillOval(circle1X, circle1Y, CIRCLE_DIAM, CIRCLE_DIAM);      // Draw the first circle
            g.fillOval(circle2X, circle2Y, CIRCLE_DIAM, CIRCLE_DIAM);      // Draw the second circle
            g.fillOval(circle3X, circle3Y, CIRCLE_DIAM, CIRCLE_DIAM);      // Draw the third circle
            g.fillOval(circle4X, circle4Y, CIRCLE_DIAM, CIRCLE_DIAM);      // Draw the forth circle

            // Calculate the width and height of the rectangle
            double rectWidth = realCanvasWidth - CIRCLE_DIAM;
            double rectHeight = realCanvasHeight - CIRCLE_DIAM;

            // Draw a rectangle
            g.setColor(RECT_COLOR);  // Sets the color for the rectangle
            g.fillRect(circle1X + CIRCLE_DIAM / 2,
                    circle1Y + CIRCLE_DIAM / 2, (int) rectWidth, (int) rectHeight);
        }
    }

    // Method main(): Create an object of the class and run the program
    public static void main(String[] args) {
        Assignment2Part2ext illusoryContours = new Assignment2Part2ext();    // Create a new object of class
        illusoryContours.setVisible(true);                                   // Make the window visible
    }
}

