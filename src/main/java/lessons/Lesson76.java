package lessons;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lesson76 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        while (T-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            SortedSet<Integer> sortedSet = new TreeSet<>();
            Arrays.stream(a).forEach(sortedSet::add);

            for (int j = 0; j < n; j++) {
                int mex = findMex(sortedSet);
                sortedSet.remove(a[j]);
                sortedSet.add(mex);
                a[j] = mex;
            }

            //System.out.println(Arrays.toString(a));

            int xorGeneral = 0;
            for (int i = 1; i <= n; i++) {
                xorGeneral ^= i;
            }

            int xor = a[0];
            for (int i = 1; i < n; i++) {
                xor ^= a[i];
            }

            for (int i = 1; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    int h = a[j];
                    a[j] = xorGeneral ^ xor;
                    xor ^= a[j];
                    xor ^= h;
                }
            }

            StringBuilder stringBuilder = new StringBuilder();

            for(int i = 0; i < n; i++) {
                stringBuilder.append(a[i])
                        .append(" ");
            }

            System.out.println(stringBuilder.toString());
        }
    }

    private static int findMex(SortedSet<Integer> sortedSet) {
        int min = sortedSet.first();
        if (min > 0) {
            return 0;
        }
        int previous = min;

        for (int value : sortedSet) {
            if (value - previous > 1) {
                return previous + 1;
            }
            previous = value;
        }
        return sortedSet.last() + 1;
    }
}
