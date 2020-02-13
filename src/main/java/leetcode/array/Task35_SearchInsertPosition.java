package leetcode.array;

import java.util.Arrays;

public class Task35_SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (target > nums[mid])
                low = mid + 1;
            else if (target < nums[mid])
                high = mid - 1;
            else
                return mid; // key found
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 6};

        System.out.println(searchInsert(arr, 3) + "  " + Arrays.toString(arr) + " " + 3);
        arr = new int[]{1};
        System.out.println(searchInsert(arr, 1) + "  " + Arrays.toString(arr) + " " + 1);
        arr = new int[]{1,3};
        System.out.println(searchInsert(arr, 1) + "  " + Arrays.toString(arr) + " " + 1);
        System.out.println(searchInsert(arr, 7) + "  " + Arrays.toString(arr) + " " + 7);
    }
}
