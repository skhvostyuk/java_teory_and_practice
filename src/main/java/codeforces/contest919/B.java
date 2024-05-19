package codeforces.contest919;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class B {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int x = scanner.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            Arrays.sort(a);

            int sum = Arrays.stream(a).sum();


            int localSum = sum;

            for(int i = 0; i < x; i++) {
                localSum -= 2*a[n - 1 - i];
            }

            int answer = localSum;

            for(int i = 1; i <= k; i++) {

                localSum += a[n - i];

                if(n - x - i >= 0) {
                    localSum -= 2 * a[n - x - i];
                }


                answer = Math.max(answer, localSum);
            }
            System.out.println(answer);
        }


    }
}
