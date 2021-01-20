//298. Binary Tree Longest Consecutive Sequence
https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/

// preorder
class Solution {
    int max = Integer.MIN_VALUE;
    public int longestConsecutive(TreeNode root) {
        if(root == null)return 0;
        help(root, 0, root.val);
        return max;
    }
    private void help(TreeNode root, int total, int target){
        if(root == null)return;
        if(root.val == target)total++;
        else total = 1;
        max = Math.max(max, total);
        help(root.left, total, root.val + 1);
        help(root.right, total, root.val + 1);
    }
}