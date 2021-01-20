
class Solution {
    List<Integer> res = new ArrayList<>();

    // Iterative Stack
    public List<Integer> preorderTraversal_Stack(TreeNode root) {
        if(root == null)return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return res;
    }

    // Recursive
    public List<Integer> preorderTraversal_Recursive(TreeNode root) {
        if(root == null)return res;
        help(root);
        return res;
    }
    private void help(TreeNode root){
        if(root == null)return;
        res.add(root.val); // deal with root
        help(root.left); // move to left
        help(root.right); // move to right
    }
}