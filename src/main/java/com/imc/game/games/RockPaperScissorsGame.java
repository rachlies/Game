package com.imc.game.games;

import com.imc.game.enums.GameType;
import com.imc.game.moves.Move;
import com.imc.game.moves.RockPaperScissorsMove;
import com.imc.game.players.ComputerPlayer;
import com.imc.game.players.HumanPlayer;
import com.imc.game.players.Player;

import java.util.Scanner;

import static com.imc.game.enums.GameMove.*;

public class RockPaperScissorsGame implements Game {
    private Player player1, player2;
    private int numRounds;
    private final GameType gameType;

    private final Move[] validMoves = {
            new RockPaperScissorsMove(ROCK),
            new RockPaperScissorsMove(PAPER),
            new RockPaperScissorsMove(SCISSORS)
    };

    public RockPaperScissorsGame() {
        this.gameType = GameType.ROCK_PAPER_SCISSORS;
    }

    @Override
    public String getName() {
        return gameType.toString();
    }

    @Override
    public void initializeGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of rounds to play");
        numRounds = Integer.parseInt(scanner.nextLine());

        System.out.println("Please enter the the player name!");
        String name = scanner.nextLine();

        player1 = new HumanPlayer(name, validMoves);
        player2 = new ComputerPlayer("Computer");
    }

    @Override
    public void startGame() {
        int count = 0;
        while(count++ < numRounds) {
            Move player1move = player1.getMove();
            Move player2move = player2.getMove();
            int res =  playRound(player1move, player2move);
            if(res == 1) {
                player1.increaseWinCount();
                System.out.println(player1.getName() + "  Wins!");
            } else if (res == -1) {
                player2.increaseWinCount();
                System.out.println(player2.getName() + "  Wins!");
            } else {
                System.out.println("It's a Tie!");
            }
        }
    }

    @Override
    public void displayStats() {
        System.out.println("Total number rounds played = " + numRounds);
        System.out.println("Total number of rounds won by "
                + player1.getName() + " = " + player1.getWinCount());
        System.out.println("Total number of rounds won by "
                + player2.getName() + " = " + player2.getWinCount());
        System.out.println("Total number of rounds resulted in tie = "
                + (numRounds - player1.getWinCount() - player2.getWinCount()));
    }

    private int playRound(Move player1Move, Move player2Move) {
        if(player1Move.getMove().equals(player2Move.getMove())) return 0;
        return switch (player1Move.getMove()) {
            case ROCK -> (player2Move.getMove().equals(SCISSORS) ? 1 : -1);
            case PAPER -> (player2Move.getMove().equals(ROCK) ? 1 : -1);
            case SCISSORS -> (player2Move.getMove().equals(PAPER) ? 1 : -1);
        };
    }
}
