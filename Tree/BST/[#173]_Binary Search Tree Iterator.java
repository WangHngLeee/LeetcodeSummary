//173. Binary Search Tree Iterator
https://leetcode.com/problems/binary-search-tree-iterator/


// Using classic iterative method to traverse the BST from small to large.

class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode node;
    public BSTIterator(TreeNode root) {
        node = root;
        stack = new Stack<>();
    }
    public int next() {
        while(node != null){
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int res = node.val;
        node = node.right;
        return res;
    }
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }
}
