/*
 * Reverse a linked list from position m to n. 
 * Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ? m ? n ? length of list.
 */
public class ReverseLinkListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode start = head;
        ListNode prev = newHead;
        ListNode tmp;
        int step = 1;
        
        while (start != null && step < m) {
            prev = start;
            start = start.next;
            step++;
        }
        
        if (start == null)
            return head;
        ListNode cur = start;
        ListNode next = cur.next;
        
        while (next != null && step < n) {
            tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
            step++;
        }
        
        prev.next = cur;
        start.next = next;
        


        return newHead.next;
    }
    
    
    public static void main(String[] arg) {
        ListNode node;
        int[] a = {1, 2, 3};
        node = ListNode.initFromArray(a);
        ReverseLinkListII rev = new ReverseLinkListII();
        ListNode.printListNode(rev.reverseBetween(node, 1, 3));
    }
}
