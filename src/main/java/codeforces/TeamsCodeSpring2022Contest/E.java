package codeforces.TeamsCodeSpring2022Contest;//package codeforces.TeamsCodeSpring2022Contest;//package lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class E {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();

            int maxX = 0, minX = 0;
            int maxY = 0, minY = 0;
            int currentX = 0, currentY = 0;

            for (int i = 0; i < n; i++) {
                switch (s.charAt(i)) {
                    case 'L':
                        currentX--;
                        if (currentX < minX) {
                            minX = currentX;
                        }
                        break;
                    case 'R':
                        currentX++;
                        if (currentX > maxX) {
                            maxX = currentX;
                        }
                        break;
                    case 'U':
                        currentY--;
                        if (currentY < minY) {
                            minY = currentY;
                        }
                        break;
                    case 'D':
                        currentY++;
                        if (currentY > maxY) {
                            maxY = currentY;
                        }
                        break;

                }
            }

            out.println(maxX + " " + minX + " " + maxY + " " + minY);

            int area = (Math.max(maxX, -minX) + 1) * (Math.max(maxY, -minY) + 1);

            out.println(area);
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
