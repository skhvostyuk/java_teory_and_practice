package leetcode.dynamic_programming;

import static java.util.Arrays.stream;

import java.util.Arrays;

/**
 * ")()())" -> 4, because "()()"
 */
public class Task32_LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
            }

            if (s.charAt(i) == ')' && s.charAt(i - 1) == ')') {
                if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] - 2 > 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(())"));
        System.out.println(longestValidParentheses(")()"));
        System.out.println(longestValidParentheses("())"));
        System.out.println(longestValidParentheses(")(()))))"));
        System.out.println(longestValidParentheses("()(()"));
    }
}
