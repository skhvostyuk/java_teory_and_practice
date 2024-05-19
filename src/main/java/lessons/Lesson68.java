package lessons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Lesson68 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String T = scanner.nextLine();
        String S = scanner.nextLine();

        int[] needCounter = new int[('z' - 'a')];
        int[] counter = new int[('z' - 'a')];

        if (T.length() < S.length()) {
            System.out.println("NO");
            return;
        }
        if (S.isEmpty()) {
            System.out.println("");
            return;
        }

        for (int i = 0; i < S.length(); i++) {
            needCounter[S.charAt(i) - 'a']++;
        }

        for (int i = 0; i < S.length(); i++) {
            counter[T.charAt(i) - 'a']++;
        }

        if (isEqual(counter, needCounter) == 0) {
            System.out.println(T.substring(0, S.length()));
            return;
        }

        for (int i = 1; i <= T.length() - S.length(); i++) {
            counter[T.charAt(i - 1) - 'a']--;
            counter[T.charAt(i + S.length() - 1) - 'a']++;

            int c = isEqual(counter, needCounter);
            if(c == 0) {
                System.out.println(T.substring(i, i + S.length()));
                return;
            }
            i += c/2 - 1;
        }

        System.out.println("NO");
    }

    public static int isEqual(int[] first, int[] second) {
        int counter = 0;
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                counter += Math.max(first[i], second[i]) - Math.min(first[i], second[i]);
            }
        }

        return counter;
    }
}
