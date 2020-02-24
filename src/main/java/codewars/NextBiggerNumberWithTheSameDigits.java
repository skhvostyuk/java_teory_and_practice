package codewars;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NextBiggerNumberWithTheSameDigits {

    public static long nextBiggerNumber(long n) {
        char[] digits = (n + "").toCharArray();

        int fast = digits.length - 1;

        while (digits[fast] <= digits[fast - 1] && fast - 1 > 0) {
            fast--;
        }
        //System.out.println("fast = " + fast + ", digits[fast] = " + digits[fast] + ", fast - 1 = " + (fast - 1) + ", digits[fast - 1] = " + digits[fast - 1]);
        if (digits[fast] > digits[fast - 1]) {
            char temp = digits[fast];
            digits[fast] = digits[fast - 1];
            digits[fast - 1] = temp;
        } else {
            return -1;
        }

        Arrays.sort(digits, fast, digits.length);

        return Long.parseLong(new String(digits));
    }

//    public static void main(String[] args) {
//        System.out.println(nextBiggerNumber(12));
//        System.out.println(nextBiggerNumber(513));
//        System.out.println(nextBiggerNumber(2017));
//        System.out.println(nextBiggerNumber(414));
//        System.out.println(nextBiggerNumber(144));
//        System.out.println(nextBiggerNumber(1234567890));
//
//    }

    @Test
    public void basicTests() {
        assertEquals(21, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(12));
        assertEquals(531, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(513));
        assertEquals(2071, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(2017));
        assertEquals(441, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(414));
        assertEquals(414, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(144));
        assertEquals(1234567908, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(1234567890));
        assertEquals(483559L, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(459853L));


    }
}
