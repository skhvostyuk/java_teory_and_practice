package codeforces.contest924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        long T = scanner.nextInt();

        while (T-- > 0) {
         int n = scanner.nextInt();
         int x = scanner.nextInt();
        // n -= (x - 1);
        // x = 1;

         int counter = 0;
         for(int k = x == 1? 2 : x; k < n; k++) {
             int pos = n % (2*k -2);
             if(pos == 0) {
                 pos = 2*k - 2;
             }
             if((pos <= k  && pos == x) || (pos > k && k - (pos - k) == x)) {
            //     out.println("n = " + n + ", x = " + x + ", k = " + k);
                 counter++;
             }
         }
         out.println(counter);


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
