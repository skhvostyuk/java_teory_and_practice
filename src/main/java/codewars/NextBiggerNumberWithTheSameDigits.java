package codewars;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NextBiggerNumberWithTheSameDigits {

    public static long nextBiggerNumber(long n) {
        char[] digits = (n + "").toCharArray();

        int pointer = digits.length - 1;

        while (digits[pointer] <= max(digits, pointer) && pointer > 0) {
            pointer--;
        }
        System.out.println("pointer = " + pointer + ", digits[pointer] = " + digits[pointer]);
        int lowestBiggerNumberIndex = lowestBiggerNumberIndex(digits, pointer, digits[pointer]);
        System.out.println("lowestBiggerNumberIndex = " + lowestBiggerNumberIndex + ", digits[lowestBiggerNumberIndex] = " + digits[lowestBiggerNumberIndex]);
        if (digits[pointer] <= digits[lowestBiggerNumberIndex]) {
            char temp = digits[pointer];
            digits[pointer] = digits[lowestBiggerNumberIndex];
            digits[lowestBiggerNumberIndex] = temp;
        } else {
            return -1;
        }

        Arrays.sort(digits, pointer, digits.length);

        return Long.parseLong(new String(digits));
    }

    private static char max(char[] digits, int pointer) {
        char max = digits[pointer];
        for(int i = pointer; i < digits.length; i++)
            if(digits[i] > max)
                max = digits[i];
        return max;
    }

    private static int lowestBiggerNumberIndex(char[] digits, int pointer, int number) {
        int lowest = 1000;
        int index = pointer;
        for(int i = pointer; i < digits.length; i++)
            if(digits[i] > number && digits[i] < lowest) {
                lowest = digits[i];
                index = i;
            }
        return index;
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

//    @Test
//    public void basicTests() {
//        assertEquals(21, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(12));
//        assertEquals(531, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(513));
//        assertEquals(2071, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(2017));
//        assertEquals(441, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(414));
//        assertEquals(414, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(144));
//        assertEquals(1234567908, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(1234567890));
//        assertEquals(483559L, NextBiggerNumberWithTheSameDigits.nextBiggerNumber(459853L));
//    }
}
