/*
 * Given a linked list, remove the nth node from the 
 * end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class RemoveNthFromList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        int i = 0;
        
        ListNode tail = head;
        for (i = 0; i < n; i++) {
            if (tail == null)
                return null;
            tail = tail.next;
        }
        ListNode nth = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevNth = dummy;
        while (tail != null) {
            tail = tail.next;
            nth = nth.next;
            prevNth = prevNth.next;
        }
        
        prevNth.next = nth.next;
        
        return dummy.next;
            
        


    }
}
