package Pieces;

import ItemsInBoard.BoardItem;

public abstract class PlayerItem extends BoardItem
{
    protected int[] location;         //Array used to hold the row and column location of the object.
    protected boolean isFinished;     //Used to indicate whether the object has reached FINISH or not.

    public PlayerItem()
    {
        location = new int[2];
    }

    /**
     * Used to store the current location of the object in the location variable.
     * You may assume the first position is used for row and the other for column.
     */
    public void setLocation(int r, int c)
    {
        location[0] = r;
        location[1] = c;
    }// setLocation

    /**
     * Returns the location of the object.
     */
    public int[] getLocation()
    {
        System.out.println("Current row " +location[0]);
        System.out.println("Current col " +location[1]);
        return location;
    }// getLocation

    /**
     * Returns whether or not the object has reached FINISH.
     */
    public boolean getIsFinished()
    {
        return isFinished;
    }// getIsFinished

    /**
     * Uses status to update the isFinished data member.
     */
    public void setIsFinished(boolean status)
    {
        isFinished = status;
    }

    /**
     * An abstract method to be defined by sub-classes.
     */
    protected int[] calcDestination(int direction)
    {
        return new int[2];
    }// calcDestination
}//PlayerItem
