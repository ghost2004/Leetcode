/*
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 */
public class RotateList {



    public class ListNode {
        private int val;
        private ListNode next;
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null)
            return null;
        
        if (n == 0)
            return head;
        
        int length = 0;
        
        ListNode cur = head;
        ListNode tail = head;
        
        // Find the length of the link list
        while (cur != null) {
            tail = cur;
            cur = cur.next;
            length++;
        }
        
        // Make a circle
        tail.next = head;
        cur = head;
        
        // Step to new break
        for (int i = 0; i < length - (n % length); i++) {
            tail = cur;
            cur = cur.next;
        }
        // Break it here
        tail.next =  null;
        
        return cur;
        

        

    }



}
