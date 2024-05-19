package codeforces.edu161;//package codeforces.edu161;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int[] costsLeftToRight = new int[n+1];

            costsLeftToRight[0] = 0;
            costsLeftToRight[1] = 1;

            for(int i = 1; i < n-1; i++) {
                int diff = a[i+1] - a[i];
                int cost = diff == Math.min(diff, a[i] - a[i-1]) ? 1 : diff;
                costsLeftToRight[i+1] = costsLeftToRight[i] + cost;
            }

            int[] costsRightToLeft = new int[n+1];
            costsRightToLeft[n-1] = 0;
            costsRightToLeft[n -2] = 1;


            for(int i = n-2; i >0; i--) {
                int diff = a[i] - a[i-1];
                int cost = diff == Math.min(diff, a[i+1] - a[i]) ? 1 : diff;
                costsRightToLeft[i-1] = costsRightToLeft[i] + cost;
            }





            int m = scanner.nextInt();

            for(int i = 0; i < m; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;

                if(x > y) {
                    System.out.println(costsRightToLeft[y] - costsRightToLeft[x]);
                } else {
                    System.out.println(costsLeftToRight[y] - costsLeftToRight[x]);
                }

            }
        }
    }

}
