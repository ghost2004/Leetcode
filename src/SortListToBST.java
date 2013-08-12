/*
 * Given a singly linked list where elements are sorted in
 *  ascending order, convert it to a height balanced BST.
 */
public class SortListToBST {
    public ListNode middle;
    public TreeNode fromListToTree(int begin, int end)
    {
        if (begin > end)
            return null;
        int mid = (begin + end)/2;
        TreeNode left = fromListToTree(begin, mid-1);
        TreeNode n = new TreeNode(middle.val);
        n.left = left;
        middle = middle.next;
        n.right = fromListToTree(mid+1, end);
        
        return n;
        
    }
    
    public int getListLength(ListNode head)
    {
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        return len;
                
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        
        int len = getListLength(head);
        middle = head;
        return fromListToTree(0, len-1);


    }
    
    public static void main(String[] args) {
        int[] array = {3, 5, 8};
        ListNode list = ListNode.initFromArray(array);
        SortListToBST bst = new SortListToBST();
        TreeNode node = bst.sortedListToBST(list);
        node.print();
        
    }
}
