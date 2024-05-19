package codeforces.contest895;//package codeforces.contest1857;

import java.math.BigInteger;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long T = scanner.nextInt();

        while (T-- > 0) {
            long n = scanner.nextLong();
            long x = scanner.nextLong();
            long y = scanner.nextLong();

            long xyAmount = n / lcm(x, y);
            //System.out.prlongln("xyAmount " + xyAmount);

            long xAmount = n / x - xyAmount;
            //System.out.prlongln("xAmount " + xAmount);

            long yAmount = n / y - xyAmount;
            //System.out.prlongln("yAmount " + yAmount);

            BigInteger sum = BigInteger.ZERO;
                sum = sum.add(BigInteger.valueOf(n))
                        .add(BigInteger.valueOf(n - (xAmount - 1)))
                        .multiply(BigInteger.valueOf(xAmount))
                        .divide(BigInteger.TWO);


                BigInteger minus = BigInteger.ONE
                        .add(BigInteger.valueOf(yAmount))
                        .multiply(BigInteger.valueOf(yAmount))
                        .divide(BigInteger.TWO)
                        .negate();
                sum = sum.add(minus);



            System.out.println(sum);

        }
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

}
