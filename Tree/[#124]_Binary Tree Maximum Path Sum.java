//124. Binary Tree Maximum Path Sum
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)return 0;
        dfs(root);
        return max;
    }
    private int dfs(TreeNode root){
        if(root == null)return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left,right) + root.val;
    }
}