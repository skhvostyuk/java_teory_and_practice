package codeforces.contest895;//package codeforces.contest1857;

import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            if (r - l > 0 || r % 2 == 0) {
                if (r >= 4) {
                    int val = r % 2 == 0 ? r : r - 1;
                    System.out.println("2 " + (val - 2));
                    continue;
                } else {
                    System.out.println(-1);
                    continue;
                }
            } else {
                boolean found = false;
                for (int i = 3; i <= Math.sqrt(l); i++) {
                    if (l % i == 0) {
                        found = true;
                        System.out.println(i + " " + (l - i));
                        break;
                    }
                }
                if(found) {
                    continue;
                }
            }
            System.out.println(-1);
        }
    }

}
