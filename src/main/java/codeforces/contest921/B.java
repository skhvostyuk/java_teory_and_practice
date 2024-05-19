package codeforces.contest921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B {

    public static void main(String[] args) {
        FastReader s = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int T = s.nextInt();

        while (T-- > 0) {
            int x = s.nextInt();
            int n = s.nextInt();
            if (x % n == 0) {
                out.println(x / n);
                continue;
            }

            Set<Integer> divisors = findDivisors(x);

            int maxPossibleDiv = 1;

            for (int div : divisors) {
                if (div > maxPossibleDiv && x / div >= n) {
                    maxPossibleDiv = div;
                }
            }

            out.println(maxPossibleDiv);


        }
        out.flush();
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
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


    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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
