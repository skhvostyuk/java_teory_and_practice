package codewars;

import java.util.Arrays;

public class RotateArray {

    public static Object[] rotate(Object[] data, int n) {

        if (n == 0) {
            return data;
        }
        int count = 0;

        int N = data.length;

        for (int start = 0; count < N; start++) {
            int i = start;
            Object holder = data[start];

            do {
                i = ((i + n) % N + N) % N;
                Object tmp = data[i];
                data[i] = holder;
                holder = tmp;
                count++;
            } while (i != start);
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotate(new Object[]{1, 2, 3, 4, 5, 6}, 2)));
    }

}
