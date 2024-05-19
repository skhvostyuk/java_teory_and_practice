package leetcode.dynamic_programming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Task45_JumpGameII {

    public int jump(int[] nums) {
        int variants[] = new int[nums.length];

        for(int i = 1; i < nums.length; i++) {
            variants[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; j <= nums[i] && i + j < nums.length; j++) {
                variants[i + j] = Math.min(variants[i + j], variants[i] + 1);
            }
        }
        System.out.println(Arrays.toString(variants));
        return variants[nums.length - 1];
    }

    @Test
    public void test() {
        //[2,3,1,1,4]
        Assertions.assertEquals(2, jump(new int[]{2,3,1,1,4}));


    }
}
