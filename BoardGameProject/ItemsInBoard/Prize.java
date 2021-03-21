package ItemsInBoard;

//inherits from ItemsInBoard.BoardItem
//Prizes will allow the game piece which landed on it to have a double-turn (i.e. play twice on a single turn).
public class Prize extends BoardItem
{
    private int prizeValue;         //Indicates the value of this prize.

    public Prize()
    {
        type = "prize";
        symbol = 'P';
        prizeValue = 2;
    }
}// ItemsInBoard.Prize
