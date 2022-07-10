package GameBoard;

//     ___ ___ ___ ___ ___ ___ ___ ___ ___ ___
//    |   |   |   |   |   |   |   |   |   |   |
//    |___|___|___|___|___|___|___|___|___|___|
//    |   |   |   |   |   |   |   |   |   |   |
//    |___|___|___|___|___|___|___|___|___|___|
//    |   |   |   |   |   |   |   |   |   |   |
//    |___|___|___|___|___|___|___|___|___|___|
//    |   |   |   |   |   |   |   |   |   |   |
//    |___|___|___|___|___|___|___|___|___|___|
//    |   |   |   |   |   |   |   |   |   |   |
//    |___|___|___|___|___|___|___|___|___|___|
//    |   |   |   |   |   |   |   |   |   |   |
//    |___|___|___|___|___|___|___|___|___|___|

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameBoard {

    // creates a row of squares in the gameBoard
    private ArrayList<String> gameBoardRowListCreate()
    {
        ArrayList<String> result = new ArrayList<>();

        // first column is different then the rest
        String topStart = " ___ ";
        String middleStart = "|   |";
        String bottomStart = "|___|";

        String topMain = "___ ";
        String middleMain = "   |";
        String bottomMain = "___|";
        for (int i = 0; i < 10; i++)
        {
            if (i == 0)
            {
                result.add(topStart);
                result.add(middleStart);
                result.add(bottomStart);
            }else
            {
                result.add(topMain);
                result.add(middleMain);
                result.add(bottomMain);
            }
        }
        Collections.sort(result);

        return result;
    }

    // method to join the array list back to a string of blocks.
    private String joinArrayList(ArrayList<String> gameBoardRowList, int index)
    {
        // Items that go to the first column
        String startTop = gameBoardRowList.get(9);
        String startMiddle = gameBoardRowList.get(28);
        String startBottom = gameBoardRowList.get(29);

        List<String> gameBoardTopList = gameBoardRowList.subList(10, 18);
        List<String> gameBoardMidList = gameBoardRowList.subList(0, 8);
        List<String> gameBoardBotList = gameBoardRowList.subList(19, 27);

        String gameBoardTop = String.join("", gameBoardTopList);
        String gameBoardMid = String.join("", gameBoardMidList);
        String gameBoardBot = String.join("", gameBoardBotList);

        // only the top row needs to have a top.
        if (index == 0) return startTop + gameBoardTop + "\n" + startMiddle + gameBoardMid + "\n" + startBottom + gameBoardBot + "\n";
        else if (index == 6) return startMiddle + gameBoardMid + "\n" + startBottom + gameBoardBot;
        else return startMiddle + gameBoardMid + "\n" + startBottom + gameBoardBot + "\n";
    }

    // method to create the list of the gameBoard used internally mostly
    public ArrayList gameBoardListCreate()
    {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = 0; i < 7; i++)
        {
            result.add(gameBoardRowListCreate());
        }
        return result;
    }

    // method to take a list of the gameboard and join it to a string
    // use externally to display the gameBoard
    public String gameBoardStringCreate(ArrayList<ArrayList <String>> arr)
    {
        String result = "";
        for (int i = 0; i < 7; i++)
        {
            result = result + this.joinArrayList(arr.get(i), i);
        }
        return result;
    }

    // this updates the middle item in a block in a row
    // row should be 1 - 7 and column 1 - 9
    public void gameBoardListUpdate(ArrayList<ArrayList <String>> arr, int row, int col, String item)
    {
        if (row < 0 || row > 6) {
            System.out.println("Row out of bounds");
            return;
        } else if (col < 0 || col > 8)
        {
            System.out.println("Column is out of bounds");
            return;
        }
        // first column is different then the rest
        if (col == 0)
        {
            ArrayList<String> updateRow = arr.get(row);
            updateRow.set(28, "| " + item + " |");
        } else
        {
            ArrayList<String> updateRow = arr.get(row);
            updateRow.set(col - 1, " " + item + " |");
        }
    }

    // remove item from the gameBoardList
    // used internally
    public void gameBoardListRemove(ArrayList<ArrayList <String>> arr, int row, int col)
    {
        if (row < 0 || row > 6) {
            System.out.println("Row out of bounds");
            return;
        } else if (col < 0 || col > 8)
        {
            System.out.println("Column is out of bounds");
            return;
        }
        // first column is different then the rest
        if (col == 0)
        {
            ArrayList<String> updateRow = arr.get(row);
            updateRow.set(28, "|   |");
        } else
        {
            ArrayList<String> updateRow = arr.get(row);
            updateRow.set(col - 1, "   |");
        }
    }

    // returns true if there is a block on the board
    // used internally
    public boolean isGameBoardItem(ArrayList<ArrayList <String>> arr, int row, int col)
    {
        if (row < 0 || row > 6) {
            System.out.println("Row out of bounds from isGameItem");
            return true;
        } else if (col < 0 || col > 8)
        {
            System.out.println("Column is out of bounds from isGameItem");
            return true;
        }
        ArrayList<String> checkRow = arr.get(row);
        String check;
        String[] elementArr;

        if (col == 0)
        {
            elementArr = checkRow.get(28).split("");
            check = (String) Array.get(elementArr, 2);
        } else
        {
            elementArr = checkRow.get(col - 1).split("");
            check = (String) Array.get(elementArr, 1);
        }

        return !check.equals(" ");
    }

    // check if there are any elements in the surrounding blocks of an element
    public boolean isGameBoardItemAround(ArrayList<ArrayList <String>> arr, int row, int col)
    {
        boolean isAround = false;
        int rowCheck = row - 1;
        while (!isAround && rowCheck <= row + 1)
        {
            for (int i = col - 1; i <= col + 1; i++)
            {
                if (rowCheck != row || i != col)
                {
                    isAround = isGameBoardItem(arr, rowCheck, i);
                }
            }
            rowCheck++;
        }
        return isAround;
    }

    // Moves the character by inputing the current position as well as returns the updated position
    // The updated position is returned so that we can recursively use this method as well as keep track of the character
    // used externally
    public int[] moveCharacter(ArrayList<ArrayList <String>> arr, char input, String charSymbol, int row, int col)
    {
        int rowPrevious = row;
        int colPrevious = col;
        int rowCurrent = row;
        int colCurrent = col;
        int rowCheck;
        int colCheck;
        int[] position = new int[2];

        switch (input)
        {
            case 'w':
                rowCheck = rowCurrent - 1;
                // need to use this function as you need to know if the box you are moving to is taken or not.
                if (!this.isGameBoardItem(arr, rowCheck, colCurrent))
                {
                    rowCurrent--;
                    this.gameBoardListRemove(arr, rowPrevious, colPrevious);
                    this.gameBoardListUpdate(arr, rowCurrent, colCurrent, charSymbol);
                    position[0] = rowCurrent;
                    position[1] = colCurrent;
                }
                break;
            case 's':
                rowCheck = rowCurrent + 1;
                if (!this.isGameBoardItem(arr, rowCheck, colCurrent))
                {
                    rowCurrent++;
                    this.gameBoardListRemove(arr, rowPrevious, colPrevious);
                    this.gameBoardListUpdate(arr, rowCurrent, colCurrent, charSymbol);
                    position[0] = rowCurrent;
                    position[1] = colCurrent;
                }
                break;
            case 'd':
                colCheck = colCurrent + 1;
                if (!this.isGameBoardItem(arr, rowCurrent, colCheck))
                {
                    colCurrent++;
                    this.gameBoardListRemove(arr, rowPrevious, colPrevious);
                    this.gameBoardListUpdate(arr, rowCurrent, colCurrent, charSymbol);
                    position[0] = rowCurrent;
                    position[1] = colCurrent;
                }
                break;
            case 'a':
                colCheck = colCurrent - 1;
                if (!this.isGameBoardItem(arr, rowCurrent, colCheck))
                {
                    colCurrent--;
                    this.gameBoardListRemove(arr, rowPrevious, colPrevious);
                    this.gameBoardListUpdate(arr, rowCurrent, colCurrent, charSymbol);
                    position[0] = rowCurrent;
                    position[1] = colCurrent;
                }
                break;
            default:
                System.out.println("Wrong input");
                position[0] = rowPrevious;
                position[1] = colPrevious;
        }
        if (position[0] == 0 && position[1] == 0) {
            position[0] = rowPrevious;
            position[1] = colPrevious;
        }
        return position;
    }
}
