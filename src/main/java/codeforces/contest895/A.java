package codeforces.contest895;//package codeforces.contest1857;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            int max = Math.max(a, b);
            int min = Math.min(a, b);



            if ((max - min) % (2*c) > 0) {
                System.out.println((max - min) / (2*c) + 1);
            } else {
                System.out.println((max - min) / (2*c));
            }
        }
    }

}
