package com.shpp.p2p.cs.aandriushchenko.assignment1;

/*
  Problem # 4 (Mazes: Chess)
  Robot Karel must create a "chessboard", using beepers in a rectangular empty area.
*/
public class Assignment1Part4 extends SuperKarel {
    /*
     * Method: run()
     * Precondition: Karel starts from the starting position - from the south-west corner, looking east.
     * Result: Karel created a rectangular chessboard.
     */
    public void run() throws Exception {
        /*
         * Method: cleanAreaOfBeepers()
         * Precondition: Karel starts at the south-west corner and looks east.
         * Expected result: All lines are empty.
         */
        cleanAllLinesOfBeepers();

        /*
         * Method: returnToStartPosition()
         * Precondition: All lines are empty.
         * Expected result: Karel returns to the starting position - the south-west corner, looking east.
         */
        returnToStartPosition();

        /*
         * Method: buildChessBoard()
         * Precondition: Karel starts from the starting position - from the south-west corner, looking east.
         * Expected result: Karel created a chessboard using beepers.
         */
        createChessBoard();
    }

    // ********** Main method # 1: cleanAreaOfBeepers() ********** //
    public void cleanAllLinesOfBeepers() throws Exception {
        clearTheCurrentLine();           // Pick up all beepers on the current line.
        returnToStartOfLine();           // Return to the beginning of the current line.
        while (frontIsClear()) {         // If there are no walls ahead.
            moveToTheNextLine();         // Move to the next line.
            clearTheCurrentLine();       // Pick up all beepers on the current line.
            returnToStartOfLine();       // Return to the beginning of the current line.
        }
    }

    /*
     * Method: clearTheCurrentLine()
     * Precondition: Karel is at the beginning of the current line.
     * Expected result: Karel picks up all the beeps in the current line.
     */
    private void clearTheCurrentLine() throws Exception {
        while (frontIsClear()) {             // If there are no walls ahead.
            pickBeeperIfBeepersPresent();    // Pick beeper, if there are beepers in the way.
            move();                          // Karel takes one step forward.
        }
        if (frontIsBlocked()) {              // If there is a wall ahead.
            pickBeeperIfBeepersPresent();    // Pick beeper, if there are beepers in the way.
        }
    }

    /*
     * Method: pickBeeperIfBeepersPresent()
     * Precondition: Karel has beepers on the way.
     * Expected result: Karel picked up every beeper in his way.
     */
    private void pickBeeperIfBeepersPresent() throws Exception {
        while (beepersPresent()) {            // If there are beepers in the way.
            pickBeeper();                     // Karel will pick up one beeper.
        }
    }

    /*
     * Method: returnToStartOfLine()
     * Precondition: Karel needs to return to the west wall of the current line
     * Expected result: Karel is at the west wall of the current line.
     */
    private void returnToStartOfLine() throws Exception {
        turnAround();                         // Karel makes two left turns.
        moveToWall();                         // If there are no walls ahead, Karel takes steps forward.
        turnRight();                          // Karel makes three left turns.
    }

    /*
     * Method: moveToTheNextLine()
     * Precondition: Karel needs to move to the next line.
     * Expected result: Karel moves on to the next line above.
     */
    private void moveToTheNextLine() throws Exception {
        move();                               // Karel takes one step forward.
        turnRight();                          // Karel makes three left turns.
    }

    // ********** Main method # 2: returnToStartPositions() ********** //
    private void returnToStartPosition() throws Exception {
        turnAround();                          // Karel makes two left turns.
        moveToWall();                          // If there are no walls ahead, Karel takes steps forward.
        turnLeft();                            // Karel makes one left turn.
    }

    // ********** Main method # 3: createChessBoard() ********** //
    private void createChessBoard() throws Exception {
        putBeeper();                           // Karel will put down one beeper.
        buildLineOfChessBoard();               // Karel fills the line with beepers across one cell.
        returnToStartOfCurrentLine();          // Karel returns to the west wall of the current line.
        while (frontIsClear()) {               // If there are no walls ahead.
            moveAndBuildNextLine();            // Karel moves to the next line and fills it with beepers across one cell.
            buildLineOfChessBoard();           // Karel fills the line with beepers across one cell.
            returnToStartOfCurrentLine();      // Karel returns to the west wall of the current line.
        }
    }

    /*
     * Method: buildLineOfChessBoard()
     * Precondition: Karel is at the beginning of the current line, looking east.
     * Expected result: Karel fills the line with beepers across one cell.
     */
    private void buildLineOfChessBoard() throws Exception {
        while (frontIsClear()) {        // If there are no walls ahead.
            move();
            if (frontIsClear()) {       // If there are no walls ahead.
                move();                 // Karel takes one step forward.
                putBeeper();            // Karel will put down one beeper.
            }
        }
    }

    /*
     * Method: returnToStartOfCurrentLine()
     * Precondition: Karel needs to return to the west wall of the current row.
     * Expected result: Karel is located at the west wall of the current row.
     */
    private void returnToStartOfCurrentLine() throws Exception {
        turnAround();                      // Karel makes two left turns.
        moveToWall();                      // If there are no walls ahead, Karel takes steps forward.
        turnRight();                       // Karel makes three left turns.
    }

    /*
     * Method: moveAndBuildNextLine()
     * Precondition: Karel must go to the next line and fill it in chess style to the previous line.
     * Expected result: Karel fills in the current line in chess style to the previous line.
     */
    private void moveAndBuildNextLine() throws Exception {
        if (frontIsClear() && beepersPresent()) {           // If there are no walls ahead and the beeper is in the current position.
            move();                                         // Karel takes one step forward.
            turnRight();                                    // Karel makes three left turns.
            if (frontIsClear()) {
                move();                                         // Karel takes one step forward.
                putBeeper();                                    // Karel will put down one beeper.
                buildLineOfChessBoard();                        // Karel fills the line with beepers across one cell.
            }
        } else if (frontIsClear() && noBeepersPresent()) {  // If there are no walls ahead and no beepers at the current position.
            move();                                         // Karel takes one step forward.
            turnRight();                                    // Karel makes three left turns.
            putBeeper();                                    // Karel will put down one beeper.
            buildLineOfChessBoard();                        // Karel fills the line with beepers across one cell.
        }
    }
}




