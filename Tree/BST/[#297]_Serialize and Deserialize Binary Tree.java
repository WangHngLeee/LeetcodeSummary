//297. Serialize and Deserialize Binary Tree
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/

// inorder
class Solution {
    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serial(root,res);
        return res.toString();
    }
    public void serial(TreeNode root, StringBuilder res){
        if(root == null)res.append("null").append(" ");
        else{
            res.append(root.val).append(" ");
            serial(root.left,res);
            serial(root.right,res);
        }
    }
    public TreeNode deserialize(String source){
        Queue<String> queue = new LinkedList<>();
        String[] strs = source.split(" ");
        for(String str : strs){
            queue.add(str);
        }
        return des(queue);
    }
    public TreeNode des(Queue<String> queue){
        String cur = queue.poll();
        if(cur.equals("null"))return null;
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = des(queue);
        node.right = des(queue);
        return node;
    }
}
