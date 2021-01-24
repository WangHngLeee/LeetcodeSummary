//199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/


class Solution {

    List<Integer> res = new ArrayList<>();

    // BFS
    public List<Integer> rightSideView_BFS(TreeNode root) {
        if(root == null)return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0 ;i<size;i++){
                TreeNode temp = queue.poll();
                if( i>= size-1)res.add(temp.val);
                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);
            }
        }
        return res;
    }

//    DFS
    public List<Integer> rightSideView_DFS(TreeNode root) {
        if(root == null) return res;
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode root, int level){
        if(root == null)return;
        if(res.size() == level){
            res.add(root.val);
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}