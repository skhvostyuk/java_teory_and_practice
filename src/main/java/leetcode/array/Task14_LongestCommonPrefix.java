package leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        boolean lookNext = true;

        while (lookNext) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    lookNext = false;
                    break;
                }
            }
            i++;
        }
        return strs[0].substring(0, i - 1);
    }
    @Test
    public void tests() {

        Assertions.assertEquals("f", longestCommonPrefix(new String[]{"f","flow","fllll"}));
        Assertions.assertEquals("", longestCommonPrefix(new String[]{"dog","racecar","car"}));
        Assertions.assertEquals("f", longestCommonPrefix(new String[]{"f","f","f"}));

    }
}
