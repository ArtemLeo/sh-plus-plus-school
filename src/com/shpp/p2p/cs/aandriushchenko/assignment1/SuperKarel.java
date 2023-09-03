package com.shpp.p2p.cs.aandriushchenko.assignment1;

import com.shpp.karel.KarelTheRobot;

public class SuperKarel extends KarelTheRobot {

    /*
     * Method: turnRight()
     * Precondition: Karel needs to turn right.
     * Expected result: Karel makes three left turns = one turn right.
     */
    public void turnRight() throws Exception {
        for (int i = 0; i < 3; i++) {  // The operation inside the cycle is repeated three times.
            turnLeft();                // Karel makes one left turn.
        }
    }

    /*
     * Method: turnAround()
     * Precondition: Karel needs to turn 180 degrees.
     * Expected result: Karel makes two left turns = turn 180 degrees.
     */
    public void turnAround() throws Exception {
        turnLeft();                   // Karel makes one left turn.
        turnLeft();                   // Karel makes one left turn.
    }

    /*
     * Method: turnAroundAndTakeOneStep()
     * Precondition: Karel needs to turn 180 degrees.
     * Expected result: Karel makes two left turns = turn 180 degrees.
     */
    public void turnAroundAndTakeOneStep() throws Exception {
        turnLeft();                   // Karel makes one left turn.
        turnLeft();                   // Karel makes one left turn.
        move();                       // Karel takes one step forward.
    }

    /*
     * Method: moveToWall()
     * Precondition: There shouldn't be a wall in front of Karel.
     * Expected result: Karel has to stop if there's a wall in front of him.
     */
    public void moveToWall() throws Exception {
        while (frontIsClear()) {      // If there are no walls ahead.
            move();                   // Karel takes one step forward.
        }
    }
}
