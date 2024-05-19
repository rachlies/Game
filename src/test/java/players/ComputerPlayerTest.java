package players;

import com.imc.game.enums.GameMove;
import com.imc.game.moves.Move;
import com.imc.game.moves.RockPaperScissorsMove;
import com.imc.game.players.ComputerPlayer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ComputerPlayerTest {
    private static ComputerPlayer computerPlayer;

    @BeforeClass
    public static void setUp() {
        Move[] validMoves = new Move[]{
                new RockPaperScissorsMove(GameMove.ROCK),
                new RockPaperScissorsMove(GameMove.PAPER),
                new RockPaperScissorsMove(GameMove.SCISSORS)
        };
        computerPlayer = new ComputerPlayer("Computer", validMoves, new Random(42));
    }

    @Test
    public void testGetMove() {
        Move move = computerPlayer.getMove();
        assertNotNull(move);
        assertTrue(move.getMove() == GameMove.ROCK ||
                move.getMove() == GameMove.PAPER ||
                move.getMove() == GameMove.SCISSORS);
    }
}
