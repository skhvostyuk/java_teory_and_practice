package codeforces.contest919;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class C {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();

            int[] a = new int[n];

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                max = Math.max(max, a[i]);
                min = Math.min(min, a[i]);
            }

            Set<Integer> nDivisors = findDivisors(n);

            if (min == max) {
                System.out.println(nDivisors.size());
                continue;
            }

            int points = 0;

            for (int length : nDivisors) {
                int amount = n / length;

                Set<Integer> localDivisors = null;

                for (int i = 0; i < length; i++) {
                    for (int j = 1; j < amount; j++) {
                        int diff = Math.abs(a[i] - a[i + j * length]);
                        if (diff == 0) {
                            continue;
                        }
                        if (localDivisors == null) {
                            localDivisors = findDivisors(diff);
                            localDivisors.remove(1);
                            continue;
                        }

                        if (localDivisors.contains(diff)) {
                            continue;
                        }

                        List<Integer> forRemove = null;
                        for (int divisor : localDivisors) {
                            if (diff % divisor != 0) {
                                if (forRemove == null) {
                                    forRemove = new ArrayList<>();
                                }
                                forRemove.add(divisor);
                            }
                        }
                        if (forRemove != null) {
                            forRemove.forEach(localDivisors::remove);
                        }

                        if (localDivisors.isEmpty()) {
                            break;
                        }
                    }
                    if (localDivisors != null && localDivisors.isEmpty()) {
                        break;
                    }
                }

                if (localDivisors == null) {
                    points++;
                } else if (!localDivisors.isEmpty()) {
                    points++;
                }
            }

            System.out.println(points);

        }


    }

    private static Set<Integer> findDivisors(int number) {
        Set<Integer> divisors = new HashSet<>();

        for (int i = 1; i <= Math.sqrt(number); ++i) {
            if (number % i == 0) {
                divisors.add(i);
                if (i != number / i) {
                    divisors.add(number / i);
                }
            }
        }
        divisors.add(number);
        return divisors;
    }
}
