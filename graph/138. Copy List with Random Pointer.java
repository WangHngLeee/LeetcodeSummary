class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node node = head;
        while(node!=null){
            map.put(node, new Node(node.val));
            node = node.next;
        }
        node = head;
        while(node!=null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
// 和 133一个思路，copy 类型题用map比较容易。