package leetcode.array;

import java.util.Arrays;

/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted leetcode.array.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 */
public class Task88_MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1, p2 = 0;
        for (p1 = 0; p1 < n + m; p1++) {
            if (p2 < n && nums1[p1] <= nums2[p2] && p1 < m + p2);
            else if (p2 < n) {
                if (p1 + 1 < n + m)
                    System.arraycopy(nums1, p1, nums1, p1 + 1, n + m - p1 - 1);
                nums1[p1] = nums2[p2];
                p2++;
            }
        }
    }

    public static void mergeFromTheEnd(int[] nums1, int m, int[] nums2, int n) {
        while (m  > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[n + m - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[n + m - 1] = nums2[n - 1];
                n--;
            }
        }
        for(; n > 0; n--)
            nums1[n - 1] = nums2[n - 1];
    }



    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0}; // m = 3
        int[] arr2 = {2, 5, 6}; // n = 3
        mergeFromTheEnd(arr1, 3, arr2, 3);
        System.out.println("\n" + Arrays.toString(arr1) + "\n");

        arr1 = new int[]{2, 3, 3, 4, 0, 0, 0, 0}; // m = 4
        arr2 = new int[]{2, 3, 5, 6}; // n = 4
        mergeFromTheEnd(arr1, 4, arr2, 4);
        System.out.println("\n" + Arrays.toString(arr1) + "\n");

        arr1 = new int[]{1}; // m = 1
        arr2 = new int[]{}; // n = 0
        mergeFromTheEnd(arr1, 1, arr2, 0);
        System.out.println("\n" + Arrays.toString(arr1) + "\n");

        arr1 = new int[]{2, 0}; // m = 1
        arr2 = new int[]{1}; // n = 0
        mergeFromTheEnd(arr1, 1, arr2, 1);
        System.out.println("\n" + Arrays.toString(arr1) + "\n");

        arr1 = new int[]{4,5,6,0,0,0}; // m = 3
        arr2 = new int[]{1,2,3}; // n = 3
        mergeFromTheEnd(arr1, 3, arr2, 3);
        System.out.println("\n" + Arrays.toString(arr1) + "\n");
    }
}
