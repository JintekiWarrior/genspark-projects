package GuessWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

// Takes a word as a string
// stores the word in an array
// generates the placeholders for the length of the word
// updates the placeholder of the word
public class GuessWord {
    private final String word;
    private final ArrayList<String> wordList;
    private ArrayList<String> mainWordList;

    public GuessWord(String word)
    {
        this.word = word;
        wordList = generateWordList();
        mainWordList = generateEmptyWordList();
    }

    private ArrayList<String> generateWordList()
    {
        ArrayList<String> wordList;
        String[] wordSplit = word.split("");
        wordList = new ArrayList<>(Arrays.asList(wordSplit));
        return wordList;
    }

    private ArrayList<String> generateEmptyWordList()
    {
        ArrayList<String> mainWordList = new ArrayList<>();
        wordList.stream().forEach(item -> mainWordList.add("_"));
        return mainWordList;
    }

    private void setMainWordList(String letter)
    {
        if (wordList.contains(letter))
        {
            int index = wordList.indexOf(letter);
            mainWordList.set(index, letter);
        } else System.out.println("Error no letter contained in list");
    }

    public String getMainWordList()
    {
        return mainWordList.stream().collect(Collectors.joining(""));
    }
}
