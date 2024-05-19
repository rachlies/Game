package players;

import com.imc.game.enums.GameMove;
import com.imc.game.moves.Move;
import com.imc.game.moves.RockPaperScissorsMove;
import com.imc.game.players.HumanPlayer;
import com.imc.game.util.ScannerWrapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    @Mock
    private static ScannerWrapper mockScanner;

    @BeforeClass
    public static void setUp() {
        mockScanner = Mockito.mock(ScannerWrapper.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_nullName() {
        new HumanPlayer(null, new Move[0], mockScanner);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_nullMoves() {
        new HumanPlayer("Alice", null, mockScanner);
    }

    @Test
    public void testGetMove_validInput() {
        Move[] validMoves = new Move[]{
                new RockPaperScissorsMove(GameMove.ROCK),
                new RockPaperScissorsMove(GameMove.PAPER),
                new RockPaperScissorsMove(GameMove.SCISSORS)
        };

        Mockito.when(mockScanner.nextLine()).thenReturn("ROCK");
        HumanPlayer player = new HumanPlayer("Bob", validMoves, mockScanner);
        assertEquals(validMoves[0], player.getMove());
    }

    @Test
    public void testGetMove_invalidInput_repeat() {
        Move[] validMoves = new Move[]{
                new RockPaperScissorsMove(GameMove.ROCK),
                new RockPaperScissorsMove(GameMove.PAPER),
                new RockPaperScissorsMove(GameMove.SCISSORS)
        };
        HumanPlayer player = new HumanPlayer("Bob", validMoves, mockScanner);
        Mockito.when(mockScanner.nextLine())
                .thenReturn("INVALID")
                .thenReturn("ROCK");
        System.setIn(new ByteArrayInputStream("INVALID\nROCK".getBytes()));
        assertEquals(validMoves[0], player.getMove());
    }
}
