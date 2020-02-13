package leetcode.array;

import java.util.Arrays;

public class Task66_PlusOne {

    public static int[] plusOne(int[] digits) {
        if (digits.length == 1) {
            digits[0]++;

            if(digits[0] > 9)
                return new int[]{1, 0};
            return digits;
        }
        for(int i = digits.length-1; i > 0; i--) {
            digits[i]++;
            if (digits[i] > 9) {
                digits[i] = 0;
                digits[i-1]++;
                if(digits[i-1] < 10)
                    break;
            } else
                break;
        }

        if(digits[0] > 9) {
            int[] ret = new int[digits.length + 1];
            Arrays.fill(ret, 0);
            ret[0] = 1;
            return ret;
        }
        return digits;
    }


    //Leetcode solution
    public int[] plusOne2(int[] digits) {
        int carry = 1, n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] + carry == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            int[] newArray = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                newArray[i+1] = digits[i];
            }
            newArray[0] = 1;
            return newArray;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(plusOne(new int[]{9})));
        System.out.println(Arrays.toString(plusOne(new int[]{1,2,9})));
        System.out.println(Arrays.toString(plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(plusOne(new int[]{9,9,9,9})));


    }
}
