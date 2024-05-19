package codeforces.contest1857;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {

            int n = scanner.nextInt();
            int oddCounter = 0;
            for(int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                if(a % 2 != 0) {
                    oddCounter++;
                }
            }

            if(oddCounter %2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
