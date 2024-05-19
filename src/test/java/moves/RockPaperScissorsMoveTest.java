package moves;

import com.imc.game.enums.GameMove;
import com.imc.game.moves.RockPaperScissorsMove;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RockPaperScissorsMoveTest {
    @Test
    public void testGetMove() {
        RockPaperScissorsMove rockMove = new RockPaperScissorsMove(GameMove.ROCK);
        assertEquals(GameMove.ROCK, rockMove.getMove());

        RockPaperScissorsMove paperMove = new RockPaperScissorsMove(GameMove.PAPER);
        assertEquals(GameMove.PAPER, paperMove.getMove());

        RockPaperScissorsMove scissorsMove = new RockPaperScissorsMove(GameMove.SCISSORS);
        assertEquals(GameMove.SCISSORS, scissorsMove.getMove());
    }
}
