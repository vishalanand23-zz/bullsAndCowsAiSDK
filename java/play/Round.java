package play;

public class Round {
    int bulls;
    int cows;
    String guess;

    public Round(int bulls, int cows, String guess) {
        this.bulls = bulls;
        this.cows = cows;
        this.guess = guess;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }

    public String getGuess() {
        return guess;
    }
}
