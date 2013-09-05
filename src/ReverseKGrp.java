/*
 * Given a linked list, reverse the nodes of a linked list k 
 * at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out 
nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself 
may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
 */
public class ReverseKGrp {
    public ListNode getNextN(ListNode node, int n) {
        int i = 0;
        ListNode cur = node;
        while (cur != null && i < n-1) {
            cur = cur.next;
            i++;
        }
        return cur;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p0 = dummy;
        ListNode p1 = head;
        ListNode p2 = getNextN(p1, k);
        
        while (p2 != null) {
            ListNode p3 = p2.next;
            ListNode prev = p1;
            ListNode cur = p1.next;
            ListNode next;
            for (int i = 1; i < k; i++) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            p0.next = p2;
            p1.next = p3;
            p0 = p1;
            p1 = p1.next;
            p2 = getNextN(p1, k);
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ReverseKGrp r = new ReverseKGrp();
        int[] a1 = {1, 2};
        int[] a2 = {1, 2, 3};
        ListNode n1 = ListNode.initFromArray(a1);
        ListNode n2 = ListNode.initFromArray(a2);
        ListNode.printListNode(r.reverseKGroup(n1, 2));
        ListNode.printListNode(r.reverseKGroup(n2, 3));
    }
}

