//package codeforces.edu161;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();
            char[] a = scanner.nextLine().toCharArray();
            char[] b = scanner.nextLine().toCharArray();
            char[] c = scanner.nextLine().toCharArray();

            boolean exists = false;
            for (int i = 0; i < n; i++) {
                if (a[i] == c[i] || b[i] == c[i]) {
                    continue;
                } else {
                    exists = true;
                    break;
                }

            }

            if (exists) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

}
