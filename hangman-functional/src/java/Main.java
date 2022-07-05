import GameArt.GameArt;
import GuessWord.GuessWord;
import RandomWordGenerator.RandomWordGenerator;

import java.util.Locale;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

// generate word
// generate gameArt
// function to ask player to guess the word
// check to see if the letter is in the word
public class Main
{
    public static void main(String[] args)
    {
        Scanner gameScanner = new Scanner(System.in);
        GameArt gameArt = new GameArt();
        RandomWordGenerator randomWord = new RandomWordGenerator();
        GuessWord guessWord = new GuessWord(randomWord.getWord());
        boolean playAgain = true;
        // counts the rounds
        int round = 0;

        while (playAgain)
        {
            if (round == 0)
            {
                randomWord = new RandomWordGenerator();
                guessWord = new GuessWord(randomWord.getWord());
            }
            System.out.println(randomWord.getWord());

            displayGame(guessWord.getMissedLettersListSize(), gameArt, guessWord);
            handleGuess(guessWord);

            boolean win = !guessWord.getMainWord().contains("_");
            boolean lose = guessWord.isMissedLettersGreaterThan(3);
            round++;
            if (win || lose)
            {
                // check for win
                if (win)
                {
                    System.out.println("Congrats you won");
                } else
                {
                    System.out.println("Your dead. Better luck next life.");
                }
                round = 0;
                playAgain = playAgainDisplay();
            }
        }
    }

    // checks if the user wants to play again
    public static boolean playAgainDisplay()
    {
        Scanner gameScanner = new Scanner(System.in);
        System.out.println("Would you like to play again? (Y or N)");
        String yesOrNo = "";
        try
        {
            yesOrNo = gameScanner.nextLine().toLowerCase();
        } catch (Exception e)
        {
            System.out.println(e.getClass().getName());
        }

        if (yesOrNo.equals("n"))
        {
            System.out.println("Have fun in the real world.");
            gameScanner.close();
            return false;
        } else
        {
            return true;
        }
    }

    // displays the game for the user
    public static void displayGame(int index, GameArt gameArt, GuessWord word)
    {
        System.out.println(gameArt.getGameArt(index));
        System.out.println(word.getMissedLetters());
        System.out.println(word.getMainWord());
    }

    public static void handleGuess(GuessWord word)
    {
        // ask user to guess a letter
        Scanner gameScanner = new Scanner(System.in);
        System.out.println("Guess a letter");
        String guess = "";
        try
        {
            guess = gameScanner.nextLine().toUpperCase();

            if (guess.length() > 1 || !guess.matches("[a-zA-Z]+"))
            {
                throw new Exception("Not a valid guess");
            }
        } catch (Exception e)
        {
            System.out.println(e.getClass().getName());
        }
        // check if the letter is in the word
        if (word.isInMainWord(guess))
        {
            word.setMainWordList(guess);
        } else
        {
            word.setMissedLetters(guess);
        }
    }
}
