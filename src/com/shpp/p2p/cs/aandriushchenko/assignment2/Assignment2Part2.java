package com.shpp.p2p.cs.aandriushchenko.assignment2;

import java.awt.Color;        // Import a class to work with colors.
import java.awt.Graphics;     // Import a class for drawing graphics.
import javax.swing.JFrame;    // Import a class to create a graphical window (main application window).
import javax.swing.JPanel;    // Import a class to create a drawing panel (container for application components).

/*
  Problem # 2: Illusory contours.
  Create a white rectangle on top of four black circles.
*/
public class Assignment2Part2 extends JFrame {

    // Initialization of static constants.
    public static final int CIRCLE_DIAM = 100;                // Diameter of circles.
    public static final int APPLICATION_WIDTH = 300;          // Width of the application window.
    public static final int APPLICATION_HEIGHT = 300;         // Height of the application window.
    public static final Color CIRCLES_COLOR = Color.BLACK;    // Color of circles.
    public static final Color RECT_COLOR = Color.WHITE;       // Color of the rectangle.

    public Assignment2Part2() {                               // Create a constructor.
        setTitle("Illusory contours");                        // Set the application window title.
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);       // Set the application window size.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // Set window closing operation.
        add(new DrawingPanel());                              // Add a panel for drawing on the window.
    }

    static class DrawingPanel extends JPanel {
        @Override                                      // Override the method of the JPanel superclass.
        protected void paintComponent(Graphics g) {    // Using the Graphics object, which is a canvas for drawing.
            super.paintComponent(g);                   // Call the method of the superclass to draw the panel.
            double realCanvasWidth = getWidth();       // Get width of the panel, on which the graphic is drawn.
            double realCanvasHeight = getHeight();     // Get height of the panel, on which the graphic is drawn.

            // Coordinates of the top of circle 1 (upper left corner)
            int circle1X = 0; // X-coordinate of circle top 1 (left border of the panel)
            int circle1Y = 0; // Y-coordinate of the top of circle 1 (upper border of the panel)

            // Coordinates of the top of circle 2 (upper right corner)
            int circle2X = (int) (realCanvasWidth - CIRCLE_DIAM); // X of circle top 2 (right panel border minus circle diameter)
            int circle2Y = 0; // Y-coordinate of the top of circle 2 (upper border of the panel)

            // Coordinates of the top of circle 3 (bottom right corner)
            int circle3X = (int) (realCanvasWidth - CIRCLE_DIAM); // X of the circle top 3 (right border minus circle diameter)
            int circle3Y = (int) (realCanvasHeight - CIRCLE_DIAM); // Y of the circle vertex 3 (bottom border minus the circle diameter)

            // Coordinates of the top of circle 4 (bottom left corner)
            int circle4X = 0; // X-coordinate of the top of circle 4 (left border of the panel)
            int circle4Y = (int) (realCanvasHeight - CIRCLE_DIAM); // Y of the circle top 4 (bottom border minus the circle diameter)

            // Draw circles.
            g.setColor(CIRCLES_COLOR);                                     // Sets the color for the circles.
            g.fillOval(circle1X, circle1Y, CIRCLE_DIAM, CIRCLE_DIAM);      // Draw the first circle.
            g.fillOval(circle2X, circle2Y, CIRCLE_DIAM, CIRCLE_DIAM);      // Draw the second circle.
            g.fillOval(circle3X, circle3Y, CIRCLE_DIAM, CIRCLE_DIAM);      // Draw the third circle.
            g.fillOval(circle4X, circle4Y, CIRCLE_DIAM, CIRCLE_DIAM);      // Draw the forth circle.

            // Calculate the width and height of the rectangle.
            double rectWidth = realCanvasWidth - CIRCLE_DIAM;
            double rectHeight = realCanvasHeight - CIRCLE_DIAM;

            // Draw a rectangle.
            g.setColor(RECT_COLOR);                                        // Sets the color for the rectangle.
            g.fillRect(circle1X + CIRCLE_DIAM / 2, circle1Y + CIRCLE_DIAM / 2, (int) rectWidth, (int) rectHeight);
        }
    }

    public static void main(String[] args) {
        Assignment2Part2 illusoryContours = new Assignment2Part2();        // Create a new object of class.
        illusoryContours.setVisible(true);                                 // Make the window visible.
    }
}

