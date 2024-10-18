// Name: Nate Saltzman

package game;

public class HangmanGame {
    private Guesser guesser;
    private Executioner executioner;
    private int myNumGuessesLeft;

    public HangmanGame(Guesser guesser, Executioner executioner, int numGuesses) {
        this.guesser = guesser;
        this.executioner = executioner;
        this.myNumGuessesLeft = numGuesses;
    }

    public void play() {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();

            char guess = guesser.makeGuess();

            if (!guesser.hasGuessed(guess)) {
                guesser.recordGuess(guess);

                if (!executioner.checkGuessInSecret(guess)) {
                    myNumGuessesLeft--;
                }

                if (isGameLost()) {
                    System.out.println("YOU ARE HUNG!!!");
                    gameOver = true;
                } else if (isGameWon()) {
                    System.out.println("YOU WIN!!!");
                    gameOver = true;
                }
            } else {
                System.out.println("You've already guessed that letter.");
            }
        }
        System.out.println("The secret word was " + executioner.getSecretWord());
    }

    public boolean isGameWon() {
        return executioner.isWordGuessed();
    }

    public boolean isGameLost() {
        return myNumGuessesLeft == 0;
    }

    private void printStatus() {
        System.out.println(executioner.getDisplayWord());
        System.out.println("# misses left = " + myNumGuessesLeft);
        System.out.println("letters not yet guessed = " + guesser.getLettersLeftToGuess());
        // Remove below if not testing
        System.out.println("*** " + executioner.mySecretWord);
    }
}
