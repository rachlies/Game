package com.imc.game.players;

import com.imc.game.moves.Move;
import com.imc.game.moves.RockPaperScissorsMove;
import java.util.Random;
import static com.imc.game.enums.GameMove.*;

public class ComputerPlayer extends Player {

    private final Move[] validMoves = {
            new RockPaperScissorsMove(ROCK),
            new RockPaperScissorsMove(PAPER),
            new RockPaperScissorsMove(SCISSORS)
    };

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public Move getMove() {
        Random random = new Random();
        int randomIndex = random.nextInt(validMoves.length);
        return validMoves[randomIndex];
    }
}