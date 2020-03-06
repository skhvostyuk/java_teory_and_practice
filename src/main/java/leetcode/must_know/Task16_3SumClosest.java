package leetcode.must_know;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertEquals;

public class Task16_3SumClosest {


    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer answer = null;

        for (int i = 1; i < nums.length; i++) {

            int leftPointer = 0; int rightPointer = nums.length - 1;

            while (leftPointer < i && rightPointer > i) {

                int localResult = nums[i] + nums[leftPointer] + nums[rightPointer];
                if(localResult == target)
                    return target;
                if (answer == null)
                    answer = localResult;
                if (Math.abs(target - localResult) < Math.abs(target - answer))
                    answer = localResult;
                else if (localResult < target)
                    leftPointer++;
                else
                    rightPointer--;
            }
        }
        return answer;
    }


    @Test
    public void test() {
        assertEquals(2, threeSumClosest(new int[] {-1, 2, 1, 4}, 1));
    }
}
