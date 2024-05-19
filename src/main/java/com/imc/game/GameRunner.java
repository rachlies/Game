package com.imc.game;

import com.imc.game.games.Game;
import com.imc.game.games.GameFactory;
import com.imc.game.games.RockPaperScissorsGameFactory;
import com.imc.game.util.ScannerWrapper;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameFactory rpsFactory = new RockPaperScissorsGameFactory(new ScannerWrapper(scanner));

        Game rpsGame = rpsFactory.createGame();
        rpsGame.initializeGame();
        rpsGame.startGame();
        rpsGame.displayStats();
    }
}
