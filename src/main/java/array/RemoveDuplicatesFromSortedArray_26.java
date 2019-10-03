package array;

import java.util.Arrays;
/* #26
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

public class RemoveDuplicatesFromSortedArray_26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1)
            return 0;
        int ret = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[ret] != nums[i]) {
                ret++;
                nums[ret] = nums[i];
            }
        }
        return ++ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 4, 5, 5 ,5 ,5 ,5, 6};

        System.out.println(removeDuplicates(arr) + "  " +  Arrays.toString(arr));
        arr = new int[]{1};
        System.out.println(removeDuplicates(arr) + "  " +  Arrays.toString(arr));
    }

}
