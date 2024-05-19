package codeforces.contest1857;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            char[] digits = reader.readLine().trim().toCharArray();
            int round = digits.length;
            for(int i = digits.length - 1; i > 0; i--) {
                if(digits[i] - '0' >= 5) {
                    round = i;
                    digits[i-1]++;
                }
            }

            StringBuilder builder = new StringBuilder();

            if(digits[0] -'0' >= 5) {
                builder.append("1");

                for(int i = 0; i < digits.length; i++) {
                     builder.append("0");
                }
                System.out.println(builder);
            } else {
                for(int i = 0; i < round; i++) {
                    builder.append(digits[i]);
                }

                for(int i = round; i < digits.length; i++) {
                    builder.append("0");
                }

                System.out.println(builder);
            }





        }
    }
}
