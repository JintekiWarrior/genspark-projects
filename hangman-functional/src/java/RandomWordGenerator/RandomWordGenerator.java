package RandomWordGenerator;

import java.lang.constant.Constable;

public class RandomWordGenerator {
    private String[] wordList = // { "CHAR", "ASSERT" }; // Used for testing
            {
                    "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE",
                    "CASE", "CATCH", "CHAR", "CLASS", "CONST",
                    "CONTINUE", "DEFAULT", "DOUBLE", "DO", "ELSE",
                    "ENUM", "EXTENDS", "FALSE", "FINAL", "FINALLY",
                    "FLOAT", "FOR", "GOTO", "IF", "IMPLEMENTS",
                    "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG",
                    "NATIVE", "NEW", "NULL", "PACKAGE", "PRIVATE",
                    "PROTECTED", "PUBLIC", "RETURN", "SHORT", "STATIC",
                    "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED",
                    "THIS", "THROW", "THROWS", "TRANSIENT", "TRUE",
                    "TRY", "VOID", "VOLATILE", "WHILE"
            };

    private String word;
    public RandomWordGenerator() {
        word = generateWord();
    }

    private String generateWord()
    {
        int randomNumber = (int)Math.floor(Math.random()*(wordList.length - 1) + 1);
        return wordList[randomNumber];
    }

    public String getWord() {
        return word;
    }
}
