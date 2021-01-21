//129. Sum Root to Leaf Numbers
https://leetcode.com/problems/sum-root-to-leaf-numbers/

// preorder

class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return help(root, 0);
    }
    private int help(TreeNode root, int sum){
        if(root == null)return 0;
        sum = sum*10 + root.val;
        if(root.left == null && root.right == null)return sum;
        int left = help(root.left, sum);
        int right = help(root.right, sum);
        return left + right;
    }
}