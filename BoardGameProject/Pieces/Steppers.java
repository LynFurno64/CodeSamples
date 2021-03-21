package Pieces;

import Main.GameBoard;

public class Steppers extends PlayerItem
{
    GameBoard val = new GameBoard();
    /**
     * Constructor which initializes type to “stepper” and symbol
     * to the value of parameter s and isFinished to the appropriate value.
     */
    public Steppers(char s)
    {
         type = "stepper";
         symbol = s;
         isFinished = false;
    }

    /**
     * Based on the direction supplied, this method calculates the destination row & column IF the object were to be moved.
     * It returns this destination row & column pair in an array.
     * Note: You may assume integer values for directions as follows: 1 (north), 2(south), 3 (east), 4 (west)
     */
    public int[] calcDestination(int direction)
    {
        int[] newlocation = new int[2];

        switch (direction)
        {
            case 1:
                System.out.println("North");
                newlocation[0] = location[0] - 1;
                newlocation[1] = location[1];
                return newlocation;
            case 2:
                System.out.println("South");
                newlocation[0] = location[0] + 1;
                newlocation[1] = location[1];
                return newlocation;
            case 3:
                System.out.println("East");
                newlocation[0] = location[0];
                newlocation[1] = location[1] + 1;
                return newlocation;
            case 4:
                System.out.println("West");
                newlocation[0] = location[0];
                newlocation[1] = location[1] - 1;
                return newlocation;
            default:
                return location;
        }
    }// calcDestination
}
