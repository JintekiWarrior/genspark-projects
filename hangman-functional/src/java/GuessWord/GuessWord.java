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

    private ArrayList<String> missedLettersList;
    private String missedLetters;

    public GuessWord(String word)
    {
        this.word = word;
        wordList = generateWordList();
        mainWordList = generateMainWordList();

        missedLettersList = new ArrayList<>();
        missedLetters = "Missed Letters: ";
    }

    // generates a list containing each letter as an element
    private ArrayList<String> generateWordList()
    {
        ArrayList<String> wordList;
        String[] wordSplit = word.split("");
        wordList = new ArrayList<>(Arrays.asList(wordSplit));
        return wordList;
    }

    // generate an empty space for each character the word has
    private ArrayList<String> generateMainWordList()
    {
        ArrayList<String> mainWordList = new ArrayList<>();
        wordList.stream().forEach(item -> mainWordList.add("_"));
        return mainWordList;
    }

    // sets the main word list which is what will be updated, joined, and displayed to the user
    public void setMainWordList(String letter)
    {
        if (wordList.contains(letter))
        {
            int index = wordList.indexOf(letter);
            mainWordList.set(index, letter);
        } else System.out.println("Error no letter contained in list");
    }

    public void setMissedLetters(String letter)
    {
        missedLetters += letter + " ";
        missedLettersList.add("letter");
    }

    public String getMainWord()
    {
        return mainWordList.stream().collect(Collectors.joining(" "));
    }

    public String getMissedLetters()
    {
        return missedLetters;
    }

    public int getMissedLettersListSize()
    {
        return missedLettersList.size();
    }

    public boolean isInMainWord(String letter)
    {
        return wordList.contains(letter);
    }

    public boolean isMissedLettersGreaterThan(int num)
    {
        return missedLettersList.size() > num ? true : false;
    }

}
