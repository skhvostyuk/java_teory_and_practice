package codeforces.contest895;//package codeforces.contest1857;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] d = new int[n];
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                d[i] = scanner.nextInt();
                s[i] = scanner.nextInt();
            }

            int maxDistance = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++) {
                maxDistance = Math.min(maxDistance, d[i] + ((s[i] - 1) / 2));
            }

            System.out.println(maxDistance);
        }
    }

}
