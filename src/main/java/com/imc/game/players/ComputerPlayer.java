package com.imc.game.players;

import com.imc.game.moves.Move;
import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random random;

    public ComputerPlayer(String name, Move []validMoves) {
        this(name, validMoves, new Random());
    }

    public ComputerPlayer(String name, Move []validMoves, Random random) {
        super(name, validMoves);
        this.random = random;
    }

    @Override
    public Move getMove() {
        Object[] moves = getValidMovesLookup().values().toArray();
        int randomIndex = random.nextInt(moves.length);
        return (Move) moves[randomIndex];
    }
}