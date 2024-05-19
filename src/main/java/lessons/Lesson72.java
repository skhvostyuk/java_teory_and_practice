package lessons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Lesson72 {

    public static final int X = 0;
    public static final int Y = 1;

    //https://codeforces.com/problemset/problem/1411/C
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt() + 1;
            int m = scanner.nextInt();

            int[][] rooks = new int[m][2];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 1; i < n; i++) {
                map.put(i, new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                rooks[i][X] = scanner.nextInt();
                rooks[i][Y] = scanner.nextInt();
                map.get(rooks[i][0]).add(rooks[i][1]);
            }

            boolean[] processed = new boolean[m];
            boolean[] yOccupied = new boolean[n];

            for(int i = 0; i < m; i++) {
                //if()


            }

        }
    }


    //https://codeforces.com/problemset/problem/1647/B
    private static void elegantGift() {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();

            char[][] table = new char[n][m];

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();

                for (int j = 0; j < m; j++) {
                    table[i][j] = line.charAt(j);
                }
            }

            boolean[][] processed = new boolean[n][m];

            boolean isElegant = true;
            for (int i = 0; i < n && isElegant; i++) {
                for (int j = 0; j < m; j++) {
                    if (table[i][j] == '1' && !processed[i][j]) {
                        int width = 1; // m
                        int height = 1; // n

                        while (j + width < m && table[i][j + width] == '1') {
                            width++;
                        }

                        while (i + height < n && table[i + height][j] == '1') {
                            height++;
                        }

                        for (int w = 0; w < width && isElegant; w++) {
                            for (int h = 0; h < height; h++) {
                                if (table[i + h][j + w] != '1') {
                                    isElegant = false;
                                    break;
                                }
                                processed[i + h][j + w] = true;
                            }
                        }

                        if (!isElegant) {
                            break;
                        }

                        if (i > 0) {
                            for (int w = 0; w < width; w++) {
                                if (table[i - 1][j + w] == '1') {
                                    isElegant = false;
                                    break;
                                }
                            }
                        }
                        if (i + height < n) {
                            for (int w = 0; w < width; w++) {
                                if (table[i + height][j + w] == '1') {
                                    isElegant = false;
                                    break;
                                }
                            }
                        }

                        if (j > 0) {
                            for (int h = 0; h < height; h++) {
                                if (table[i + h][j - 1] == '1') {
                                    isElegant = false;
                                    break;
                                }
                            }
                        }

                        if (j + width < m) {
                            for (int h = 0; h < height; h++) {
                                if (table[i + h][j + width] == '1') {
                                    isElegant = false;
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            if (isElegant) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }


        }
    }
}
