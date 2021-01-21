//250. Count Univalue Subtrees
https://leetcode.com/problems/count-univalue-subtrees/

// 思路是先序遍历树的所有的节点，然后对每一个节点调用判断以当前节点为根的子树的所有节点是否相同

class Solution {
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)return 0;
        help(root);
        return count;
    }
    public boolean help(TreeNode root){
        if(root == null)return true;
        boolean left = help(root.left);
        boolean right = help(root.right);
        if(left && right){
            if(root.left != null && root.val != root.left.val)return false;
            if(root.right != null && root.val != root.right.val)return false;
            count++;
            return true;
        }else return false;
    }
}


