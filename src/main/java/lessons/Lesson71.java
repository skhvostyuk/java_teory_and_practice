package lessons;

import java.util.Scanner;

public class Lesson71 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] board = new int[n][n];

        int notColour = scanner.nextInt();

        board[0][0] = notColour == 1 ? 2 : 1;
        System.out.println(board[0][0] + " 0 " + (n - 1));
        System.out.flush();

        int x = n - 1, y = n - 1, k = -n + 1;

        for (int i = 0; i < Math.pow(n, 2) - 1; i++) {
            x++;
            y++;
            if (y == n || x == n) {
                k++;
                y = k >= 0 ? 0 : -k;
                x = k >= 0 ? k : 0;
            }
            System.out.println(x + " " + y);
        }
    }

}
