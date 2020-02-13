package leetcode.tree;

public class Task108_ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }


    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end)
            return new TreeNode(nums[start]);

        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (mid > start)
            node.left = sortedArrayToBST(nums, start, mid - 1);
        if (mid < end)
            node.right = sortedArrayToBST(nums, mid + 1, end);
        return node;
    }
}
