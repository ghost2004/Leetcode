
/*
 * Given a sorted linked list, delete all nodes 
 * that have duplicate numbers, leaving only 
 * distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class RemoveDupSortListII {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead =  new ListNode(0);
        newHead.next = head;
        ListNode cur = newHead;
        
        while (cur.next != null) {
            ListNode next = cur.next;
             while (next.next != null && next.next.val == next.val) {
                 next = next.next;
             }
             
             if (cur.next != next) 
                 cur.next = next.next;
             else
                 cur = cur.next;
            
        }

        return newHead.next;
    }
}
