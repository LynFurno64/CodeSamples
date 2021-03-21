/**
 * Made By Ché Alexander    ID: 400003812
 */
package Main;

import Exceptions.CollisionException;
import Exceptions.OffBoardException;
import JustMethods.MethodSwitchC;
import java.util.Scanner;

public class FinishLine
{
    private static FinishLine display;

    public static void main(String[] args) throws CollisionException, OffBoardException {
        Scanner name = new Scanner(System.in);
        System.out.print("Whats your name Player 1? ");
        String player1st = name.nextLine();
        System.out.print("Whats your name Player 2? ");
        String player2nd = name.nextLine();

        Player player1 = new Player(player1st);
        Player player2 = new Player(player2nd);

        Scanner choice = new Scanner(System.in);
        System.out.println("Do you want to use a Standard board or a Custom board?\nType S (standard) or C (custom)");
        String which = choice.nextLine();
        String output = which.toLowerCase();

        System.out.println("\nPLAYER STATUS");
        System.out.println(player1.getName() +": " + player1.getNumFinish() + " pieces at FINISH; 3 out");
        System.out.println(player2.getName() +": " + player2.getNumFinish() + " pieces at FINISH; 3 out");

        while (!output.equals("s") && !output.equals("c"))
        {
            System.out.println("Please Re-Enter: ");
            which = choice.nextLine();
            output = which.toLowerCase();
        }

        switch (output) {
            case "s":
                GameBoard Jack = new GameBoard();
                Jack.populateBoard();
                Jack.placePlayerPieces(player1, player2);
                Jack.displayBoard();
                Jack.runPlayerTurn(player1);
                break;
            case "c":
                MethodSwitchC j = new MethodSwitchC();
                j.methodSwitchC();
                break;
        }
    }// main

}//FinishLine

