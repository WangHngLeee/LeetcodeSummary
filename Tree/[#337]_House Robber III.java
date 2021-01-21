//337. House Robber III
// https://leetcode.com/problems/house-robber-iii/

// 两种rob方案 ： 1. rob当前节点的左右子节点
//              2. rob当前节点，以及跳过了直接的left/right节点，直接找子子节点。
// 加一个map 来 memo dfs。

class Solution {
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null)return 0;
        if(map.containsKey(root))return map.get(root);
        int val1 = root.val;
        if(root.left != null)val1 += rob(root.left.left) + rob(root.left.right);
        if(root.right != null)val1 += rob(root.right.left) + rob(root.right.right);
        int val2 = rob(root.left) + rob(root.right);
        int res = Math.max(val1, val2);
        map.put(root, res);
        return res;
    }
}