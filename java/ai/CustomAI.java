package ai;

import play.RandomGenerator;
import play.Round;

import java.util.ArrayList;

public class CustomAI implements AI {

    private final int numberOfDigits;

    public CustomAI(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
    }

    public String guess(ArrayList<Round> rounds) {
        return new RandomGenerator().generate(numberOfDigits);
    }
}
