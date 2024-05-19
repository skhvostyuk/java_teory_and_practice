package lessons;

import java.util.Scanner;

public class Lesson62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            long W = scanner.nextInt();
            long H = scanner.nextInt();

            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            long w = scanner.nextInt();
            long h = scanner.nextInt();

            // X
            long maxX = Math.max(x1, W - x2);
            long xMove = 0;
            if (x2 - x1 + w > W) {
                xMove = -1;
            } else if (w > maxX) {
                xMove = w - maxX;
            }

            // Y
            long maxY = Math.max(y1, H - y2);
            long yMove = 0;
            if (y2 - y1 + h > H) {
                yMove = -1;
            }  else if (h > maxY) {
                yMove = h - maxY;
            }

            if(xMove == -1 && yMove == -1) {
                System.out.println(-1);
            } else if(xMove == -1 || yMove == -1) {
                System.out.println(Math.max(yMove, xMove));
            } else {
                System.out.println(Math.min(yMove, xMove));
            }
        }
    }
}
