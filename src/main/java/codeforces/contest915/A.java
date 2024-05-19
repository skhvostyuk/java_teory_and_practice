package codeforces.contest915;//package codeforces.contest1857;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int answer = 0;
            for(int i = 1; i <= n; i += 3) {
                answer += m;
            }

            System.out.println(answer);
        }
    }

}
