package lessons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lesson73 {

    private static class Node {
        int value;

        public Node(int index) {
            this.index = index;
        }

        int index;
        Node prev;
        Node next;
    }

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int T = scanner.nextInt();

            while (T-- > 0) {

                int n = scanner.nextInt();

                Map<Integer, Node> nodes = new HashMap<>();
                for(int i = 0; i < n; i++) {
                    nodes.put(i, new Node(i));
                }

                System.out.println("+ " + n);
                int answ = scanner.nextInt();
                if(answ == -2) {
                    return;
                }

                for(int i = 0; i < n; i++) {
                    // i -> x - i
                    // nodes.get()
                }




                System.out.println("+ " + (n + 1));
                answ = scanner.nextInt();
                if(answ == -2) {
                    return;
                }

                int[] answers = new int[n];
                int[] indexes = new int[n];

                for(int i = 1; i <= n; i++) {
                    System.out.printf("? 1 %s", i);
                    answers[i] = scanner.nextInt();
                    if(answers[i] == -2) {
                        return;
                    }
                    indexes[answers[i]] = i;
                }



            }
    }
}
