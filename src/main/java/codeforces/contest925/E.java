//package codeforces.contest925;//package codeforces.contest925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class E {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        long T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            List<Integer> zerosList = new ArrayList<>();

            long allDigits = 0;

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();

                int zeros = 0;
                while (a[i] % 10 == 0) {
                    a[i] /= 10;
                    zeros++;
                }
                if(zeros != 0) {
                    zerosList.add(zeros);
                }

                int digits = zeros;
                while (a[i] != 0) {
                    a[i] /= 10;
                    digits++;
                }
                allDigits += digits;
            }

            zerosList.sort(Integer::compare);

            //System.out.println(zerosList);
            //System.out.println(allDigits);

            long forRemove = 0;
            int zerosSize = zerosList.size();
            for(int i = 0; i < zerosSize;i++) {
                if(i %2 == 0) {
                    forRemove+= zerosList.get(zerosSize - 1 - i);
                }
            }

            if(allDigits - forRemove > m) {
                out.println("Sasha");
            } else {
                out.println("Anna");
            }
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
