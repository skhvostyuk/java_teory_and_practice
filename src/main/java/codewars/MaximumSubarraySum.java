package codewars;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class MaximumSubarraySum {

    //TODO: переделать на 2 переменные
    public static int sequence(int[] arr) {
        Integer[] sums = new Integer[arr.length];

        if(arr.length == 0)
            return 0;

        sums[0] = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(sums[i - 1] > 0) {
                sums[i] = sums[i - 1] + arr[i];
            } else {
                sums[i] = arr[i];
            }
        }
        return Math.max(Collections.max(Arrays.asList(sums)), 0);
    }

    @Test
    public void testEmptyArray() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 0, sequence(new int[]{}));
    }
    @Test
    public void testExampleArray() throws Exception {
        assertEquals("Example array should have a max of 6", 6, sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
