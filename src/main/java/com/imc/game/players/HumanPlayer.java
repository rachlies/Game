package com.imc.game.players;

import com.imc.game.moves.Move;
import com.imc.game.util.ScannerWrapper;

import java.util.Arrays;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private final ScannerWrapper scanner;
    public HumanPlayer(String name, Move []validMoves, ScannerWrapper scanner) {
        super(name, validMoves);
        this.scanner = scanner;
    }

    @Override
    public Move getMove() {
        while (true) {

            System.out.println("Enter your move (valid options: "
                    + Arrays.toString(getValidMovesLookup().keySet().toArray()) + "): ");

            String userMove = scanner.nextLine();

            if(getValidMovesLookup().containsKey(userMove.toUpperCase())) {
                return getValidMovesLookup().get(userMove);
            }

            System.out.println("Invalid move. Please try again.");
        }
    }
}
