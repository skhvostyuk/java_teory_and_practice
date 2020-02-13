package leetcode.string;

public class Task125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        try {
            System.out.println("1");
            throw new Exception();
        } catch (Exception e) {
            System.exit(0);
        } finally {
            System.out.println("3");
        }


        System.exit(0);
        System.out.println("fdfdf");

        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }


}
