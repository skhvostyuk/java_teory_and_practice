package lessons;

import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Lesson70 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int R = scanner.nextInt();

        int[][] passengersCapacity = new int[N][N];

        for (int i = 0; i < R; i++) {
            int c1 = scanner.nextInt();
            int c2 = scanner.nextInt();
            int p = scanner.nextInt();
            passengersCapacity[c1][c2] = p;
            passengersCapacity[c2][c1] = p;
        }

        int start = scanner.nextInt() - 1;
        int destination = scanner.nextInt() - 1;
        int tourists = scanner.nextInt();

        int tripsFromStart = getTripsFromStart(N, passengersCapacity, start, tourists, destination);

        System.out.println(tripsFromStart);
    }

    private static int getTripsFromStart(int N, int[][] passengersCapacity, int start, int tourists, int destination) {
        int[] tripsFromStart = new int[N];

        for (int i = 0; i < N; i++) {
            int capacity = passengersCapacity[start][i];
            if (capacity != 0) {
                tripsFromStart[i] = tourists % capacity == 0 ? tourists / capacity : tourists / capacity + 1;
            } else {
                tripsFromStart[i] = Integer.MAX_VALUE;
            }
        }

        tripsFromStart[start] = 0;

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int capacity = passengersCapacity[j][i];

                    if (capacity != 0 && tripsFromStart[j] != Integer.MAX_VALUE) {
                        int tripsFromJ = tourists % capacity == 0 ? tourists / capacity : tourists / capacity + 1;
                        System.out.println("trips from " + j+ " to " + i + ": " + tripsFromJ);
                        tripsFromStart[i] = Math.min(tripsFromStart[i], Math.max(tripsFromStart[j], tripsFromJ));
                    }
                }
                System.out.println(Arrays.toString(tripsFromStart));
            }
        }
        return tripsFromStart[destination];
    }

    @Test
    public void tests() {
        int N = 7;
        int R = 10;


        String pass =
                "1 2 30 \n"
                + "1 3 15 \n"
                + "1 4 10 \n"
                + "2 4 25 \n"
                + "2 5 60 \n"
                + "3 4 40 \n"
                + "3 6 20 \n"
                + "4 7 35 \n"
                + "5 7 20 \n"
                + "6 7 30 \n";

        int start = 1 - 1;
        int destination = 7 - 1;
        int tourists = 99;
        String[] lines = pass.split("\n");

        int[][] passengersCapacity = new int[N][N];
        for (int i = 0; i < R; i++) {
            String[] vals = lines[i].split(" ");
            int c1 = Integer.parseInt(vals[0]) - 1;
            int c2 = Integer.parseInt(vals[1]) - 1;
            int p = Integer.parseInt(vals[2]);
            passengersCapacity[c1][c2] = p;
            passengersCapacity[c2][c1] = p;
        }

        Assertions.assertEquals(5, getTripsFromStart(N, passengersCapacity, start, tourists, destination));
    }
}
