//328. Odd Even Linked List
https://leetcode.com/problems/odd-even-linked-list/description/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)return null;
        ListNode odd = head, even = head.next, evenhead = even;
        while(even != null && even.next != null){
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;

        }
        odd.next = evenhead;
        return head;
    }
}