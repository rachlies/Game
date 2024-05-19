package com.imc.game.moves;


import com.imc.game.enums.GameMove;

public class RockPaperScissorsMove implements Move {

    private final GameMove move;

    public RockPaperScissorsMove(GameMove move) {
        this.move = move;
    }

    @Override
    public GameMove getMove() {
        return move;
    }
}
