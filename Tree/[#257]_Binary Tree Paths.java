//257. Binary Tree Paths
https://leetcode.com/problems/binary-tree-paths/

// Preorder + backtracking

class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)return res;
        help(root);
        return res;
    }
    private void help(TreeNode root){
        if(root == null)return;
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null){
            res.add(sb.toString());
        }
        sb.append("->");
        help(root.left);
        help(root.right);
        sb.setLength(len);
    }
}