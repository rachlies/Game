package com.imc.game.games;



/**
 * This interface defines a factory for creating game objects. The factory
 * centralizes the creation of different game types.
 */
public interface GameFactory {

    /**
     * Creates a new game instance. Concrete GameFactory should implement it.
     */
    Game createGame();
}
