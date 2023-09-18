package com.shpp.p2p.cs.aandriushchenko.assignment2;

import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;

/*
  Problem # 5: Boxes illusion
  Write a program that draws a flag of three colored stripes of equal size
*/
public class Assignment2Part5 extends GraphicsProgram {

    // Initialization of static constants
    private static final int NUM_ROWS = 5;                   // Quantity of rows
    private static final int NUM_COLS = 6;                   // Quantity of columns
    private static final double BOX_SIZE = 40;               // The size of each square (width and height)
    private static final double BOX_SPACING = 10;            // Distance between boxes horizontally and vertically
    private static final Color BOXES_COLOR = Color.BLACK;    // Color of boxes

    // Method run(): Set name of the graphic window, calculate the width and height of the illusion, create a cell
    public void run() {
        setTitle("Boxes illusion");                                   // Set the name of the graphic window
        double illusionWidth = NUM_COLS * (BOX_SIZE + BOX_SPACING);   // Calculate the width of the illusion
        double illusionHeight = NUM_ROWS * (BOX_SIZE + BOX_SPACING);  // Calculate the height of the illusion
        double widthCenter = (getWidth() - illusionWidth) / 2;        // Center the illusion on the window width
        double heightCenter = (getHeight() - illusionHeight) / 2;     // Center the illusion on the window height

        // Using loops "for", to create an illusion
        for (int i = 0; i < NUM_ROWS; i++) {                          // Loop by rows (vertical)
            for (int j = 0; j < NUM_COLS; j++) {                      // Loop by columns (horizontal)
                double singleCellWidth = widthCenter + j * (BOX_SIZE + BOX_SPACING);   // X-coordinate for current cell
                double singleCellHeight = heightCenter + i * (BOX_SIZE + BOX_SPACING); // Y-coordinate for current cell
                buildSingleCell(singleCellWidth, singleCellHeight);   // Create and add a cell to the illusion
            }
        }
    }

    // Method buildSingleCell: Create a single illusion cell
    private void buildSingleCell(double x, double y) {
        GRect myBox = new GRect(x, y, BOX_SIZE, BOX_SIZE);    // Create current cell
        myBox.setFilled(true);                                // Set the cell fill
        myBox.setColor(BOXES_COLOR);                          // Set the color for the cell
        add(myBox);                                           // Add a cell to the illusion
    }

    // Method main(): Running the application
    public static void main(String[] args) {
        new Assignment2Part5().start();   // Create an object of the class and run the program
    }
}
