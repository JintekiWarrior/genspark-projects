package GameBoard;

import character.Character;
import character.Mage;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;

// Character: Class all characters human or ai inherit
// User
// AI
// Mages
// Monsters
// GameInit
    // Story
    // Movement
    // Fighting

// GameBoard

public class Main
{
    public static void main(String[] args)
    {
        Scanner gameScanner = new Scanner(System.in);
        GameBoard board = new GameBoard();
        Mage iceMage = new Mage("IceBjorn", "Ice", "I", 15, 3, 20, 2);
        Mage fireMage = new Mage("Margma", "Fire", "F", 8, 5, 12, 5);
        iceMage.setRowPosition(6);
        iceMage.setColPosition(4);
        fireMage.setRowPosition(2);
        fireMage.setColPosition(4);
        ArrayList<ArrayList <String>> boardArr = map(board, iceMage, fireMage);
        boardCreate(board, boardArr);

        while (true)
        {
            System.out.println("Where would you like to go?");
            char move = gameScanner.next().charAt(0);
//            if (move == 't') break;
            heroMovement(move, board, iceMage, boardArr);
            boolean enterCombat = board.isGameBoardItemAround(boardArr, fireMage.getRowPosition(), fireMage.getColPosition());
            if (enterCombat) break;
        }

        System.out.println("You have entered combat! Get ready to rumble.");

        gameScanner.close();
    }

    public static void boardCreate(GameBoard board, ArrayList<ArrayList <String>> boardArr)
    {
        String boardStr = board.gameBoardStringCreate(boardArr);
        System.out.println(boardStr);
    }

    public static void heroMovement(char move, GameBoard board, Mage character, ArrayList<ArrayList <String>> boardArr)
    {
//        char move;
//        move = gameScanner.next().charAt(0);
        int positionArr[] = board.moveCharacter(boardArr, move, character.getSymbol(), character.getRowPosition(), character.getColPosition());
//        String boardStr = board.gameBoardStringCreate(boardArr);
        character.setRowPosition(positionArr[0]);
        character.setColPosition(positionArr[1]);
        System.out.println(board.gameBoardStringCreate(boardArr));
    }

    public static ArrayList<ArrayList <String>> map(GameBoard board, Mage hero, Mage enemy)
    {
        ArrayList<ArrayList <String>> boardArr = board.gameBoardListCreate();
        board.gameBoardListUpdate(boardArr, hero.getRowPosition(), hero.getColPosition(), hero.getSymbol());
        board.gameBoardListUpdate(boardArr, enemy.getRowPosition(), enemy.getColPosition(), enemy.getSymbol());
        for (int i = 0; i < boardArr.size(); i++)
        {
            board.gameBoardListUpdate(boardArr, i, 0, "A");
        }

        for (int i = 4; i > 1; i--)
        {
            board.gameBoardListUpdate(boardArr, i, 1, "A");
        }

        for (int i = 0; i < boardArr.size(); i++)
        {
            board.gameBoardListUpdate(boardArr, i, 8, "A");
        }

        for (int i = 4; i > 1; i--)
        {
            board.gameBoardListUpdate(boardArr, i, 7, "A");
        }

        board.gameBoardListUpdate(boardArr, 3, 2, "A");
        board.gameBoardListUpdate(boardArr, 3, 6, "A");

        return boardArr;
    }
}
