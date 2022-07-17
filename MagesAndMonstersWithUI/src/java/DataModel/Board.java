package DataModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Board
{
    private ArrayList<ObservableList<String>> mainBoard;

    public void Board()
    {
        mainBoard = createBoard();
    }

    private ObservableList<String> createRow()
    {
        ObservableList<String> arr = FXCollections.observableArrayList();
        for (int i = 0; i < 8; i++) arr.add("");
        return arr;
    }

    private ArrayList<ObservableList<String>> createBoard()
    {
        ArrayList<ObservableList<String>> arr = new ArrayList<>();
        ObservableList<String> innerArr = createRow();
        for (int i = 0; i < 8; i++) arr.add(innerArr);
        return arr;
    }

    public ArrayList<ObservableList<String>> getMainBoard()
    {
        return mainBoard;
    }

    public void setMainBoard(String item, int row, int col)
    {
        ObservableList<String> inner = mainBoard.get(row);
        inner.set(col, item);
    }
}
