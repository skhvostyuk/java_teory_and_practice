package array;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class Task169_MajorityElement {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }

        Map.Entry<Integer, Integer> majorityEntry = null;

        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue())
                majorityEntry = entry;

        return  majorityEntry.getKey();
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

}
