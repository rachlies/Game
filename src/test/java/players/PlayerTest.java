package players;

import com.imc.game.enums.GameMove;
import com.imc.game.moves.Move;
import com.imc.game.moves.RockPaperScissorsMove;
import com.imc.game.players.HumanPlayer;
import com.imc.game.players.Player;
import com.imc.game.util.ScannerWrapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    private static Player player;

    @BeforeClass
    public static void setUp() {
        ScannerWrapper mockScanner = Mockito.mock(ScannerWrapper.class);

        Move[] validMoves = new Move[]{
                new RockPaperScissorsMove(GameMove.ROCK),
                new RockPaperScissorsMove(GameMove.PAPER),
                new RockPaperScissorsMove(GameMove.SCISSORS)
        };

        player = new HumanPlayer("TestPlayer", validMoves, mockScanner);
    }

    @Test
    public void testGetName() {
        // Test if the player's name is correctly returned
        assertEquals("TestPlayer", player.getName());
    }

    @Test
    public void testIncreaseWinCount() {
        // Test the initial win count
        assertEquals(0, player.getWinCount());

        // Increase win count and test again
        player.increaseWinCount();
        assertEquals(1, player.getWinCount());
    }

    @Test
    public void testGetValidMovesLookup() {
        Map<String, Move> movesLookup = player.getValidMovesLookup();
        assertEquals(3, movesLookup.size());
        assertTrue(movesLookup.containsKey("ROCK"));
        assertTrue(movesLookup.containsKey("PAPER"));
        assertTrue(movesLookup.containsKey("SCISSORS"));
    }
}
