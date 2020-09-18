package codewars;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.junit.Test;

/**
 * A friend of mine takes a sequence of numbers from 1 to n (where n > 0). Within that sequence, he chooses two numbers, a and b. He says that the product of a and b should be
 * equal to the sum of all numbers in the sequence, excluding a and b. Given a number n, could you tell me the numbers he excluded from the sequence?
 */
public class RemovedNumbers {

    //TODO: не проходит по времени, надо оптимизировать
    public static List<long[]> removNb(long n) {
        List<long[]> answer = new ArrayList<>();

        long sum = LongStream.range(1, n + 1).sum();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i * j == sum - i - j) {
                    answer.add(new long[]{i, j});
                }
            }
        }

        return answer;
    }

    @Test
    public void test12() {
        List<long[]> res = new ArrayList<long[]>();
        res.add(new long[]{15, 21});
        res.add(new long[]{21, 15});
        List<long[]> a = RemovedNumbers.removNb(26);
        assertArrayEquals(res.get(0), a.get(0));
        assertArrayEquals(res.get(1), a.get(1));
    }

    @Test
    public void test14() {
        List<long[]> res = new ArrayList<long[]>();
        List<long[]> a = RemovedNumbers.removNb(100);
        assertTrue(res.size() == a.size());
    }
}
