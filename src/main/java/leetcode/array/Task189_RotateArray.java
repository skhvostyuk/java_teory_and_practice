package leetcode.array;

import java.util.Arrays;

/*
 * Given an leetcode.array, rotate the leetcode.array to the right by k steps, where k is non-negative.
 */
public class Task189_RotateArray {

    public static void rotate(int[] nums, int k) {
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int holder = nums[start];
            do {
                int next = (current + k) % nums.length;
                int tmp =  nums[next];
                nums[next] = holder;
                holder = tmp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,3};
        rotate(arr, 1);
        System.out.println(Arrays.toString(arr));
        arr = new int[]{1,2,3,4,5,6,7};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));

    }

}
