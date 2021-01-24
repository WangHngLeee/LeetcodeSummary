//98. Validate Binary Search Tree
https://leetcode.com/problems/validate-binary-search-tree/

// Always use two boundary in BST question.
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean help(TreeNode root, long min, long max){
        if(root == null)return true;
        if(root.val <= min || root.val >= max)return false;
        return help(root.left, min, root.val) && help(root.right, root.val, max);
    }
}