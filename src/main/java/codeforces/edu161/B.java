package codeforces.edu161;//package codeforces.edu161;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            Arrays.sort(a);

            long variants = 0;
            int currentLength = 1;
            for(int i = 1; i < n; i++) {
                if(a[i] == a[i - 1]) {
                    currentLength++;
                } else {
                    variants += binomialCoefficient(currentLength, 3);
                    variants += (i - currentLength) * binomialCoefficient(currentLength, 2);
                    currentLength = 1;
                }
            }
            if(currentLength > 1) {
                variants += binomialCoefficient(currentLength, 3);
                variants += (n - currentLength) * binomialCoefficient(currentLength, 2);
            }

            System.out.println(variants);
        }
    }

    public static long binomialCoefficient(int n, int k) {
        long result = 1;

        if(k > n) {
            return 0;
        }

        if (k > n - k) {
            k = n - k;
        }

        for (int i = 0; i < k; ++i) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

}
