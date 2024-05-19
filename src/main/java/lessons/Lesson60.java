//package lessons;

import java.util.Scanner;

public class Lesson60 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            long C = scanner.nextLong();
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = scanner.nextInt();
            }


            long left = 0;
            long right = 1000000000L;
            long w = 0;

            while (left < right) {

                w = (left + right) / 2;
                long c = 0;
                for (int i = 0; i < n; i++) {
                    c += (s[i] + w) * (s[i] + w);
                }

                if (c > C) {
                    right = w;
                } else if (c < C) {
                    left = w;
                } else {
                    break;
                }
            }
            System.out.println(w / 2);
        }
    }

    private static void sqEq(int n, long C, int[] s) {
        long a = n;
        long b = 0;
        for (int i = 0; i < n; i++) {
            b += s[i] * 2L;
        }

        long c = -C;
        for (int i = 0; i < n; i++) {
            c += ((long) s[i]) * s[i];
        }

        long D = (long) b * b - 4 * a * c;

        if (D >= 0) {
            long x1 = (-b - Math.round(Math.sqrt(D))) / (2 * a);
            long x2 = (-b + Math.round(Math.sqrt(D))) / (2 * a);
            System.out.println(Math.max(x1, x2) / 2);
        } else {
            System.out.println("NO");
        }
    }
}
