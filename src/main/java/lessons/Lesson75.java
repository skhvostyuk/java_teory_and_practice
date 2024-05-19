package lessons;

import java.util.Scanner;

public class Lesson75 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if ((n >= k && n <= 2 * k - 1) || (n + 1) % (2 * k) == 0) {
            System.out.println("Marsha");
        } else {
            System.out.println("Bill");
        }
    }
}
