package play;

import ai.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Play {
    public static void main(String[] args) throws IOException {
        BullsAndCows bullsAndCows = new BullsAndCows();
        double numberOfGuesses;
        int alphabetSize = Integer.valueOf(args[0]);
        int numberOfDigits = Integer.valueOf(args[1]);
        int numberOfTries = Integer.valueOf(args[2]);
        ArrayList<Double> roundsArray = new ArrayList<Double>();
        for (int i = 0; i < numberOfTries; i++) {
            AI aI = new CustomAI();
            String number = new RandomGenerator().generate(numberOfDigits);
            if (number.length() != numberOfDigits) {
                throw new RuntimeException("Invalid Input");
            }
            numberOfGuesses = 0.0;
            ArrayList<Round> rounds = new ArrayList<Round>();
            while (true) {
                String guess = aI.guess(numberOfDigits, rounds);
                if (guess.length() != numberOfDigits) {
                    throw new RuntimeException("Invalid Input");
                }
                Round round = bullsAndCows.calculate(number, guess);
                rounds.add(round);
                numberOfGuesses++;
                if (round.getBulls() == numberOfDigits) {
                    break;
                }
            }
            roundsArray.add(numberOfGuesses);
        }
        Collections.sort(roundsArray);
        double totalGuesses = 0.0;
        for (Double round : roundsArray) {
            totalGuesses+= round;
        }
        double averageGuesses = totalGuesses / numberOfTries;
        System.out.println(averageGuesses);
        System.out.println(roundsArray.get(0));
        System.out.println(roundsArray.get(roundsArray.size() - 1));
        System.out.println(roundsArray.get(Integer.valueOf(roundsArray.size()/2 - 1)));
    }
}
