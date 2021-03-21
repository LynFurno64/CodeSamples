package Main;

import Pieces.Bumpers;
import Pieces.PlayerItem;
import Pieces.Steppers;
import Pieces.Zigzaggers;

public class Player
{
    private String name;                        // holds Names
    private int  numFinish;                     //Contains the number of pieces the player has successfully gotten to FINISH.
    private boolean loseTurn;               //Used to indicate whether or not the player should lose a turn on the next round.
    private Steppers steppers;
    private Bumpers bumpers;
    private Zigzaggers zigzaggers;

    /**
     * Constructor used to initialize
     * @param n
     */
    public Player(String n)
    {
        name = n;
        numFinish = 0;
        loseTurn = false;
    }

    /**
     * Method used to increment numFinish by 1.
     */
    public void updateNumFinish()
    {
       numFinish += 1;
    }// updateNumFinish

    /**
     * Accessors
     */
    public String getName()
    {
        return name;
    }// getName
    public int getNumFinish()
    {
        return numFinish;
    }// getNumFinish
    public boolean getLoseTurn()
    {
        return loseTurn;
    }// getLoseTurn

    /**
     * Mutator
     */
    public void setName(String a)
    {
        name = a;
    }// setName
    public void setNumFinish(int f)
    {
        numFinish = f;
    }// setNumFinish
    public void setLoseTurn(boolean l)
    {
        loseTurn = l;
    }// setLoseTurn

    /**
     * Method used to instantiate the player’s pieces.
     */
    public void setPieces(Steppers S, Zigzaggers Z, Bumpers B)
    {
        steppers = S;
        zigzaggers = Z;
        bumpers = B;
    }// setPieces

    /**
     * Method used to set the isFinished data member of player’s piece (indicated by the parameter) to true.
     */
    public void setPieceFinished (PlayerItem piece)
    {
        piece.setIsFinished(true);
    }// setPieceFinished

    /**
     * Returns whether or not the player’s piece (indicated by the parameter) is finished.
     * Values for parameter are 1 (stepper), 2 (zigzagger) or 3 (bumper).
     */
    public boolean isPieceFinished(int piece)
    {
        switch (piece)
        {
            case 1:
                if (steppers.getIsFinished() == true)
                {
                    return true;
                }
                return false;
            case 2:
                if (zigzaggers.getIsFinished() == true)
                {
                    return true;
                }
                return false;
            case 3:
                if (bumpers.getIsFinished() == true)
                {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }// isPieceFinished

    /**
     * Returns a reference to the player’s piece (indicated by the parameter).
     * Values for parameter are 1 (stepper), 2 (zigzagger) or 3 (bumper)
     */
    public PlayerItem getPiece(int piece)
    {
        switch (piece)
        {
            case 1:
                return steppers;
            case 2:
                return zigzaggers;
            case 3:
                return bumpers;
            default:
                return null;
        }
    }// getPiece
}// Player
