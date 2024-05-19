package codeforces.contest921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            String s = scanner.nextLine();

            Set<Character> shouldContain = fillShouldContain(k);

            int counter = 0;
            char[] answ = new char[n];
            for (int i = 0; i < m; i++) {
                shouldContain.remove(s.charAt(i));

                if(shouldContain.isEmpty()) {
                    answ[counter] = s.charAt(i);
                    counter++;
                    if(counter >= n) {
                        break;
                    }
                    shouldContain = fillShouldContain(k);
                }
            }

            if(counter >= n) {
                out.println("YES");
            }else {
                out.println("NO");

                char c = shouldContain.stream().findFirst().orElse('a');

                for(int i = counter; i < n; i++) {
                    answ[i] = c;
                }

                out.println(answ);
            }


        }
        out.flush();
    }

    private static Set<Character> fillShouldContain(int k) {
        Set<Character> shouldContain = new HashSet<>();
        for(int i = 0; i < k; i++) {
            shouldContain.add((char) ('a' + i));
        }
        return shouldContain;
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
