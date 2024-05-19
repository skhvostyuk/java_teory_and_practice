package codeforces.contest925;//package codeforces.contest925;//package codeforces.contest925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class F {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        long T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[][] a = new int[k][n];

            for(int i = 0; i < k; i++) {
                for(int j = 0; j < n; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }

            List<Integer> list = new ArrayList<>();
            int firstPerson = a[0][0];
            for (int j = 1; j < n; j++) {
                list.add(a[0][j]);
            }

            if(k == 1) {
                out.println("YES 0");
                continue;
            }

            int secondPerson = a[1][0];
            boolean hasAnswer = true;
            for(int i = 1, j = 0; i < n; i++) {
                int el = a[1][i];


                if(el != list.get(j) && (el != firstPerson && list.get(j) != secondPerson)) {
                    hasAnswer = false;
                    break;
                } else if (el != list.get(j) && el == firstPerson) {
                    list.add(j, el);
                } else if(el != list.get(j) && list.get(j) == secondPerson){
                    i--;
                }
                j++;
            }

            if(!hasAnswer) {
                out.println("NO 1");
                continue;
            }

            if (k == 2) {
                out.println("YES 1");
                continue;
            }


            for(int i = 2; i < k; i++) {
                for(int j = 0; j < n; j++) {
                    if(a[i][j] != list.get(j)) {
                        hasAnswer = false;
                        break;
                    }

                    if(!hasAnswer) {
                        break;
                    }
                }
            }

            if(hasAnswer) {
                out.println("YES 2 ");
            } else {
                out.println("NO 2");
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
