package ai;

import play.Round;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CommandLine implements AI {
    private BufferedReader br;
    private final int numberOfDigits;

    public CommandLine(int numberOfDigits) {
        this.numberOfDigits = numberOfDigits;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String guess(ArrayList<Round> rounds) throws IOException {
        System.out.println("Take a guess. Number of guesses yet = " + rounds.size());
        int i = 1;
        for (Round round : rounds) {
            System.out.println("Round: " + i);
            i++;
            System.out.println("Bulls:" + round.getBulls());
            System.out.println("Cows:" + round.getCows());
        }
        String response = br.readLine();
        if (response.length() == numberOfDigits) {
            return response;
        }
        System.out.println("Invalid response quitting.");
        throw new RuntimeException("Invalid response");
    }
}
