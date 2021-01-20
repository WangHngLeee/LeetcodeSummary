class Solution {
    List<Integer> res = new ArrayList<>();
    // Iterative Stack

    public List<Integer> inorderTraversal_Stack(TreeNode root) {
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                res.add(stack.peek().val);
                root = stack.pop().right;
            }
        }
        return res;
    }


    // recursive
    public List<Integer> inorderTraversal_Recursive(TreeNode root) {
        if (root == null) return res;
        help(root, res);
        return res;
    }

    public void help(TreeNode root, List<Integer> res) {
        if (root == null) return;
        help(root.left, res);
        res.add(root.val);
        help(root.right, res);
    }
}

