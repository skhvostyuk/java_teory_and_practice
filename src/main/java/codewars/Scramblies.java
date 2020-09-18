package codewars;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class Scramblies {

    // best practice on codewars uses contains, should measure performance
    public static boolean scramble(String str1, String str2) {
        char[] alphabet = str1.toCharArray();
        Arrays.sort(alphabet);
        char[] word = str2.toCharArray();
        Arrays.sort(word);

        int i = 0, j = 0;
        while (i < word.length) {
            if (j < alphabet.length && word[i] == alphabet[j]) {
                i++;
                j++;
            } else if (j < alphabet.length && word[i] > alphabet[j]) {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }


    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests scramble");
        testing(Scramblies.scramble("rkqodlw", "world"), true);
        testing(Scramblies.scramble("cedewaraaossoqqyt", "codewars"), true);
        testing(Scramblies.scramble("katas", "steak"), false);
        testing(Scramblies.scramble("scriptjavx", "javascript"), false);
        testing(Scramblies.scramble("scriptingjava", "javascript"), true);
        testing(Scramblies.scramble("scriptsjava", "javascripts"), true);
        testing(Scramblies.scramble("javscripts", "javascript"), false);
        testing(Scramblies.scramble("aabbcamaomsccdd", "commas"), true);
        testing(Scramblies.scramble("commas", "commas"), true);
        testing(Scramblies.scramble("sammoc", "commas"), true);
    }
}
