package Exceptions;

/**
 * overrides the default exception message
 */
public class OffBoardException extends Exception
{
    public OffBoardException(String s)
    {
        super(s);
    }
    public String toString()
    {
        return ("“Destination off board!");
    } // toString
}
