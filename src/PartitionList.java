/*
 * Given a linked list and a value x, partition it such that all nodes
 *  less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each 

of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode root = new ListNode(0);
        ListNode pivot = new ListNode(0);
        ListNode cur = head;
        ListNode lastPivot = pivot;
        ListNode lastRoot = root;
        
        while (cur != null) {
            ListNode next = cur.next;
            
            if (cur.val < x) {
                lastRoot.next = cur;
                lastRoot = cur;
                lastRoot.next = null;
                
            } else {
                lastPivot.next = cur;
                lastPivot = cur;
                lastPivot.next = null;
            }
            
            cur = next;
        }
        
        lastRoot.next = pivot.next;
        
        return root.next;

    }
    
    public static void main(String[] args) {
        PartitionList l = new PartitionList();
        int[] ar = {1, 4, 3, 2, 5, 2};
        ListNode r1 = ListNode.initFromArray(ar);
        ListNode.printListNode(l.partition(r1, 3));
    }

}
