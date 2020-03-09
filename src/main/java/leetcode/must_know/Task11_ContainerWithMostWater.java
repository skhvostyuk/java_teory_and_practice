package leetcode.must_know;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task11_ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = -1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    @Test
    public void test() {
        assertEquals(49, maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));

    }
}
