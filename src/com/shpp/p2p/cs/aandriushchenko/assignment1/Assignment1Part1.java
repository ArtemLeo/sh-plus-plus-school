package com.shpp.p2p.cs.aandriushchenko.assignment1;

/*
 * Problem # 1 (Mazes: Collect Newspaper)
 * The robot Karel needs to pick up a newspaper (beeper) that is placed on the doorstep of his square house.
 */

public class Assignment1Part1 extends SuperKarel{
    /*
     * Method: run()
     * Precondition: Karel starts his movement in the north-west corner of his house, looks east.
     * Expected result: After picking up the newspaper, he must return to the starting position.
     */
    public void run() throws Exception {
        /*
         * Method: goGetNewspaper()
         * Precondition: Karel starts his movement in the north-west corner of his house, looks east.
         * Expected result: Karel found the newspaper.
         */
        goGetNewspaper();

        /*
         * Method: pickNewspaper()
         * Precondition: Karel is in the same location as the newspaper.
         * Expected result: Karel picks up the newspaper.
         */
        pickNewspaper();

        /*
         * Method: returnToStartPosition()
         * Precondition: The newspaper is in Karel's bag.
         * Expected result: Karel return to the starting position.
         */
        returnToStartPosition();
    }

    // ********** Main method # 1: goGetNewspaper() ********** //
    private void goGetNewspaper() throws Exception {
        turnRight();                                  // Karel makes three left turns.
        move();                                       // Karel takes one step forward.
        turnLeft();                                   // Karel makes one left turn.
        while (noBeepersPresent()) {                  // Karel moves forward if there are no beepers in the current position.
            move();                                   // Karel takes one step forward.
        }
    }

    // ********** Main method # 2: pickNewspaper() ********** //
    private void pickNewspaper() throws Exception {
        pickBeeper();                                 // Karel puts the beeper in the bag.
    }

    // ********** Main method # 3: returnToStartPosition() ********** //
    private void returnToStartPosition() throws Exception {
        turnAround();                                 // Karel makes two left turns.
        while (frontIsClear()) {                      // Karel moves forward if there is no wall in the current position ahead.
            move();                                   // Karel takes one step forward.
        }
        turnRight();                                  // Karel makes three left turns.
        move();                                       // Karel takes one step forward.
    }
}
