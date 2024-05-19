package leetcode.array;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = s.length() - 1, p = length;

        while (p >=0 && s.charAt(p) == ' ') {
            p--;
            length--;
        }

        while (p >=0 && s.charAt(p) != ' ') {
            p--;
        }
        return length - p;
    }

    @Test
    public void tests() {
        Assertions.assertEquals(5, lengthOfLastWord("22 55555"));
        Assertions.assertEquals(5, lengthOfLastWord("55555"));
        Assertions.assertEquals(5, lengthOfLastWord("   22 55555  "));

    }
}
