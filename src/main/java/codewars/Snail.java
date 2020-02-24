package codewars;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Snail {

    public static int[] snail(int[][] array) {
        int N = array[0].length;
        List<Integer> answer  = new ArrayList<>(N*N);

        int round = 0;
        int i, j;

        while (round < Math.round(((double) N) / 2)) {
            i = round;

            for (j = round; j < N - round; j++)
                answer.add(array[i][j]);
            j--;

            for (i = round + 1; i < N - round; i++)
                answer.add(array[i][j]);
            i--;

            for (j = j - 1; j > round; j--)
                answer.add(array[i][j]);

            for (; i >= round + 1; i--)
                answer.add(array[i][j]);

            round++;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void SnailTest1() {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};

        System.out.println(Arrays.toString(snail(array)) + "\n");
        test(array, r);
    }

    public String int2dToString(int[][] a) {
        return Arrays.stream(a).map(row -> Arrays.toString(row)).collect(joining("\n"));
    }

    public void test(int[][] array, int[] result) {
        String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
        System.out.println(text);
        Assert.assertArrayEquals( result, Snail.snail(array));
    }
}
