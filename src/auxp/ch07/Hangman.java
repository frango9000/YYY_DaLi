package auxp.ch07;

import lib.Data.ArrayManip;

import java.util.Arrays;

import static lib.Misc.IO.print;
import static lib.Misc.IO.scanChar;
import static lib.Misc.Randomizer.randomInt;

public class Hangman {

    public static void startGame(String[] words) {
        if (words == null) words = new String[]{"water", "fishing", "natural", "programming"};
        String word = words[randomInt(4)];
        char[] covered = new char[word.length()];
        Arrays.fill(covered, '*');
        int tries = 0;
        while (ArrayManip.contains(covered, '*') && tries < 10) {

            char guess =
                    Character.toLowerCase(
                            scanChar("(Guess) %d/10 Enter a letter in word %s", tries, String.valueOf(covered)));
            boolean miss = true;
            if (!ArrayManip.contains(covered, Character.toLowerCase(guess))) {
                for (int i = 0; i < word.length(); i++) {
                    if (Character.toLowerCase(guess) == Character.toLowerCase(word.charAt(i))) {
                        covered[i] = word.charAt(i);
                        miss = false;
                    }
                }
            }
            if (miss) tries++;
        }
        if (ArrayManip.contains(covered, '*'))
            print("You lose, word is %s your best %s", word, String.valueOf(covered));
        else print("You win word %s", String.valueOf(covered));
    }
}
