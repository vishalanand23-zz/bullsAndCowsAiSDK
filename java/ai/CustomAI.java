package ai;

import play.RandomGenerator;
import play.Round;

import java.util.ArrayList;

public class CustomAI implements AI {

    public String guess(int numberOfDigits, ArrayList<Round> rounds) {
        return new RandomGenerator().generate(numberOfDigits);
    }
}
