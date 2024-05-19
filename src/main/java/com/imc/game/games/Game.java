package com.imc.game.games;


public interface Game {

    /**
     * Returns the name of the game.
     *
     * @return The game name as a String.
     */
    String getName();

    /**
     * Initializes the game state and prepares it for playing. This method
     * should be called before calling {@link #startGame()}.
     */
    void initializeGame();

    /**
     * Starts the game loop. This method typically controls the flow of
     * the game, handling player turns, move validation, and game state updates.
     */
    void startGame();

    /**
     * Displays statistics or information about the current game state. This
     * could include scores, remaining turns, or other relevant data.
     */
    void displayStats();
}
