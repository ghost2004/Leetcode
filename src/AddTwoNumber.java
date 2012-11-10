/*
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes
 *  contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 * 
 */
public class AddTwoNumber {

    public class ListNode {
        private int val;
        private ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        
        if (l1 == null) {
            if (l2 == null)
                return null;
            return l2;
        }
        
        if (l2 == null)
            return l1;
        ListNode out = null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        ListNode idx = out;
        while (p1 != null || p2 != null) {
            int c1 = 0, c2 = 0;
            if (p1 != null) {
                c1 = p1.val;
                p1 = p1.next;
            }
                
            if (p2 != null) {
                c2 = p2.val;
                p2 = p2.next;
            }
                
            int t = c1 + c2 + carry;
            int v = t % 10;
            carry = t / 10;
            if (out == null) {
                out = new ListNode(v);
                idx = out;
            }
            else {
                ListNode cur = new ListNode(v);
                idx.next = cur;
                idx = cur;
            }
            
        }
        
        if (carry != 0) {
            ListNode cur = new ListNode(carry);
            idx.next = cur;
        }
        
        return out;
        
    }

}
