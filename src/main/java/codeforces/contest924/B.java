package codeforces.contest924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        long T = scanner.nextInt();

        while (T-- > 0) {
           int n = scanner.nextInt();
           int[] a = new int[n];

           for(int i = 0; i < n; i++) {
               a[i] = scanner.nextInt();
           }

            Arrays.sort(a);
            int first = a[0];
           for(int i = 0; i < n; i++) {
               a[i] = a[i] - first;
           }

           int counter = 1;
           int reserved = n-1;
           int maxCounter = 1;

           int start = 0; int end = 0;
           int sum = 0;

           while(true) {
               if(sum <= n-1 && end < n-1) {
                   end++;
                   sum = a[end] - a[start];
                   if(a[end] != a[end-1]) {
                       counter++;
                   }
                   if(sum <= n-1) {
                       maxCounter = Math.max(counter, maxCounter);
                   }
               } else if (start < n-1){
                   start++;
                   sum = a[end] - a[start];

                   if(a[start-1] != a[start]) {
                       counter--;
                   }

                   if(sum <= n-1) {
                       maxCounter = Math.max(counter, maxCounter);
                   }
               } else {
                   break;
               }
           }
           maxCounter = Math.max(counter, maxCounter);

            out.println(maxCounter);

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
