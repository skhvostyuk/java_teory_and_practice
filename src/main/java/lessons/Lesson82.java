//package lessons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Lesson82 {

    public static class Node {
        int x;
        int y;
        int d;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int x0 = scanner.nextInt();
        int y0 = scanner.nextInt();

        int aX = scanner.nextInt();
        int aY = scanner.nextInt();
        int bX = scanner.nextInt();
        int bY = scanner.nextInt();

        int xS = scanner.nextInt();
        int yS = scanner.nextInt();

        int t = scanner.nextInt();

        List<Node> nodes = new ArrayList<>();
        Node first = new Node();
        first.x = x0;
        first.y = y0;
        first.d = Math.abs(xS - x0) + Math.abs(yS - y0);

        nodes.add(first);

        while(true) {
            Node prev = nodes.get(nodes.size() - 1);
            Node next = new Node();
            next.x = prev.x * aX + bX;

            if(next.x > xS + t) {
                break;
            }

            next.y = prev.y * aY + bY;

            if(next.y > yS + t) {
                break;
            }

            next.d = Math.abs(xS - prev.x) + Math.abs(yS - prev.y);

            nodes.add(next);
        }



        out.flush();
    }

    //https://codeforces.com/problemset/problem/1845/B
    private static void walkTogether(FastScanner scanner, PrintWriter out) {
        int xA = scanner.nextInt();
        int yA = scanner.nextInt();
        int xB = scanner.nextInt();
        int yB = scanner.nextInt();
        int xC = scanner.nextInt();
        int yC = scanner.nextInt();

        int common = 1;

        if((xA > xC && xA > xB) || (xA < xC && xA < xB)) {
            common += Math.max(Math.abs(xA - xC), Math.abs(xA - xB)) - Math.abs(xC - xB);
        }

        if((yA > yC && yA > yB) || (yA < yC && yA < yB)) {
            common += Math.max(Math.abs(yA - yC), Math.abs(yA - yB)) - Math.abs(yC - yB);
        }

        out.println(common);
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
