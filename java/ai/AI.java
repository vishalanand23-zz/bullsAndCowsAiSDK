package ai;

import play.Round;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by anandv on 5/29/15.
 */
public interface AI {
    String guess(int numberOfDigits, ArrayList<Round> rounds) throws IOException;
}
