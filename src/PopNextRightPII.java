
/*
 * Follow up for problem "Populating Next Right 
 * Pointers in Each Node".

What if the given tree could be any binary tree? 

Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopNextRightPII {
    
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
    
    public void connect(TreeLinkNode root) {
        
        TreeLinkNode cur = root;

        
        while (cur != null) {
            TreeLinkNode next = null;
            TreeLinkNode prev = null;
            
            while (cur != null) {
                if (next == null) {
                    if (cur.left != null)
                        next = cur.left;
                    else
                        next = cur.right;
                }
                
                if (cur.left != null) {
                    if (prev != null)
                        prev.next = cur.left;
                    prev = cur.left;
                }
                
                if (cur.right != null) {
                    if (prev != null)
                        prev.next = cur.right;
                    prev = cur.right;
                }
                   
                    
                cur = cur.next;
            }
            cur = next;
        }
        


    }

}
