package codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleCola {

    public static String WhoIsNext(String[] names, int n) {
        int N = names.length;
        int i;
        for (i = 1; n / sum(N, i) > 0; i++) ;

        int index = new Double(Math.ceil((double) (n - sum(N, i - 1)) / Math.pow(2, i - 1))).intValue() - 1;

        return names[index];
    }

    private static int sum(int N, int index) {
        if (index - 1 < 0)
            return 0;
        return N * (1 + 2 * ((int) Math.pow(2, index - 1) - 1));
    }


    public static String smartWhoIsNext(String[] names, int n){
        while ( n > names.length){
            n = (n - (names.length - 1)) / 2;
        }
        return names[n-1];
    }

    @Test
    public void test1() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 1;
        int expIndex = 0;

        System.out.println("n: " + n);
        System.out.println("expIndex: " + expIndex);

        assertEquals(names[expIndex], DoubleCola.WhoIsNext(names, n));


    }

    @Test
    public void test2() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 6;
        int expIndex = 0;

        System.out.println("n: " + n);
        System.out.println("expIndex: " + expIndex);

        assertEquals(names[expIndex], DoubleCola.WhoIsNext(names, n));
    }

    @Test
    public void test3() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 21;
        int expIndex = 1;

        System.out.println("n: " + n);
        System.out.println("expIndex: " + expIndex);

        assertEquals(names[expIndex], DoubleCola.WhoIsNext(names, n));
    }

    @Test
    public void test4() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 3;
        int expIndex = 2;

        System.out.println("n: " + n);
        System.out.println("expIndex: " + expIndex);

        assertEquals(names[expIndex], DoubleCola.WhoIsNext(names, n));
    }

    @Test
    public void test5() {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        int n = 63;
        int expIndex = 3;

        System.out.println("n: " + n);
        System.out.println("expIndex: " + expIndex);

        assertEquals(names[expIndex], DoubleCola.WhoIsNext(names, n));
    }
}
