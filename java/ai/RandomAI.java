package ai;

import play.RandomGenerator;
import play.Round;

import java.util.ArrayList;

public class RandomAI implements AI {

    private int numberOfDigits;

    public RandomAI(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public String guess(ArrayList<Round> rounds) {
        return new RandomGenerator().generate(numberOfDigits);
    }
}
