//109. Convert Sorted List to Binary Search Tree
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

// In general, building BST we need find the middle one and recursively call the build function of
// left and right nodes.


// LinkedList need fast and slow pointer to find the middle one, and we also need keep track of the end point.
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)return null;
        return build(head, null);
    }
    private TreeNode build(ListNode head, ListNode tail){
        if(head == tail)return null;
        ListNode fast = head, slow = head;
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = build(head, slow);
        root.right = build(slow.next, tail);
        return root;
    }
}
