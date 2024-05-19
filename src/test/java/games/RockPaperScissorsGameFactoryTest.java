package games;

import com.imc.game.games.Game;
import com.imc.game.games.GameFactory;
import com.imc.game.games.RockPaperScissorsGame;
import com.imc.game.games.RockPaperScissorsGameFactory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RockPaperScissorsGameFactoryTest {
    @Test
    public void testCreateGame_returnsRockPaperScissorsGame() {
        GameFactory factory = new RockPaperScissorsGameFactory(null);
        Game game = factory.createGame();
        assertTrue(game instanceof RockPaperScissorsGame);
    }
}
