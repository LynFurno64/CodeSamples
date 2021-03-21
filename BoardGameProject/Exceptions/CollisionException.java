package Exceptions;

/**
 * overrides the default exception message
 */
public class CollisionException extends Exception
{
    public CollisionException(String c)
    {
        super(c);
    }
    public String toString()
    {
        return ("Collision imminent!");
    } // toString
}
