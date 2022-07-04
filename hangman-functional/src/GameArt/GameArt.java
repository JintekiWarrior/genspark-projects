package GameArt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameArt {
    private static ArrayList<ArrayList <String>> gameArtList;
    public GameArt()
    {
        gameArtList = initializeGameArt();

    }

    private ArrayList<ArrayList<String>> initializeGameArt()
    {
        File file;
        // make the art in a file
        // read the art
        file = new File("C:\\Users\\moeya\\Documents\\programming\\Java\\genspark-projects\\hangman-functional\\src\\resources\\hangmanArt.txt");
        ArrayList<ArrayList <String>> outer = new ArrayList<>();
        ArrayList<String> inner;
        String st = "";
        try
        {
            BufferedReader fr = new BufferedReader(new FileReader(file));
            st = fr.readLine();
            while(st != null)
            {
                inner = new ArrayList<>();
                for (int i = 0; i < 5; i++)
                {
                    inner.add(st);
                    st = fr.readLine();
                }
                outer.add(inner);
            }

        } catch (Exception e)
        {
            System.out.println("Error: " + e.getMessage());
        }

        return outer;
    }

    // function to grab elements in the array
    private String gameArtPiece(ArrayList<String> arr)
    {
        return arr.stream().collect(Collectors.joining("\n"));
    }

    public String getGameArt(int index)
    {
        return gameArtPiece(gameArtList.get(index));
    }
}
