package Main;
import Colors.ConsoleColors;
import Exceptions.CollisionException;
import Exceptions.OffBoardException;
import ItemsInBoard.*;
import Pieces.Bumpers;
import Pieces.PlayerItem;
import Pieces.Steppers;
import Pieces.Zigzaggers;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameBoard
{
    private int numRows;            //Number of rows on game board. Default size is 6.
    private int numCols;           //Number of columns on game board. Default size is 15.
    private BoardItem[][] gameBoard;        //2-d array holding creature objects. Size is numRows x numCols.
    private int numObstacles;              //Contains the number of obstacles currently on the board.
    private  int numPrizes;             //Contains the number of prizes currently on the board.

    public GameBoard()
    {
        numRows = 6;
        numCols = 15;
        gameBoard = new BoardItem[6][15];
        numObstacles = 6;
        numPrizes = 3;
    }

    public GameBoard(int nRows, int nCols, int nObstacles, int nPrize)
    {
        numRows = nRows;
        numCols = nCols;
        gameBoard = new BoardItem[nRows][nCols];
        numObstacles = nObstacles;
        numPrizes = nPrize;
    }

    /**
     * Creates ItemsInBoard.Obstacle and ItemsInBoard.Prize objects and calls the addBoardItem() method to place them on the gameboard one at a time.
     */
    public void populateBoard()
    {
       for (var o = 0; o < numObstacles; o++)
       {
           addBoardItem(new Obstacle(), null);
       }

        for (var p = 0; p < numPrizes; p++)
        {
            addBoardItem(new Prize(), null);
        }
    }// populateBoard

    /**
     * Randomly generates co-ordinates until an empty board cell is found. Once found, it assigns the item to the gameBoard array.
     */
    public void addBoardItem(BoardItem item, PlayerItem piece)
    {
        Random randNum = new Random();
        int r, c;
        if (piece == null)
        {
            do {
                r = randNum.nextInt(numRows);
                c = randNum.nextInt(numCols - 2) + 1;
            }
            while (gameBoard[r][c] instanceof BoardItem);
            gameBoard[r][c] = item;
        }
        else {
            do {
                r = randNum.nextInt(numRows);
                c = randNum.nextInt(1);
            }
            while (gameBoard[r][c] instanceof PlayerItem);
            piece.setLocation(r,c);
            gameBoard[r][c] = piece;
        }
    }// addBoardItem

    public void placePlayerPieces(Player p1, Player p2)  {
        //create 3 pieces for Player 1 using UPPERCASE symbols
        Bumpers B = new Bumpers('B');
        Steppers S = new Steppers('S');
        Zigzaggers Z = new Zigzaggers('Z');
        // insert code to add these pieces to player 1
        p1.setPieces(S,Z,B);
        // insert code to add each piece to the board.
        addBoardItem(null, S);
        addBoardItem(null, Z);
        addBoardItem(null, B);

        //create 3 pieces for Player 2 using lowercase symbols
        Bumpers b = new Bumpers('b');
        Steppers s = new Steppers('s');
        Zigzaggers z = new Zigzaggers('z');
        // insert code to add these pieces to player 2
        p2.setPieces(s, z, b);
        // insert code to add each piece to the board.
        addBoardItem(null, s);
        addBoardItem(null, z);
        addBoardItem(null, b);
    }// placePlayerPieces

    /**
     * Used to remove the prize located at the position indicated by row and col. Returns true once the operation was successful
     */
    public boolean removePrize(int row, int col)
    {
        if (gameBoard[row][col] != null)
        {
            if (gameBoard[row][col].getType().equals("prize"))
            {
                gameBoard[row][col] = null;
                //System.out.print(" " + 'N' + " |");
                return true;
            }
        }
        return false;
    }// removePrize

    public void displayBoard()
    {
        String str = "————";
        System.out.println("\nStart>"+str.repeat(numCols-2)+"—>Finish");
        int r,c;


        // Creating the Rows and Columns
        for (r = 0; r < numRows; r++)
        {
            if (r > 8)
            {
                System.out.print((r + 1) + " : |");
            }
            else
            {
                System.out.print((r + 1) + " :  |");
            }

            for (c = 0; c < numCols; c++)
            {
                if (gameBoard[r][c] == null)
                {
                    System.out.print("   |");
                }
                else
                {
                    System.out.print(" " + gameBoard[r][c].getSymbol() + " |");
                }
            }
            System.out.println();
            System.out.println("—————"+str.repeat(numCols) + "—");
        }
        System.out.print("Prizes Left: " + numPrizes + "\n");
    }// displayBoard

    /**
     * displays a message with the appropriate command instructions for moving the player piece indicated via the piece parameter,
     * where 1 = stepper, 2 = zigzagger. 3 = bumper.
     * @param piece
     */
    public void displayMovementOptions(int piece)
    {
        switch (piece)
        {
            case 1:
                System.out.println("Stepper Movement Input:\n"+ ConsoleColors.ANSI_BLUE +"North => 1, South => 2, East => 3, West => 4" + ConsoleColors.ANSI_RESET);
                break;
            case 2:
                System.out.println("Zigzagger Movement Input:\n"+ ConsoleColors.ANSI_BLUE +"NorthEast => 5, SouthEast => 6, NorthWest => 7, SouthWest => 8" + ConsoleColors.ANSI_RESET);
                break;
            case 3:
                System.out.println("Bumper Movement Input:\n"+ ConsoleColors.ANSI_BLUE +"North => 1, South => 2, East => 3, West => 4, NorthEast => 5, SouthEast => 6, NorthWest => 7, SouthWest => 8" + ConsoleColors.ANSI_RESET);
                break;
            default:
                System.out.println("Error");
        }
    }// displayMovementOptions

    /**
     * If the destination is off the edge of the board,throw an OffBoardException exception with the message "Re-enter or die!"
     * If the destination contains an Obstacle, throw a CollisionException exception with the message “Obstacle at destination”.
     * If the destination contains a player piece, throw a CollisionException exception with the message “Piece at destination”.
     * Otherwise, this is a valid move.
     */
    public boolean validateMove(int row, int col) throws OffBoardException, CollisionException
    {
        if (row < 0 || row > numRows || col < 0 || col > numCols)
        {
            throw new OffBoardException("Re-enter or die!");
        }
        else if (/**gameBoard[row][col] != null &&*/ gameBoard[row][col] instanceof Obstacle)
        {
            throw new CollisionException("Obstacle at destination");
        }
        else if (/**gameBoard[row][col] != null &&*/ gameBoard[row][col] instanceof PlayerItem)
        {
            throw new CollisionException("Piece at destination");
        }
        System.out.println("Valid move");
        return true;
    }// validateMove

    /**
     *Display instructions for selecting piece to move instructions should only be displayed for pieces which are NOT FINISHED.
     * create a reference to the piece the player wants to move
     * Display the movement options based on type of piece they have selected calculate destination for the piece based on the direction of movement selected.
     * validate the move a valid move would result in the piece being moved.
     * If a CollisionException was thrown for a collision with an obstacle, set the player to lose a turn. (NOTE: the player will not move on this round.)
     * If a CollisionException was thrown for a collision with another player piece, the player should be asked and allowed to re-enter new movement.
     */
    public void runPlayerTurn(Player p) throws CollisionException, OffBoardException {
        Steppers step = null;
        Zigzaggers zig = null;
        Bumpers bum = null;

        System.out.println("To move the pieces press\n1 for " + ConsoleColors.ANSI_BLUE + "Stepper" + ConsoleColors.ANSI_RESET + ", 2 for " + ConsoleColors.ANSI_BLUE + "Zigzagger" + ConsoleColors.ANSI_RESET + ", and 3 for " + ConsoleColors.ANSI_BLUE + "Bumper" + ConsoleColors.ANSI_RESET);
        Scanner choose = new Scanner(System.in);

        int num = 0;
        boolean loop = true;
        while (loop) {
            try {
                System.out.print("What piece would you like to move? => ");
                num = choose.nextInt();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println(ConsoleColors.ANSI_RED +"Invalid input" + ConsoleColors.ANSI_RESET);
                choose.next();
            }
        }

        while (num < 0 || num > 3)
        {
            boolean loop2 = true;
            while (loop2) {
                try {
                    System.out.print("What piece would you like to move?\nType 1,2 or 3 => ");
                    num = choose.nextInt();
                    loop2 = false;
                } catch (InputMismatchException e) {
                    System.out.println(ConsoleColors.ANSI_RED +"Invalid Input" + ConsoleColors.ANSI_RESET);
                    choose.next();
                }
            }
        }

        int[] locate = new int[2];

        switch (num)
        {
            // Stepper
            case 1:
                    step = (Steppers) p.getPiece(1);
                    if (step.getIsFinished() == false) {
                        step.getLocation();
                        do {
                            displayMovementOptions(1);
                            boolean loop3 = true;
                            while (loop3) {
                                try {
                                    System.out.print("What is your move? "+ ConsoleColors.ANSI_BRIGHT_BLUE  + p.getName() + " : " + ConsoleColors.ANSI_RESET);
                                    num = choose.nextInt();
                                    loop3 = false;
                                } catch (InputMismatchException e) {
                                    System.out.println(ConsoleColors.ANSI_RED + ConsoleColors.ANSI_BRIGHT_BG_WHITE + "Invalid input" + ConsoleColors.ANSI_RESET);
                                    choose.next();
                                }
                            }
                        } while (num < 0 || num > 4);

                        locate = step.calcDestination(num);
                        System.out.print("Future row " +locate[0]);
                        System.out.println(", Future col " +locate[1]);

                        //Move Check
                        try {
                            validateMove(locate[0], locate[1]);
                            step.setLocation(locate[0], locate[1]);
                            System.out.println("Moved");
                        }
                        catch (CollisionException e) {
                            if (gameBoard[locate[0]][locate[1]] instanceof Obstacle) {
                                System.out.println(ConsoleColors.ANSI_RED + e + " Obstacle at destination" + ConsoleColors.ANSI_RESET);
                                p.setLoseTurn(true);
                            } else {
                                System.out.println(e + " Piece at destination");
                            }
                        }
                        catch (OffBoardException e)
                        {
                            System.out.println(ConsoleColors.ANSI_RED + "Caught: " + e + ConsoleColors.ANSI_RESET);
                        }
                    }
                    else {
                        System.out.println("Piece is at Finished line");
                    }
                break;
            // Zigzagger
            case 2:
                zig = (Zigzaggers) p.getPiece(2);
                if (zig.getIsFinished() == false) {
                    zig.getLocation();
                    do {
                        displayMovementOptions(2);
                        boolean loop3 = true;
                        while (loop3) {
                            try {
                                System.out.print("What is your move? " + ConsoleColors.ANSI_BRIGHT_BLUE + p.getName() + " : " + ConsoleColors.ANSI_RESET);
                                num = choose.nextInt();
                                loop3 = false;
                            } catch (InputMismatchException e) {
                                System.out.println(ConsoleColors.ANSI_RED + ConsoleColors.ANSI_BRIGHT_BG_WHITE + "Invalid input" + ConsoleColors.ANSI_RESET);
                                choose.next();
                            }
                        }
                    } while (num < 5 || num > 8);

                    locate = zig.calcDestination(num);
                    System.out.print("Future row " + locate[0]);
                    System.out.println(", Future col " + locate[1]);

                    //Move Check
                    try {
                        validateMove(locate[0], locate[1]);
                        if (gameBoard[locate[0]][locate[1]] instanceof Prize)
                        {
                            removePrize(locate[0], locate[1]);
                        }
                        zig.setLocation(locate[0], locate[1]);
                        System.out.println("Moved");
                    } catch (CollisionException e) {
                        if (gameBoard[locate[0]][locate[1]] instanceof Obstacle) {
                            System.out.println(ConsoleColors.ANSI_RED + e + " Obstacle at destination" + ConsoleColors.ANSI_RESET);
                            p.setLoseTurn(true);
                        } else {
                            System.out.println(e + " Piece at destination");
                        }
                    } catch (OffBoardException e) {
                        System.out.println(ConsoleColors.ANSI_RED + "Caught: " + e + ConsoleColors.ANSI_RESET);
                    }
                }
                else {
                    System.out.println("Piece is at Finished line");
                }
                break;
            // Bumper
            case 3:
                bum = (Bumpers) p.getPiece(3);
                if (bum.getIsFinished() == false) {
                    bum.getLocation();
                    do {
                        displayMovementOptions(3);
                        boolean loop3 = true;
                        while (loop3) {
                            try {
                                System.out.print("What is your move? " + ConsoleColors.ANSI_BRIGHT_BLUE + p.getName() + " : " + ConsoleColors.ANSI_RESET);
                                num = choose.nextInt();
                                loop3 = false;
                            } catch (InputMismatchException e) {
                                System.out.println(ConsoleColors.ANSI_RED + ConsoleColors.ANSI_BRIGHT_BG_WHITE + "Invalid input" + ConsoleColors.ANSI_RESET);
                                choose.next();
                            }
                        }
                    } while (num < 0 || num > 8);

                    locate = bum.calcDestination(num);
                    System.out.print("Future row " + locate[0]);
                    System.out.println(", Future col " + locate[1]);

                    //Move Check
                    try {
                        validateMove(locate[0], locate[1]);
                        bum.setLocation(locate[0], locate[1]);
                        System.out.println("Moved");
                    } catch (CollisionException e) {
                        if (gameBoard[locate[0]][locate[1]] instanceof Obstacle) {
                            System.out.println(ConsoleColors.ANSI_RED + e + " Obstacle at destination" + ConsoleColors.ANSI_RESET);
                            p.setLoseTurn(true);
                        } else {
                            System.out.println(e + " Piece at destination");
                        }
                    } catch (OffBoardException e) {
                        System.out.println(ConsoleColors.ANSI_RED + "Caught: " + e + ConsoleColors.ANSI_RESET);
                    }
                }
                else {
                    System.out.println("Piece is at Finished line");
                }
                break;
        }
    }// runPlayerTurn
}//GameBoard

