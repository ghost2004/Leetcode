/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */
public class RemoveDupSortList {
    
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;        
        ListNode last = head;
        int value = head.val;
        
        while (cur.next != null) {
            cur = cur.next;
            if (cur.val != value) {
                if (last.next != cur)
                    last.next = cur;
                last = cur;
                value = cur.val;
            } 
        }
        
        if (last != cur) {
            last.next = null;
        }
        return head;
    }

}
