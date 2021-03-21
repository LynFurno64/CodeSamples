package ItemsInBoard;

/**
 * inherits from ItemsInBoard.BoardItem
 * Obstacles will block the path of a game piece and therefore the piece will have to go around it. If the game piece lands on the obstacle, it will lose a
 * single turn (i.e. not move and the player will lose a turn on the next round).
 */
public class Obstacle extends BoardItem
{

    public Obstacle()
    {
        type = "obstacle";
        symbol = 'X';
    }
}//Obstacle
