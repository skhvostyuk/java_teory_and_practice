package codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheParityOutlier {
    //TODO: можно использовать  для первых трех сложение остатков, переписать это все на стримы
    static int find(int[] integers) {
        int countFirstOdd = 0;
        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0)
                countFirstOdd++;
        }
        int modulo = countFirstOdd > 1 ? 1 : 0;

        for (int num : integers) {
            if (num % 2 == modulo || num % 2 == - modulo)
                return num;
        }

        return -1;
    }

    @Test
    public void testExample() {
        int[] exampleTest1 = {2,6,8,-10,3};
        int[] exampleTest2 = {206847684,1056521,7,17,1901,21104421,7,1,35521,1,7781};
        int[] exampleTest3 = {Integer.MAX_VALUE, 0, 1};
        assertEquals(3, find(exampleTest1));
        assertEquals(206847684, find(exampleTest2));
        assertEquals(0, find(exampleTest3));
    }

    public static void main(String[] args) {
        System.out.println(-21 %2);
    }
}
