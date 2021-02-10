package theory;

public class AliTest {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length/2 + 1; i++) {
            if (chars[i] != chars[chars.length - i])
                return false;
        }
        return true;
    }
}
