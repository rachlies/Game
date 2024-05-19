package com.imc.game.moves;

import com.imc.game.enums.GameMove;

/**
 * This interface represents a generic move within a game.
 * Concrete game implementations will have their own move classes extending this interface.
 */
public interface Move {

    /**
     * Returns the name of the move.
     *
     * @return The name of the move as a String.
     */
    GameMove getMove();

}