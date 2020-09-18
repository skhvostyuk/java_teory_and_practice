package codewars;

import static java.util.Arrays.stream;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.junit.Test;

public class FindOdd {

    public static int findIt(int[] a) {
        if (a.length <= 0) {
            return 0;
        }
        return stream(a).boxed()
                .collect(Collectors.toMap(integer -> integer, integer -> 1, Integer::sum))
                .entrySet().stream()
                .filter(num -> num.getValue() % 2 != 0).findFirst().map(Entry::getKey).orElse(0);
    }

    /**
     *  XOR will cancel out everytime you XOR with the same number so 1^1=0 but 1^1^1=1 so every pair should cancel out leaving the odd number out
     */
    public static int cleverFindIt(int[] arr) {
        return stream(arr).reduce(0, (x, y) -> x ^ y);
    }

    @Test
    public void findTest() {
        assertEquals(5, FindOdd.findIt(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        assertEquals(-1, FindOdd.findIt(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        assertEquals(5, FindOdd.findIt(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        assertEquals(10, FindOdd.findIt(new int[]{10}));
        assertEquals(10, FindOdd.findIt(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        assertEquals(1, FindOdd.findIt(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }
}
