package games;

import com.imc.game.games.RockPaperScissorsGame;
import com.imc.game.moves.Move;
import com.imc.game.moves.RockPaperScissorsMove;
import com.imc.game.util.ScannerWrapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static com.imc.game.enums.GameMove.*;
import static org.junit.Assert.assertEquals;

public class RockPaperScissorsGameTest {
    @Mock
    private static ScannerWrapper mockScanner;

    @BeforeClass
    public static void setUp() {
        mockScanner = Mockito.mock(ScannerWrapper.class);
    }

    @Test
    public void testPlayRound_rockWinsScissors() {
        RockPaperScissorsGame game = new RockPaperScissorsGame(mockScanner);

        Move rockMove = new RockPaperScissorsMove(ROCK);
        Move scissorsMove = new RockPaperScissorsMove(SCISSORS);

        assertEquals(1, game.playRound(rockMove, scissorsMove)); // Player 1 (rock) wins
    }

    @Test
    public void testPlayRound_paperWinsRock() {
        RockPaperScissorsGame game = new RockPaperScissorsGame(mockScanner);

        Move paperMove = new RockPaperScissorsMove(PAPER);
        Move rockMove = new RockPaperScissorsMove(ROCK);

        assertEquals(1, game.playRound(paperMove, rockMove)); // Player 1 (paper) wins
    }

    @Test
    public void testPlayRound_tie() {
        RockPaperScissorsGame game = new RockPaperScissorsGame(mockScanner);

        Move paperMove = new RockPaperScissorsMove(PAPER);
        Move paperMove2 = new RockPaperScissorsMove(PAPER);

        assertEquals(0, game.playRound(paperMove, paperMove2)); // Tie
    }


    @Test
    public void testGetNumberOfRounds_validInput() {
        Mockito.when(mockScanner.nextLine()).thenReturn("5");

        RockPaperScissorsGame game = new RockPaperScissorsGame(mockScanner);
        game.getNumberOfRounds();

        assertEquals(5, game.getNumRounds());
    }

    @Test
    public void testGetNumberOfRounds_invalidInput_loopContinues() {
        Mockito.when(mockScanner.nextLine()).thenReturn("invalid", "3");

        RockPaperScissorsGame game = new RockPaperScissorsGame(mockScanner);
        game.getNumberOfRounds();

        assertEquals(3, game.getNumRounds());
    }
}
