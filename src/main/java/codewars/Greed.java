package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Greed {
    public static int greedy(int[] dice) {
        int[] results = new int[]{0, 0, 0, 0, 0, 0};
        int result = 0;

        for (int res : dice)
            results[res - 1]++;

        while (results[0] >=3) {
            result += 1000;
            results[0] -= 3;
        }

        for (int i = 0; i < 6; i++) {
            while (results[i] >= 3) {
                result += 100 * (i+1);
                results[i] -= 3;
            }
        }
        result += 100 * results[0];
        result += 50 * results[4];

        return result;
    }

    public static int cleverGreedy(int[] dice) {
        int n[] = new int[7];
        for (int d : dice) n[d]++;
        return n[1]/3*1000 + n[1]%3*100 + n[2]/3*200 + n[3]/3*300 + n[4]/3*400 + n[5]/3*500 + n[5]%3*50 + n[6]/3*600;
    }


    @Test
    public void testExample() {
        assertEquals("Score for [5,1,3,4,1] must be 250:", 250, Greed.greedy(new int[]{5, 1, 3, 4, 1}));
        assertEquals("Score for [1,1,1,3,1] must be 1100:", 1100, Greed.greedy(new int[]{1, 1, 1, 3, 1}));
        assertEquals("Score for [2,4,4,5,4] must be 450:", 450, Greed.greedy(new int[]{2, 4, 4, 5, 4}));
    }
}