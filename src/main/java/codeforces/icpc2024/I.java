package codeforces.icpc2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class I {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = scanner.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];
        int[] r = new int[n];

        boolean[] marked = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2) == Math.pow(r[i] + r[j], 2)) {
                    marked[i] = true;
                    marked[j] = true;
                }
            }
        }

        boolean hasNotMarked = false;

        for(int i = 0; i < n; i++) {
            if(!marked[i]) {
                hasNotMarked = true;
            }
        }

        if(hasNotMarked) {
            out.println("YES");
        } else {
            out.println("NO");
        }

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
