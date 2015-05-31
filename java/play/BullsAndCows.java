package play;

public class BullsAndCows {

    public Round calculate(String number, String guess) {
        return new Round(
                numberOfBulls(number, guess),
                numberOfCows(number, guess),
                guess);
    }

    private int numberOfCows(String number, String guess) {
        int cowsPlusBulls = 0;
        for (int i = 0; i < number.length(); i++) {
            String a = guess.charAt(i) + "";
            if (number.contains(a)) {
                cowsPlusBulls++;
            }
        }
        return cowsPlusBulls - numberOfBulls(number, guess);
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