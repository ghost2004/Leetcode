/*
 * Given a linked list, swap every two adjacent
 *  nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not 

modify the values in the list, only nodes itself can be changed.
 */

public class SwapNodeInPair {
    public ListNode swapPairs(ListNode head) {
    
        if (head == null)
            return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        while (p1 != null && p2 != null) {
            ListNode p3 = p2.next;
            p0.next = p2;
            p1.next = p3;
            p2.next = p1;
            
            p0 = p1;
            p1 = p3;
            if (p1 != null)
                p2 = p1.next;
        }
        return dummy.next;
    }
}
