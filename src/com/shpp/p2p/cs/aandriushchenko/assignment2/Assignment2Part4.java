package com.shpp.p2p.cs.aandriushchenko.assignment2;

import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;

/*
  Problem # 4: Tricolor flag
  Write a program that draws a flag of three colored stripes of equal size
*/
public class Assignment2Part4 extends GraphicsProgram {

    // Initialization of static constants.
    private static final int FLAG_WIDTH = 300;                                      // Flag width
    private static final int FLAG_HEIGHT = 200;                                     // Flag height
    private static final Color BLUE_COLOR = new Color(0, 35, 149);        // Blue color
    private static final Color WHITE_COLOR = new Color(255, 255, 255);    // White color
    private static final Color RED_COLOR = new Color(206, 17, 38);        // Red color
    private static final Color BLACK_COLOR = new Color(9, 9, 9);


    // Method run(): Get the size of the window, position the flag stripes, and add an inscription
    @Override
    public void run() {
        setTitle("Tricolor Flag");                               // Setting the window header to "Tricolor Flag"
        int windowWidth = getWidth();                            // Get window width
        int windowHeight = getHeight();                          // Get window height

        // Creating the stripes of the flag:
        double stripeWidth = FLAG_WIDTH / 3.0;                   // Calculate the width of each strip

        for (int i = 0; i < 3; i++) {                            // Cycle to add flag stripes
            GRect stripe = new GRect(stripeWidth, FLAG_HEIGHT);  // Create a strip of "i" color
            stripe.setColor(BLACK_COLOR);                        // Set the color of the border of the strip
            stripe.setFilled(true);                              // Fill the strip with color
            if (i == 0)                                          // Add a blueStripe to the window
                stripe.setFillColor(BLUE_COLOR);                 // Set the fill color of the strip
            else if (i == 1)                                     // Add and move strip to the width of the blueStripe
                stripe.setFillColor(WHITE_COLOR);                // Set the fill color of the strip
            else                                                 // Add and move strip to width of blue and whiteStripe
                stripe.setFillColor(RED_COLOR);                  // Set the fill color of the strip

            // Find coordinates to center the flag (get X and Y), add and move strip to the width of previous strips
            add(stripe, (windowWidth - FLAG_WIDTH) / 2 + i * stripeWidth, (windowHeight - FLAG_HEIGHT) / 2);
        }

        // Add an inscription "Flag of France":
        GLabel label = new GLabel("Flag of France");                    // Create an inscription
        label.setFont(new Font("SansSerif", Font.BOLD, 18));   // Set the font of the inscription
        double labelX = windowWidth - label.getWidth() - 10;               // Get the X to place in the right corner
        double labelY = windowHeight - 10;                                 // Get the Y to place in the right corner
        add(label, labelX, labelY);                                        // Add an inscription to the window
    }

    // Method main(): Create an object of the class and run the program
    public static void main(String[] args) {
        new Assignment2Part4().start();
    }
}



