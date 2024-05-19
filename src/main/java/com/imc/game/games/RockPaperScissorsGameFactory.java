package com.imc.game.games;


public class RockPaperScissorsGameFactory implements GameFactory {

    @Override
    public Game createGame() throws IllegalArgumentException {
        return new RockPaperScissorsGame();
    }
}