package leetcode.must_know;

import codewars.JadenCase;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 */
public class Task47_PermutationsII {
//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        Arrays.sort(nums);
//        return new ArrayList<>(permuteUnique(0, nums));
//    }
//
//    private static List<List<Integer>> permuteUnique (int index, int[] nums) {
//        if (index == nums.length - 1) {
//            List<List<Integer>> answer = new ArrayList<>();
//            answer.add(new LinkedList<>());
//            answer.get(0).add(nums[index]);
//            return answer;
//        }
//
//        List<List<Integer>> answer = new ArrayList<>();
//
//         List<List<Integer>> permutations = permuteUnique (index + 1, nums);
//         if (nums[index] == nums[index + 1])
//            return permutations;
//
//        for(List<Integer> currentList : permutations) {
//            for(int j = 0; j < currentList.size() + 1; j++) {
//                List<Integer> newList = new LinkedList<>(currentList);
//                newList.add(j, nums[index]);
//                answer.add(newList);
//            }
//        }
//        return answer;
//    }

//    private static List<List<Integer>> permuteUnique (int index, int[] nums) {
//        if (index == nums.length - 1) {
//            Set<List<Integer>> answer = new HashSet<>();
//            List<Integer> currentList = new LinkedList<>();
//            currentList.add(nums[index]);
//            answer.add(currentList);
//            return answer;
//        }
//
//        Set<List<Integer>> answer = new HashSet<>();
//
//        Set<List<Integer>> permutations = permuteUnique(index + 1, nums);
//
//        for(List<Integer> currentList : permutations) {
//            for(int j = 0; j < currentList.size() + 1; j++) {
//                List<Integer> newList = new LinkedList<>(currentList);
//                newList.add(j, nums[index]);
//                answer.add(newList);
//            }
//        }
//        return answer;
//    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public static void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        System.out.println(list);
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
                continue;
            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, res);
            used[i] = false;
            System.out.println(list);

            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[] {1,1,2}));
    }
//
//    @Test
//    public void permuteUniqueTest() {
//        assertEquals("Must return null when the arg is empty string", JadenCase.toJadenCase(""));
//    }
}
