package ItemsInBoard;

public class BoardItem
{
    protected String type;        //Contains the type of the item. The descriptor will be a word.
    protected char symbol;        //Contains the character which will be used to represent the item on the board.

    //Accessors
    public String getType()
    {
        return type;
    }// getType
    public char getSymbol()
    {
        return symbol;
    }// getSymbol

    //Mutator
    public void setType(String t)
    {
        type = t;
    }// setType
    public void setSymbol(char s)
    {
        symbol = s;
    }// setSymbol
}//BoardItem
