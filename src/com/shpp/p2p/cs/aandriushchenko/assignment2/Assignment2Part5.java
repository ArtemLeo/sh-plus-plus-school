package com.shpp.p2p.cs.aandriushchenko.assignment2;

import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;

/*
  Problem # 5: Boxes illusion
  Draw a matrix of black boxes, divided by "streets"
*/
public class Assignment2Part5 extends GraphicsProgram {

    // Initialization of static constants
    private static final int QUANTITY_ROWS = 5;                // Quantity of rows
    private static final int QUANTITY_COLUMNS = 6;             // Quantity of columns
    private static final double BOX_SIZE = 40;                 // The size of each box (width and height)
    private static final double DISTANCE_BETWEEN_BOXES = 10;   // Distance between boxes horizontally and vertically
    private static final Color BOXES_COLOR = Color.BLACK;      // Color of boxes

    @Override
    // Method run(): Set name of the graphic window, calculate the width and height of the illusion, create a cell
    public void run() {
        setTitle("Boxes illusion");                                        // Set the name of the graphic window
        double illusionWidth = QUANTITY_COLUMNS * (BOX_SIZE + DISTANCE_BETWEEN_BOXES); // Calculate width of illusion
        double illusionHeight = QUANTITY_ROWS * (BOX_SIZE + DISTANCE_BETWEEN_BOXES);   // Calculate height of illusion
        double widthCenter = (getWidth() - illusionWidth) / 2;             // Center the illusion on the window width
        double heightCenter = (getHeight() - illusionHeight) / 2;          // Center the illusion on the window height

        // Using loops "for", to create an illusion:
        for (int i = 0; i < QUANTITY_ROWS; i++) {                          // Loop by rows (vertical)
            for (int j = 0; j < QUANTITY_COLUMNS; j++) {                   // Loop by columns (horizontal)
                double singleCellWidth = widthCenter + j * (BOX_SIZE + DISTANCE_BETWEEN_BOXES);   // X for current cell
                double singleCellHeight = heightCenter + i * (BOX_SIZE + DISTANCE_BETWEEN_BOXES); // Y for current cell

                // Create current cell:
                GRect myBox = new GRect(singleCellWidth, singleCellHeight, BOX_SIZE, BOX_SIZE);
                myBox.setFilled(true);                                    // Set the cell fill
                myBox.setColor(BOXES_COLOR);                              // Set the color for the cell
                add(myBox);                                               // Add cell to the window
            }
        }
    }

    // Method main(): Create an object of the class and run the program
    public static void main(String[] args) {
        new Assignment2Part5().start();
    }
}
