//package lessons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Lesson74 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();

            int[] a = new int[n];
            for(int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }


            Integer mod = null;

            for(int i = 0; i <= a.length/2; i++) {
                int first = a[i], second = a[a.length - i - 1];

                if(first != second) {
                    int diff = Math.max(first, second) - Math.min(first, second);

                    if(mod == null) {
                        mod = diff;
                    } else {
                        mod = gcd(mod, diff);
                    }

                    if(mod == 1) {
                        break;
                    }
                }
            }

            if(mod == null) {
                System.out.println("0");
            } else {
                System.out.println(mod);
            }
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
