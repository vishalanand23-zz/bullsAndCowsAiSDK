package play;

import ai.*;

import java.io.IOException;
import java.util.ArrayList;

public class Play {
    public static void main(String[] args) throws IOException {
        BullsAndCows bullsAndCows = new BullsAndCows();
        int numberOfGuesses;
        double totalGuesses = 0.0;
        int alphabetSize = Integer.valueOf(args[0]);
        int numberOfDigits = Integer.valueOf(args[1]);
        int numberOfTries = Integer.valueOf(args[2]);
        AI aI = new CustomAI();
        for (int i = 0; i < numberOfTries; i++) {
            String number = new RandomGenerator().generate(numberOfDigits);
            numberOfGuesses = 0;
            ArrayList<Round> rounds = new ArrayList<Round>();
            while (true) {
                String guess = aI.guess(numberOfDigits, rounds);
                Round round = bullsAndCows.calculate(number, guess);
                rounds.add(round);
                numberOfGuesses++;
                if (round.getBulls() == numberOfDigits) {
                    totalGuesses = totalGuesses + numberOfGuesses;
                    break;
                }
            }
        }
        double averageGuesses = totalGuesses / numberOfTries;
        System.out.println(averageGuesses);
    }
}
