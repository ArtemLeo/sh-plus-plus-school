package com.shpp.p2p.cs.aandriushchenko.assignment2;

import acm.graphics.*;
import acm.program.*;

import java.awt.*;

/*
  Problem # 4: Tricolor flag
  Write a program that draws a flag of three colored stripes of equal size
*/
public class Assignment2Part4 extends GraphicsProgram {

    // Initialization of static constants.
    private static final int FLAG_WIDTH = 300;                                    // Flag width
    private static final int FLAG_HEIGHT = 200;                                   // Flag height
    private static final Color BLUE_COLOR = new Color(0, 35, 149);      // Blue color
    private static final Color WHITE_COLOR = new Color(255, 255, 255);  // White color
    private static final Color RED_COLOR = new Color(206, 17, 38);      // Red color
    private static final Color BLACK_COLOR = new Color(9, 9, 9);        // Black color

    // Method run(): Get the size of the window, position the flag stripes, and add an inscription
    public void run() {
        int windowWidth = getWidth();                            // Get window width
        int windowHeight = getHeight();                          // Get window height

        // Creating the stripes of the flag.
        double stripeWidth = FLAG_WIDTH / 3.0;                   // Calculate the width of each strip

        GRect blueStripe = new GRect(stripeWidth, FLAG_HEIGHT);  // Create a strip of blue color
        blueStripe.setColor(BLACK_COLOR);                        // Set the color of the border of the strip
        blueStripe.setFilled(true);                              // Fill the strip with color
        blueStripe.setFillColor(BLUE_COLOR);                     // Set the fill color of the strip
        add(blueStripe);                                         // Add a strip to the window

        GRect whiteStripe = new GRect(stripeWidth, FLAG_HEIGHT); // Create a strip of white color
        whiteStripe.setColor(BLACK_COLOR);                       // Set the color of the border of the strip
        whiteStripe.setFilled(true);                             // Fill the strip with color
        whiteStripe.setFillColor(WHITE_COLOR);                   // Set the fill color of the strip
        add(whiteStripe);                                        // Add a strip to the window

        GRect redStripe = new GRect(stripeWidth, FLAG_HEIGHT);   // Create a strip of red color
        redStripe.setColor(BLACK_COLOR);                         // Set the color of the border of the strip
        redStripe.setFilled(true);                               // Fill the strip with color
        redStripe.setFillColor(RED_COLOR);                       // Set the fill color of the strip
        add(redStripe);                                          // Add a strip to the window

        // Find coordinates for centering the flag.
        double x = (windowWidth - FLAG_WIDTH) / 2.0;       // Get coordinate X
        double y = (windowHeight - FLAG_HEIGHT) / 2.0;     // Get coordinate Y

        // Position the stripes in the window.
        blueStripe.setLocation(x, y);                      // Add a blueStripe to the window
        whiteStripe.setLocation(x + stripeWidth, y);    // Add and move strip to the width of the blueStripe
        redStripe.setLocation(x + 2 * stripeWidth, y);  // Add and move strip to the width of the blue and whiteStripe

        // Add an inscription "Flag of France".
        GLabel label = new GLabel("Flag of France");                   // Create an inscription
        label.setFont(new Font("SansSerif", Font.BOLD, 18));   // Set the font of the inscription
        double labelX = windowWidth - label.getWidth() - 10;               // Get the X to place in the right corner
        double labelY = windowHeight - 10;                                 // Get the Y to place in the right corner
        add(label, labelX, labelY);                                        // Add an inscription to the window
    }

    // Method main(): Running the application
    public static void main(String[] args) {
        new Assignment2Part4().start();     // Create an object of the class and run the program
    }
}



