//314. Binary Tree Vertical Order Traversal
https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        Map<Integer, List<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> tree = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        tree.add(root);
        cols.add(0);
        int left = 0;
        int right = 0;
        while(!tree.isEmpty()){
            TreeNode temp = tree.poll();
            int col = cols.poll();
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(temp);
            if(temp.left != null){
                tree.add(temp.left);
                cols.add(col - 1);
                left = Math.min(col-1, left);
            }
            if(temp.right != null){
                tree.add(temp.right);
                cols.add(col + 1);
                right = Math.max(col+1,right);
            }
        }
        for(int i = left ; i<=right; i++){
            List<Integer> templist = new ArrayList<>();
            for(TreeNode node : map.get(i)){
                templist.add(node.val);
            }
            res.add(templist);
        }
        return res;
    }
}