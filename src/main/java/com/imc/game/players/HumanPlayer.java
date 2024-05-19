package com.imc.game.players;

import com.imc.game.moves.Move;

import java.util.Arrays;
import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name, Move []validMoves) {
        super(name, validMoves);
    }

    @Override
    public Move getMove() {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter your move (valid options: "
                    + Arrays.toString(getValidMovesLookup().keySet().toArray()) + "): ");

            String userMove = scanner.nextLine().toUpperCase();
            System.out.println("userMove " + userMove);

            if(getValidMovesLookup().containsKey(userMove)) {
                return getValidMovesLookup().get(userMove);
            }

            System.out.println("Invalid move. Please try again.");
        }
    }
}
