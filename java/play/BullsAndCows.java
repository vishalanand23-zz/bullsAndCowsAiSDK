package play;

public class BullsAndCows {

    public Round calculate(String number, String guess) {
        int bulls = numberOfBulls(number, guess);
        int cowsPlusBulls = numberOfCowsPlusBulls(number, guess);
        return new Round(
                bulls,
                cowsPlusBulls - bulls,
                guess);
    }

    private int numberOfCowsPlusBulls(String number, String guess) {
        int cowsPlusBulls = 0;
        int inGuess[] = new int[10];
        for (int i = 0; i < number.length(); i++) {
            inGuess[Character.getNumericValue(guess.charAt(i))] = 1;
        }
        for (int i = 0; i < number.length(); ++i) {
            if (inGuess[Character.getNumericValue(number.charAt(i))] == 1) {
                cowsPlusBulls++;
            }
        }
        return cowsPlusBulls;
    }

    private int numberOfBulls(String number, String guess) {
        int bulls = 0;
        for (int i = 0; i < number.length(); i++) {
            if (guess.charAt(i) == number.charAt(i)) bulls++;
        }
        return bulls;
    }

    public static void main(String args[]) {
        System.out.println(new BullsAndCows().calculate("123456", "023657"));
    }
}