//116. Populating Next Right Pointers in Each Node
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

class Solution {
    public Node connect(Node root) {
        if(root == null)return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                Node temp = queue.poll();
                temp.next = i < size -1 ? queue.peek() : null;
                if(temp.left != null)queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
            }
        }
        return root;
    }
}