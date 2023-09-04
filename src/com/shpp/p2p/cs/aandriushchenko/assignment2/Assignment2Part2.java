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
    public static final int CIRCLE_DIAM = 50;                  // Diameter of circles.
    public static final int APPLICATION_WIDTH = 300;           // Width of the application window.
    public static final int APPLICATION_HEIGHT = 300;          // Height of the application window.
    public static final Color CIRCLES_COLOR = Color.BLACK;     // Color of circles.
    public static final Color RECT_COLOR = Color.WHITE;        // Color of the rectangle.

    public Assignment2Part2() {
        setTitle("Illusory contours");                        // Set the application window title.
        setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);       // Set the application window size.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       // Set window closing operation.
        add(new DrawingPanel());                              // Add a panel for drawing on the window.
    }

    static class DrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Получаем фактическую ширину панели
            double realCanvasWidth = getWidth();
            // Получаем фактическую высоту панели
            double realCanvasHeight = getHeight();

            int circle1X = 0;
            int circle1Y = 0;
            int circle2X = (int) (realCanvasWidth - CIRCLE_DIAM);
            int circle2Y = 0;
            int circle3X = (int) (realCanvasWidth - CIRCLE_DIAM);
            int circle3Y = (int) (realCanvasHeight - CIRCLE_DIAM);
            int circle4X = 0;
            int circle4Y = (int) (realCanvasHeight - CIRCLE_DIAM);

            g.setColor(CIRCLES_COLOR);
            // Рисуем первую окружность
            g.fillOval(circle1X, circle1Y, CIRCLE_DIAM, CIRCLE_DIAM);
            // Рисуем вторую окружность
            g.fillOval(circle2X, circle2Y, CIRCLE_DIAM, CIRCLE_DIAM);
            // Рисуем третью окружность
            g.fillOval(circle3X, circle3Y, CIRCLE_DIAM, CIRCLE_DIAM);
            // Рисуем четвертую окружность
            g.fillOval(circle4X, circle4Y, CIRCLE_DIAM, CIRCLE_DIAM);

            double rectWidth = realCanvasWidth - CIRCLE_DIAM;
            double rectHeight = realCanvasHeight - CIRCLE_DIAM;

            g.setColor(RECT_COLOR);
            // Рисуем прямоугольник
            g.fillRect(circle1X + CIRCLE_DIAM / 2, circle1Y + CIRCLE_DIAM / 2, (int) rectWidth, (int) rectHeight);
        }
    }

    public static void main(String[] args) {
        Assignment2Part2 app = new Assignment2Part2();
        // Делаем окно видимым
        app.setVisible(true);
    }
}

