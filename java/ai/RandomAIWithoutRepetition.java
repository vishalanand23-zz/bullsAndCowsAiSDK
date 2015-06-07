package ai;

import play.RandomGenerator;
import play.Round;

import java.util.ArrayList;

public class RandomAIWithoutRepetition implements AI {
    private int numberOfDigits;

    public RandomAIWithoutRepetition(int numberOfDigits) {

        this.numberOfDigits = numberOfDigits;
    }
    public String guess(ArrayList<Round> rounds) {
        boolean selected = true;
        String guess = new RandomGenerator().generate(numberOfDigits);
        for (Round round : rounds) {
            if (round.getGuess().equals(guess)) {
                selected = false;
                break;
            }
        }
        if (selected) {
            return guess;
        }
        return guess(rounds);
    }
}
