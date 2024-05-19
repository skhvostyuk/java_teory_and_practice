package codeforces.contest919;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();

            int min = Integer.MIN_VALUE;
            int max = Integer.MAX_VALUE;
            Set<Integer> notEquals = new HashSet<>();

            for(int i = 0; i < n; i++) {
                int a = scanner.nextInt();
                int x = scanner.nextInt();

                switch (a) {
                    case 1:
                        min = Math.max(min, x);
                        break;
                    case 2:
                        max = Math.min(max, x);
                        break;
                    case 3:
                        notEquals.add(x);
                        break;
                }
            }

            int counter = 0;
            for(Integer not : notEquals) {
                if(not <= max && not >= min) {
                    counter--;
                }
            }

            counter+= max - min + 1;
            System.out.println(Math.max(counter, 0));
        }
    }

}
