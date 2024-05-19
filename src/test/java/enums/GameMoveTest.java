package enums;

import com.imc.game.enums.GameMove;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameMoveTest {

    @Test
    public void testToString() {
        assertEquals("ROCK", GameMove.ROCK.toString());
        assertEquals("PAPER", GameMove.PAPER.toString());
        assertEquals("SCISSORS", GameMove.SCISSORS.toString());
    }
}
