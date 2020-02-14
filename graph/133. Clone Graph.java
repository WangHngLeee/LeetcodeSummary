class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)return null;
        Map<Node,Node> map = new HashMap<>();
        Node dummy = new Node(node.val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node,dummy);
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            for(Node nb : temp.neighbors){
                if(!map.containsKey(nb)){
                    map.put(nb,new Node(nb.val));
                    queue.add(nb);
                }
                map.get(temp).neighbors.add(map.get(nb));
            }
        }
        return dummy;
    }
}
// 每个node复制一份，然后相对应的neighbors也复制并且对应起来。