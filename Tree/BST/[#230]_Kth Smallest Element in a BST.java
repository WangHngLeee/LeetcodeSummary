//230. Kth Smallest Element in a BST


class Solution {

    // iterative
    public int kthSmallest_iterative(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)return 0;
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                k--;
                if(k==0)return cur.val;
                cur = cur.right;
            }
        }
        return -1;
    }

    // Recursive
    int val;
    int count = 0;
    public int kthSmallest_recursive(TreeNode root, int k) {
        if(root == null)return 0;
        dfs(root, k);
        return val;
    }
    private void dfs(TreeNode root, int k){
        if(root == null)return;
        dfs(root.left, k);
        count++;
        if(count == k){
            val = root.val;
            return;
        }
        dfs(root.right, k);
    }
}







