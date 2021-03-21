package JustMethods;

import Exceptions.CollisionException;
import Exceptions.OffBoardException;
import Main.GameBoard;
import Main.Player;

import java.util.Scanner;

public class MethodSwitchC
{
    Scanner parameter = new Scanner(System.in);

    public void methodSwitchC() throws CollisionException, OffBoardException {
        int r, c, o, p;

        System.out.println("\nThe Row and Column boundaries are:\n 4 < Row/Col < 25");

        /*
         * Limits to the Rows input
         */
        System.out.print("\nNumber for Rows are: ");
        r = parameter.nextInt();

        while( r <= 3  || r > 25)
        {
            System.out.print("Please Renter: ");
            r = parameter.nextInt();
        }

        /*
         * Limits to the Column input
         */
        System.out.print("\nNumber for Columns are: ");
        c = parameter.nextInt();

        while( c <= 3  || c > 25)
        {
            System.out.print("Please Renter: ");
            c = parameter.nextInt();
        }

        /*
         * Limits to the Obstacles input
         */
        int O = (r*(c-2));
        double f = O*0.4;
        int i = (int) f;
        System.out.println("\nThe Obstacles boundary is between 1 and " + i + ": ");
        System.out.print("Number for Obstacles are: ");
        o =  parameter.nextInt();

        while( o <= 0 || o > i)
        {
            System.out.print("Please Renter: ");
            o = parameter.nextInt();
        }

        /*
         * Limits to the Prize input
         */
        int P = (r*(c-2));
        double d = P*0.2;
        int j = (int) d;
        System.out.println("\nThe Prize boundary is between 1 and " + j + ": ");
        System.out.print("Number for Prizes are: ");
        p = parameter.nextInt();

        while( p <= 0 || p > j)
        {
           System.out.println("Please Renter: ");
           p = parameter.nextInt();
        }


        Player player1 = new Player("player1st");
        Player player2 = new Player("player2nd");
        GameBoard Jackie = new GameBoard(r,c,o,p);
        Jackie.populateBoard();
        Jackie.placePlayerPieces(player1, player2);
        Jackie.displayBoard();
        Jackie.runPlayerTurn(player1);
        Jackie.runPlayerTurn(player2);
    }// methodSwitchC
}// MethodSwitchC
