import GuessWord.GuessWord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessWordTest
{
    GuessWord word;
    @BeforeEach
    void setUp()
    {
        word = new GuessWord("CHAR");
    }

    @Test
    void setMainWordList()
    {
        word.setMainWordList("A");
        String expected = "_ _ A _";
        String actual = word.getMainWord();
        assertEquals(expected, actual);
    }

    @Test
    void setMissedLetters()
    {
        word.setMissedLetters("B");
        String expected = "Missed Letters: B";
        String actual = word.getMissedLetters();
        assertEquals(expected, actual);
    }

    @Test
    void getMainWord()
    {
        String expected = "_ _ _ _";
        String actual = word.getMainWord();
        assertEquals(expected, actual);
    }

    @Test
    void getMissedLetters()
    {
        String expected = "Missed Letters:";
        String actual = word.getMissedLetters();
        assertEquals(expected, actual);
    }

    @Test
    void getMissedLettersListSize()
    {
        // if empty
        int expected = 0;
        int actual = word.getMissedLettersListSize();
        assertEquals(expected, actual);

        // if list size contains one
        word.setMissedLetters("B");
        expected = 1;
        actual = word.getMissedLettersListSize();
        assertEquals(expected, actual);
    }

    @Test
    void isInMainWord()
    {
        // if the letter is NOT contained in the list
        boolean expected = false;
        boolean actual = word.isInMainWord("O");
        assertEquals(expected, actual);

        // if the letter IS contained in the list
        expected = true;
        actual = word.isInMainWord("C");
        assertEquals(expected, actual);
    }

    @Test
    void isMissedLettersGreaterThan()
    {
        boolean expected = false;
        boolean actual = word.isMissedLettersGreaterThan(3);
        assertEquals(expected, actual);

        expected = true;
        actual = word.isMissedLettersGreaterThan(-1);
        assertEquals(expected, actual);
    }
}