package lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lesson64 {

    public static void main(String[] args) {
        //https://codeforces.com/problemset/problem/1847/B
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            int and = a[0];
            for(int i = 1; i < n; i++) {
                and = and & a[i];
            }

            if(and != 0) {
                System.out.println("1");
                continue;
            }

            List<Integer> subArrays = new ArrayList<>();

            subArrays.add(Integer.MAX_VALUE);

            int current = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < 32; j++) {
                    if((a[i] >> j & 1) == 0 && (subArrays.get(current) >> j & 1) != 0) {
                        int sub = subArrays.remove(current);
                        sub = sub - 1 << j;
                        subArrays.add(current, sub);
                    }
                }
            }

        }

    }

}
