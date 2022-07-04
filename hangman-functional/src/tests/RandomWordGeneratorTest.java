import RandomWordGenerator.RandomWordGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomWordGeneratorTest {

    RandomWordGenerator word;
    @BeforeEach
    void setUp() {
        word = new RandomWordGenerator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getWord() {
        String actual = word.getWord();
        assertNotEquals("", actual);
    }
}