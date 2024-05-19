//package lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class Lesson81 {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int N = scanner.nextInt();

        String A = scanner.next();
        String B = scanner.next();

        Map<Character, Integer> countA = new HashMap<>();
        for (int i = 0; i < N; i++) {
            countA.compute(A.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        Map<Character, Integer> countB = new HashMap<>();
        for (int i = 0; i < N; i++) {
            countB.compute(B.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        int diff = 0;
        for (Entry<Character, Integer> entry : countA.entrySet()) {
            Integer bCount = countB.get(entry.getKey()) == null ? 0 : countB.get(entry.getKey());
            if (entry.getValue() > bCount) {
                diff += entry.getValue() - bCount;
            }
        }

        out.println(diff);

        out.flush();
    }


    // Greatest Common Divisor
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
