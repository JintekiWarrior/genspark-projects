package GameBoard;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    GameBoard board;
    @BeforeEach
    void setUp()
    {
        board = new GameBoard();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    // test for an ArrayList inside an ArrayList
    void gameBoardListCreate()
    {
        // test the size of the outer array
        ArrayList<ArrayList <String>> boardList = board.gameBoardListCreate();
        int boardListSize = 7;
        assertTrue(boardList.size() == boardListSize);

        // test the size of the inner arrays
        ArrayList<String> innerBoardList = boardList.get(0);
        assertTrue(innerBoardList.size() == 30);
    }

    @Test
    void gameBoardStringCreate()
    {
        String expected = " ___ ___ ___ ___ ___ ___ ___ ___ ___ \n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|";

        ArrayList<ArrayList <String>> boardList = board.gameBoardListCreate();
        String actual = board.gameBoardStringCreate(boardList);
        assertEquals(expected, actual);
    }

    @Test
    void gameBoardListUpdate() {
        String expected = " ___ ___ ___ ___ ___ ___ ___ ___ ___ \n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   | A |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|";

        ArrayList<ArrayList <String>> boardList = board.gameBoardListCreate();
        board.gameBoardListUpdate(boardList, 1, 3, "A");
        String actual = board.gameBoardStringCreate(boardList);
        assertEquals(expected, actual);

        expected = " ___ ___ ___ ___ ___ ___ ___ ___ ___ \n" +
                "|   |   |   |   |   |   |   |   |   |\n" +
                "|___|___|___|___|___|___|___|___|___|\n" +
                "| A |   |   |   |   |   |   |   |   |\n" +
                "|___|___|___|___|___|___|___|___|___|\n" +
                "|   |   |   |   |   |   |   |   |   |\n" +
                "|___|___|___|___|___|___|___|___|___|\n" +
                "|   |   |   |   |   |   |   |   |   |\n" +
                "|___|___|___|___|___|___|___|___|___|\n" +
                "|   |   |   |   |   |   |   |   |   |\n" +
                "|___|___|___|___|___|___|___|___|___|\n" +
                "|   |   |   |   |   |   |   |   |   |\n" +
                "|___|___|___|___|___|___|___|___|___|\n" +
                "|   |   |   |   |   |   |   |   |   |\n" +
                "|___|___|___|___|___|___|___|___|___|";

        boardList = board.gameBoardListCreate();
        board.gameBoardListUpdate(boardList, 1, 0, "A");
        actual = board.gameBoardStringCreate(boardList);
        assertEquals(expected, actual);
    }

    @Test
    void gameBoardListRemove() {
        String expected = " ___ ___ ___ ___ ___ ___ ___ ___ ___ \n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|";

        ArrayList<ArrayList <String>> boardList = board.gameBoardListCreate();
        board.gameBoardListUpdate(boardList, 1, 4, "A");
        board.gameBoardListRemove(boardList, 1, 4);
        String actual = board.gameBoardStringCreate(boardList);
        assertEquals(expected, actual);

        board.gameBoardListUpdate(boardList, 0, 0, "F");
        board.gameBoardListRemove(boardList, 0, 0);
        actual = board.gameBoardStringCreate(boardList);
        assertEquals(expected, actual);
    }

    @Test
    void gameBoardItemCheck()
    {
        // Check if true if item is in array
        boolean expected;
        boolean actual;
        ArrayList<ArrayList <String>> boardList = board.gameBoardListCreate();
        board.gameBoardListUpdate(boardList, 1, 4, "A");
        expected = true;
        actual = board.isGameBoardItem(boardList, 1, 4);
        assertEquals(expected, actual);

        // Check for false if item is not in array
        board.gameBoardListRemove(boardList, 1, 4);
        expected = false;
        actual = board.isGameBoardItem(boardList, 1, 4);
        assertEquals(expected, actual);

        // Check for true if column is 0
        board.gameBoardListUpdate(boardList, 1, 0, "F");
        expected = true;
        actual = board.isGameBoardItem(boardList, 1, 0);
        assertEquals(expected, actual);

        // Check for false if item is not in array and column is 0
        board.gameBoardListRemove(boardList, 1, 0);
        expected = false;
        actual = board.isGameBoardItem(boardList, 1, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void moveCharacter()
    {
        // test that moveCharacter method works
        ArrayList<ArrayList <String>> boardList = board.gameBoardListCreate();
        board.gameBoardListUpdate(boardList, 0, 0, "A");
        int positionArr[] = board.moveCharacter(boardList, 'd', "A", 0, 0);

        String expected = " ___ ___ ___ ___ ___ ___ ___ ___ ___ \n" +
                          "|   | A |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|\n" +
                          "|   |   |   |   |   |   |   |   |   |\n" +
                          "|___|___|___|___|___|___|___|___|___|";
        String actual = board.gameBoardStringCreate(boardList);
        assertEquals(expected, actual);

        // test for row out of bounds error
        int positionArrNew[] = board.moveCharacter(boardList, 'w', "A", 0, 0);

        expected = " ___ ___ ___ ___ ___ ___ ___ ___ ___ \n" +
                  "|   | A |   |   |   |   |   |   |   |\n" +
                  "|___|___|___|___|___|___|___|___|___|\n" +
                  "|   |   |   |   |   |   |   |   |   |\n" +
                  "|___|___|___|___|___|___|___|___|___|\n" +
                  "|   |   |   |   |   |   |   |   |   |\n" +
                  "|___|___|___|___|___|___|___|___|___|\n" +
                  "|   |   |   |   |   |   |   |   |   |\n" +
                  "|___|___|___|___|___|___|___|___|___|\n" +
                  "|   |   |   |   |   |   |   |   |   |\n" +
                  "|___|___|___|___|___|___|___|___|___|\n" +
                  "|   |   |   |   |   |   |   |   |   |\n" +
                  "|___|___|___|___|___|___|___|___|___|\n" +
                  "|   |   |   |   |   |   |   |   |   |\n" +
                  "|___|___|___|___|___|___|___|___|___|";
        actual = board.gameBoardStringCreate(boardList);
        assertEquals(expected, actual);
    }
}