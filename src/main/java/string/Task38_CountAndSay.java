package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task38_CountAndSay {

    public static String countAndSay(int n) {
        String answer = "1";

        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            Character holder = null;
            int counter = 1;
            for (char c : answer.toCharArray()) {
                if (holder == null)
                    holder = c;
                else if (c == holder)
                    counter++;
                else {
                    sb.append((char) (counter + '0'));
                    sb.append(holder);
                    holder = c;
                    counter = 1;
                }
            }
            sb.append((char) (counter + '0'));
            sb.append(holder);
            answer = sb.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }
}
