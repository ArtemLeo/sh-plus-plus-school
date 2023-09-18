package com.shpp.p2p.cs.aandriushchenko.assignment2;

import java.util.Scanner;

/*
  Problem # 1: Quadratic equation.
  Write a console program that will take 3 numbers of type double (a, b, c) as input and print the roots
  of a quadratic equation.
*/
public class Assignment2Part1 {
    // Declaration of static variables
    private static double a;
    private static double b;
    private static double c;

    /*
     * Method: main()
     * Precondition: You need to find the roots of a quadratic equation
     * Expected result: The roots of a quadratic equation are displayed in the console
     */
    public static void main(String[] args) {
        enterTheValuesOfCoefficients();
        findTheRootsOfQuadraticEquation();
    }

    /*
     * Method: enterTheValuesOfCoefficients()
     * Description: With the Scanner, we take input values and set them to static variables
     */
    private static void enterTheValuesOfCoefficients() {
        Scanner scanner = new Scanner(System.in);             // Create a Scanner object.
        System.out.println("Enter the coefficient a:");       // Ask the user to enter the coefficient "a"
        a = scanner.nextDouble();                             // Save the gotten value in the variable "a"
        System.out.println("Enter the coefficient b:");       // Ask the user to enter the coefficient "b"
        b = scanner.nextDouble();                             // Save the gotten value in the variable "b"
        System.out.println("Enter the coefficient c:");       // Ask the user to enter the coefficient "c"
        c = scanner.nextDouble();                             // Save the gotten value in the variable "c"
    }

    /*
     * Method: findTheRootsOfQuadraticEquation()
     * Description: We calculate the discriminant and based on the result we find the root of the quadratic equation
     */
    private static void findTheRootsOfQuadraticEquation() {
        double discriminant = b * b - 4 * a * c;                      // Calculate the discriminant
        if (a == 0) {                                                 // Check if the equation is linear
            System.out.println("This is not a quadratic equation");
        } else if (discriminant > 0) {                                // Check if the discriminant is positive
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);  // Calculate the first root
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);  // Calculate the second root
            System.out.println("There are two roots: " + root1 + " and " + root2);
        } else if (discriminant == 0) {                               // Check if the discriminant is zero
            double root = -b / (2 * a);                               // Calculate the root
            System.out.println("There is one root: " + root);
        } else {                                                      // In other cases the discriminant is negative
            System.out.println("There are no real roots!");
        }
    }
}

