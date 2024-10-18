// Name: Nate Saltzman
import game.*;
import util.HangmanDictionary;


/**
 * This class launches the Hangman game and plays once.
 *
 * @author Michael Hewner
 * @author Mac Mason
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */





public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;

    public static void main(String[] args) {
        HangmanDictionary dictionary = new HangmanDictionary(DICTIONARY);

        // Choose the guesser and executioner
        Guesser guesser = new AutoGuesser();  // new UserGuesser();
        Executioner executioner = new CheatingExecutioner(dictionary, NUM_LETTERS);  // new Executioner(dictionary, NUM_LETTERS);

        new HangmanGame(guesser, executioner, NUM_MISSES).play();
    }
}

