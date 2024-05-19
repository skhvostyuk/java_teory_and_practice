package codeforces.contest921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class D {
    int MOD = 1000000007;

    static class Variant {

        double possibility;
        long sum;

        public Variant(double possibility, long sum) {
            this.possibility = possibility;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        long T = scanner.nextInt();

        while (T-- > 0) {
            long n = scanner.nextInt(); // children
            long m = scanner.nextInt(); // pairs
            long allPairs = (n * (n - 1) / 2);
            long possibilityWithPair = m;
            long possibilityWithoutPair = allPairs - m;
            int rounds = scanner.nextInt();

            long sum = 0;
            long prevSum = 0;
            for (long i = 0; i < m; i++) {
                long a = scanner.nextInt();
                long b = scanner.nextInt();
                long c = scanner.nextInt();
                prevSum += c;
            }

            sum = prevSum;

            Map<Long, Long>[] roundsDP = new Map[rounds];

            roundsDP[0].put(sum, allPairs);

            for (int i = 1; i < rounds; i++) {
                roundsDP[i] = new HashMap<>();

                for (Entry<Long, Long> variant : roundsDP[i - 1].entrySet()) {
                    roundsDP[i].compute(variant.getKey(), (k, v) -> (v == null) ? variant.getValue() * possibilityWithoutPair: v +variant.getValue() * possibilityWithoutPair);
                    roundsDP[i].compute(variant.getKey() + 1, (k, v) -> (v == null) ? variant.getValue() * possibilityWithPair: v +variant.getValue() * possibilityWithPair);

                    //  map.compute(key, (k, v) -> (v == null) ? msg : v.concat(msg))
                }


            }


        }
        out.flush();
    }

    private static Set<Character> fillShouldContain(long k) {
        Set<Character> shouldContain = new HashSet<>();
        for (long i = 0; i < k; i++) {
            shouldContain.add((char) ('a' + i));
        }
        return shouldContain;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    private static Set<Long> findDivisors(long number) {
        Set<Long> divisors = new HashSet<>();

        for (long i = 1; i <= Math.sqrt(number); ++i) {
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


    static class FastScanner {

        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
