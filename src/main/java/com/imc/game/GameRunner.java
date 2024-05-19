package com.imc.game;

import com.imc.game.games.Game;
import com.imc.game.games.GameFactory;
import com.imc.game.games.RockPaperScissorsGameFactory;

public class GameRunner {
    public static void main(String[] args) {
        GameFactory rpsFactory = new RockPaperScissorsGameFactory();

        Game rpsGame = rpsFactory.createGame();
        rpsGame.initializeGame();
        rpsGame.startGame();
        rpsGame.displayStats();
    }
}
