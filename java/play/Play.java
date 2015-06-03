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
        for (int i = 0; i < numberOfTries; i++) {
            AI aI = new CustomAI();
            String number = new RandomGenerator().generate(numberOfDigits);
            if (number.length() != numberOfDigits) {
                throw new RuntimeException("Invalid Input");
            }
            numberOfGuesses = 0;
            ArrayList<Round> rounds = new ArrayList<Round>();
            while (true) {
                String guess = aI.guess(numberOfDigits, rounds);
                if (guess.length() != numberOfDigits) {
                    throw new RuntimeException("Invalid Input");
                }
                Round round = bullsAndCows.calculate(number, guess);
                rounds.add(round);
                numberOfGuesses++;
                if (numberOfGuesses > 10) {
                    return;
                }
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
