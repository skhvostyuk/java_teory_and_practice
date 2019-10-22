package array;

import java.util.Arrays;

public class Task27_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int ret = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[ret] = nums[i];
                ret++;
            }
        }

        return  ret;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 4, 5, 5 ,5 ,5 ,5, 6};

        System.out.println(removeElement(arr, 3) + "  " +  Arrays.toString(arr));
        arr = new int[]{1};
        System.out.println(removeElement(arr, 1) + "  " +  Arrays.toString(arr));
    }
}
