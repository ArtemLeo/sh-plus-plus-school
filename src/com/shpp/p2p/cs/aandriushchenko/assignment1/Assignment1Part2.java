package com.shpp.p2p.cs.aandriushchenko.assignment1;

/*
  Problem # 2 (Mazes: Stone Mason)
  Robot Karel must build continuous columns of stones in rows one, five, nine ... - based on the map.
*/

public class Assignment1Part2 extends SuperKarel {
    /*
     * Method: run()
     * Precondition: Karel starts at the southwest corner and looks east, he has a bag full of beepers.
     * Expected result: Karel built all possible columns.
     */
    public void run() throws Exception {
        /*
         * Method buildColumnFromSouthToNorth()
         * Precondition: Karel starts at the southwest corner and looks east.
         * Expected result: Karel built the first column of beepers from south to north.
         */
        buildColumnFromSouthToNorth();

        /*
         * returnToSouthWallOfTheColumn()
         * Precondition: Karel is standing at the top of the first column, looking north.
         * Expected result: Karel is standing at the bottom of the first column, looking east.
         */
        returnToSouthWallOfTheColumn();

        // Cycle with condition give the code flexibility - without reference to the number of columns.
        while (frontIsClear()) {
            /*
             * moveToTheNextColumn()
             * Precondition: Karel is standing at the bottom of the current column, looking east.
             * Expected result: Karel is standing at the bottom of the next column, looking east.
             */
            moveToTheNextColumn();
            buildColumnFromSouthToNorth();
            returnToSouthWallOfTheColumn();
        }
    }

    // ********** Main method # 1: buildColumnFromSouthToNorth() ********** //
    private void buildColumnFromSouthToNorth() throws Exception {
        ifNoBeepersPresentPutBeepers();       // If no beepers present, Karel will put down one beeper.
        turnLeft();                           // Karel makes one left turn.
        putBeepersAndMoveIfFrontIsClear();    // Will move forward, put beepers were no beepers, if no walls ahead.
    }

    // ********** Main method # 2: returnToSouthWallOfTheColumn() ********** //
    private void returnToSouthWallOfTheColumn() throws Exception {
        turnAround();                         // Karel makes two left turns.
        putBeepersAndMoveIfFrontIsClear();    // Will move forward, put beepers were no beepers, if no walls ahead.
        turnLeft();                           // Karel makes one left turn.
    }

    // ********** Main method # 3: moveToTheNextColumn() ********** //
    private void moveToTheNextColumn() throws Exception {
        for (int i = 0; i < 4; i++) {    // Repeat the operation in a loop four times.
            move();                      // Karel takes one step forward.
        }
    }

    /*
     * Method: putBeepersAndMoveIfFrontIsClear()
     * Precondition: Karel has beepers in his bag.
     * Expected result: Karel Will move forward, put beepers were no beepers, if no walls ahead.
     */
    private void putBeepersAndMoveIfFrontIsClear() throws Exception {
        while (frontIsClear()) {             // If there are no walls ahead.
            ifNoBeepersPresentPutBeepers();  // Karel will put down one beeper, if no beepers present.
            move();                          // Karel takes one step forward.
        }
    }

    /*
     * Method: ifNoBeepersPresentPutBeepers()
     * Precondition: Karel has beepers in his bag.
     * Expected result: Karel will put beepers in places where there are no beepers.
     */
    private void ifNoBeepersPresentPutBeepers() throws Exception {
        if (noBeepersPresent()) {          // If no beepers present.
            putBeeper();                   // Karel will put down one beeper.
        }
    }
}
