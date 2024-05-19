package codeforces.edu160;
import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            Long ab = scanner.nextLong();

            long a = 0;
            long b = 0;
            int length = ab.toString().length();
            for(int i = length; i > 0; i++) {
                long pow = (long)Math.pow(10, i);
                a = ab / pow;
                b = ab % pow;

            }
        }
    }

}
