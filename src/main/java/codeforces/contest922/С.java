package codeforces.contest922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class С {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        long T = scanner.nextInt();

        while (T-- > 0) {
            long a = scanner.nextLong();
            boolean[] aBits = toBitArray(a);
            long b = scanner.nextLong();
            boolean[] bBits = toBitArray(b);
            long r = scanner.nextLong();
            boolean[] rBits = toBitArray(r);

            boolean[] xBits = new boolean[64];

            boolean isMakingABigger = false;
            boolean isFirstProcessed = false;
            for(int i = 0; i < 64; i++) {
                if(aBits[i] ^ bBits[i]) {
                    if(!isFirstProcessed) {
                        isMakingABigger = bBits[i];
                        isFirstProcessed = true;
                        continue;
                    }
                    if(isMakingABigger) {
                        xBits[i] = bBits[i];
                        if(isBiggerBits(rBits, xBits)) {
                            xBits[i] = false;
                        }
                    } else {
                        xBits[i] = aBits[i];
                        if(isBiggerBits(rBits, xBits)) {
                            xBits[i] = false;
                        }
                    }
                }
            }
            long x = fromBitArray(xBits);
           //out.println("x: " + x);
            out.println(Math.abs((a^x) - (b^x)));
        }
        out.flush();
    }

    public static boolean[] toBitArray(long num) {
        boolean[] bitArray = new boolean[64];

        for (int i = 0; i < 64; i++) {
            bitArray[63 - i] = ((num >> i) & 1) != 0;
        }
        return bitArray;
    }

    public static long fromBitArray(boolean[] bitArray) {
        long answer = 0;


        for (int i = 0; i < 64; i++) {
            answer <<= 1;
            if(bitArray[i]) {
                answer++;
            }
        }
        return answer;
    }

    //is target bigger than source
    public static boolean isBiggerBits(boolean[] source, boolean[] target) {
        for(int i = 0; i < 64; i++) {
            if(target[i] ^ source[i]) {
                return target[i];
            }
        }
        return false;
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
