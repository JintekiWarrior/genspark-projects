import GameArt.GameArt;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameArtTest {
    GameArt gameArt;
    @BeforeEach
    void setUp() {
        gameArt = new GameArt();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getGameArt() {
        String expected = """
                +---+
                    |
                    |
                    |
                   ===""";
        String actual = gameArt.getGameArt(0);
        assertEquals(expected, actual);
    }
}