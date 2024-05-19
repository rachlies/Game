package com.imc.game.enums;

public enum GameMove {
    ROCK,
    PAPER,
    SCISSORS;

    @Override
    public String toString() {
        return switch (this) {
            case ROCK -> "ROCK";
            case PAPER -> "PAPER";
            case SCISSORS -> "SCISSORS";
            default -> super.toString(); // Fallback to default behavior
        };
    }
}