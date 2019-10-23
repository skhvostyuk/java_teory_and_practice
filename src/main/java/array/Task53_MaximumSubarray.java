package array;

/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class Task53_MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int ret = nums[0];
        int holder = nums[0];

        for (int i = 1; i < nums.length; i++) {
            holder = nums[i] + Math.max(holder, 0);  // We interested only in positive "left tail"
            ret = Math.max(ret, holder);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{-2,1}));

    }
}
