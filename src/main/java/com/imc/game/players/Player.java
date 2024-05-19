package com.imc.game.players;

import com.imc.game.moves.Move;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * This abstract class represents a player in a game.
 * It defines common attributes and functionalities for all player types.
 */
public abstract class Player {

    private final String name;
    private int winCount;
    private final Map<String, Move> validMovesLookup;

    public Player(String name, Move []validMoves) {
        this.name = name;
        this.winCount = 0;
        this.validMovesLookup = new HashMap<>();
        for(Move move : validMoves) {
            validMovesLookup.put(move.getMove().name(), move);
        }
    }

    public String getName() {
        return name;
    }

    public void increaseWinCount() {
        this.winCount++;
    }

    public int getWinCount() {
        return winCount;
    }

    public Map<String, Move> getValidMovesLookup() {
        return Collections.unmodifiableMap(validMovesLookup);
    }

    /**
     * This abstract method requires concrete player classes (HumanPlayer, ComputerPlayer)
     * to implement the logic for obtaining the player's move during the game.
     *
     * @return The player's move.
     */
    public abstract Move getMove();


}