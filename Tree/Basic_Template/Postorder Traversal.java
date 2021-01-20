class Solution {
    List<Integer> res = new ArrayList<>();

    // Iterative Stack
    public List<Integer> postorderTraversal_Stack(TreeNode root) {

        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            res.add(0, curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        return list;
    }

    // Recursive
    public List<Integer> postorderTraversal_Recursive(TreeNode root) {
        if(root == null)return res;
        help(root,res);
        return res;
    }
    public void help(TreeNode root, List<Integer> res){
        if(root == null)return;
        help(root.left,res);
        help(root.right,res);
        res.add(root.val);
    }
}
