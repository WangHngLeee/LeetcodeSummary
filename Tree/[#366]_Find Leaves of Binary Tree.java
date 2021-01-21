//366. Find Leaves of Binary Tree
https://leetcode.com/problems/find-leaves-of-binary-tree/

// Using the same solution of getting height. Just to add a level/ arraylist size to make it triky.

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null)return res;
        help(root);
        return res;
    }
    private int help(TreeNode root){
        if(root == null)return -1;
        int left = help(root.left);
        int right = help(root.right);
        int level = 1 + Math.max(left,right);
        if(res.size() < level + 1)res.add(new ArrayList<>());
        res.get(level).add(root.val);
        return level;
    }
}