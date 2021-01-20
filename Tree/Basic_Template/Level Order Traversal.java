// BFS Traverse
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> templist = new ArrayList<>();
            for(int i=0 ;i<size ;i++){
                TreeNode temp = queue.poll();
                templist.add(temp.val);
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
            res.add(templist);
        }
        return res;
    }
}
