package com.imc.game.games;

import com.imc.game.enums.GameType;
import com.imc.game.moves.Move;
import com.imc.game.moves.RockPaperScissorsMove;
import com.imc.game.players.ComputerPlayer;
import com.imc.game.players.HumanPlayer;
import com.imc.game.players.Player;
import com.imc.game.util.ScannerWrapper;

import static com.imc.game.enums.GameMove.*;

public class RockPaperScissorsGame implements Game {
    private Player player1, player2;
    private int numRounds;
    private final GameType gameType;
    private final ScannerWrapper scanner;


    public RockPaperScissorsGame(ScannerWrapper scanner) {
        this.scanner = scanner;
        this.gameType = GameType.ROCK_PAPER_SCISSORS;
    }

    @Override
    public String getName() {
        return gameType.toString();
    }

    @Override
    public void initializeGame() {
        getNumberOfRounds();

        System.out.println("Please enter the the player name!");
        String name = scanner.nextLine();

        player1 = createHumanPlayer(name);
        player2 = createComputerPlayer();
    }

    @Override
    public void startGame() {
        int count = 1;
        while(count <= numRounds) {

            System.out.println("=================================");
            System.out.printf("Round %d\n", count);
            System.out.println("=================================");

            Move player1move = player1.getMove();
            Move player2move = player2.getMove();

            System.out.printf("%s moves: %s\n", player1.getName(), player1move.getMove().name());
            System.out.printf("%s moves: %s\n", player2.getName(), player2move.getMove().name());

            int res = playRound(player1move, player2move);
            if (res == 1) {
                player1.increaseWinCount();
                System.out.printf("%s Wins this round!\n", player1.getName());
            } else if (res == -1) {
                player2.increaseWinCount();
                System.out.printf("%s Wins this round!\n", player2.getName());
            } else {
                System.out.println("It's a Tie this round!");
            }
            count++;
            System.out.println();
        }
    }

    @Override
    public void displayStats() {

        System.out.println("=================================");
        System.out.println("Game Over!");
        System.out.println("=================================");
        System.out.printf("Final Score:\n%s: %d\n%s: %d\n",
                player1.getName(), player1.getWinCount(),
                player2.getName(), player2.getWinCount());
        System.out.println("=================================");

        if (player1.getWinCount() > player2.getWinCount()) {
            System.out.printf("Overall Winner: %s\n", player1.getName());
        } else if (player2.getWinCount() > player1.getWinCount()) {
            System.out.printf("Overall Winner: %s\n", player2.getName());
        } else {
            System.out.println("The game is a Tie!");
        }
    }

    public int getNumRounds() {
        return numRounds;
    }

    public int playRound(Move player1Move, Move player2Move) {
        if(player1Move.getMove().equals(player2Move.getMove())) return 0;
        return switch (player1Move.getMove()) {
            case ROCK -> (player2Move.getMove().equals(SCISSORS) ? 1 : -1);
            case PAPER -> (player2Move.getMove().equals(ROCK) ? 1 : -1);
            case SCISSORS -> (player2Move.getMove().equals(PAPER) ? 1 : -1);
        };
    }

    private Move[] getValidMoves() {
        return new Move[] {
                new RockPaperScissorsMove(ROCK),
                new RockPaperScissorsMove(PAPER),
                new RockPaperScissorsMove(SCISSORS)
        };
    }

    public void getNumberOfRounds() {
        while (true) {
            System.out.println("Please enter the number of rounds to play:");
            try {
                numRounds = Integer.parseInt(scanner.nextLine());
                if (numRounds > 0) {
                    break;
                } else {
                    System.out.println("The number of rounds must be a positive integer. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid positive integer.");
            }
        }
    }

    private Player createHumanPlayer(String name) {
        return new HumanPlayer(name, getValidMoves(), scanner);
    }

    private Player createComputerPlayer() {
        return new ComputerPlayer("Computer", getValidMoves());
    }
}
