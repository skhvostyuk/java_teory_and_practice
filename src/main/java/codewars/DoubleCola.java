package codewars;

import org.junit.Test;

import javax.sound.sampled.Line;

import static org.junit.Assert.assertEquals;

public class DoubleCola {

    public static String WhoIsNext(String[] names, int n) {
        int N = names.length;

        int i;
        for (i = 1; n / sum(N, i) > 0; i++);
        System.out.println("i: " + i);
        System.out.println("Sum: " + sum(N, i));

        System.out.println("n: " + n);
        int index = (n - sum(N, i-1))/i;
        System.out.println("index: " + index);

        return names[index];
    }

    private static int sum(int N, int index) {
        if (index - 1 < 0)
            return 0;
        return N * (1 + 2 * ((int) Math.pow(2, index - 1) - 1));
    }


    @Test
    public void test1() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 1;
        assertEquals("Sheldon", DoubleCola.WhoIsNext(names, n));
    }

    @Test
    public void test2() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 6;
        assertEquals("Sheldon", DoubleCola.WhoIsNext(names, n));
    }
}
