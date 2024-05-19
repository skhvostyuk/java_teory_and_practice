//package lessons;

import java.util.Scanner;

public class Lesson61 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();
            char[] c = scanner.nextLine().trim().toCharArray();

            int counter = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < 100 && j + i < n; j++) {
                    if(isVaried(c, i, i + j)) {
                        counter++;
                    }
                }
            }

            System.out.println(counter);

        }
    }

    private static boolean isVaried(char[] c, int start, int end) {
        int[] count = new int[10];

        for(int i = start; i <= end; i++) {
            count[c[i] - '0']++;
        }

        int amount = 0;

        for(int i : count) {
            if(i != 0) {
                amount++;
            }
        }

        for(int i : count) {
            if(i > amount) {
                return false;
            }
        }

        return true;
    }
}
