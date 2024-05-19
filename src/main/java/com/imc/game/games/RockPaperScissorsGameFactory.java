package com.imc.game.games;
import com.imc.game.util.ScannerWrapper;

import java.util.Scanner;


public class RockPaperScissorsGameFactory implements GameFactory {

    private final ScannerWrapper scanner;

    public RockPaperScissorsGameFactory(ScannerWrapper scanner) {
        this.scanner = scanner;
    }

    @Override
    public Game createGame() throws IllegalArgumentException {
        return new RockPaperScissorsGame(scanner);
    }
}