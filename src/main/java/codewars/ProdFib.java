package codewars;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProdFib {

    public static long[] productFib(long prod) {
        // your code
        return null;
    }

    @Test
    public void test1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, ProdFib.productFib(4895));
    }
    @Test
    public void test2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, ProdFib.productFib(5895));
    }
}
