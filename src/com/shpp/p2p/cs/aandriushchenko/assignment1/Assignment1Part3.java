package com.shpp.p2p.cs.aandriushchenko.assignment1;

/*
  Problem # 3 (Mazes: Midpoint Finding)
  Robot Karel should leave only one beeper in the center of the south lane.
*/
public class Assignment1Part3 extends SuperKarel {
    /*
     * Method: run()
     * Precondition: Karel starts in the south-west corner, looks east, he has a bag full of beepers.
     * Expected result: Karel leave only one beeper in the center of the south lane.
     */
    public void run() throws Exception {
        if (frontIsClear()) {    // If there are no walls ahead. It's a checking work on a 1x1 map.
            /*
             * Method: putBeepersInALine()
             * Precondition: Karel starts at the southwest corner and looks east.
             * Expected result: The south line of the map is filled with beepers.
             */
            putBeepersInALine();

            /*
             * Method: putCentralBeeper()
             * Precondition: The south line of the map is filled with beepers.
             * Expected result: There are two beepers in the center position of the south line.
             */
            putCentralBeeper();

            /*
             * Method: pickOneBeeperFromEachPosition()
             * Precondition: The south line is filled beepers, there are two beepers in the center position.
             * Expected result: There is only one beeper in the center position.
             */
            pickOneBeeperFromEachPosition();
        } else {
            putBeeper();   // Karel will put down one beeper. It's a checking work on a 1x1 map.
        }
    }

    // ********** Main method # 1: putBeepersInALine() ********** //
    private void putBeepersInALine() throws Exception {
        putBeeper();                         // Karel will put down one beeper.
        moveToWall();                        // If there are no walls ahead, Karel takes steps forward.
        putBeeper();                         // Karel will put down one beeper.
        turnAroundAndTakeOneStep();          // Karel makes two left turns, and takes one step forward.
        while (noBeepersPresent()) {         // If there are no beeps in the current position.
            move();                          // Karel takes one step forward.
            if (beepersPresent()) {          // If the beeps in the current position.
                turnAroundAndTakeOneStep();  // Karel makes two left turns, and takes one step forward.
                putBeeper();                 // Karel will put down one beeper.
                move();                      // Karel takes one step forward.
            }
        }
    }

    // ********** Main method # 2: putCentralBeeper() ********** //
    private void putCentralBeeper() throws Exception {
        turnAround();             // Karel makes two left turns.
        move();                   // Karel takes one step forward.
        putBeeper();              // Karel will put down one beeper.
    }

    // ********** Main method # 3: pickOneBeeperFromEachPosition() ********** //
    private void pickOneBeeperFromEachPosition() throws Exception {
        moveToWall();             // If there are no walls ahead, Karel takes steps forward.
        turnAround();             // Karel makes two left turns.
        moveAndPickBeeper();      // If there are no walls ahead, Karel will pick up beeper and takes a step forward.
    }

    /*
     * Method: moveAndPickBeeper()
     * Precondition: There shouldn't be a wall in front of Karel, but there should be beepers.
     * Expected result: Karel stands by the wall, he took a one beeper in each position.
     */
    private void moveAndPickBeeper() throws Exception {
        while (frontIsClear()) {               // If there are no walls ahead.
            pickBeeper();                      // Karel will pick up one beeper.
            move();                            // Karel takes one step forward.
        }
        pickBeeper();                          // Karel will pick up one beeper.
    }
}
