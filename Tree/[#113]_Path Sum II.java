//113. Path Sum II
https://leetcode.com/problems/path-sum-ii/

// Preorder + backtracking

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null)return res;
        help(root,sum);
        return res;
    }
    private void help(TreeNode root, int sum){
        if(root == null) return;
        temp.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<>(temp));
        }
        help(root.left,sum-root.val);
        help(root.right, sum-root.val);
        temp.remove(temp.size() - 1);
    }
}