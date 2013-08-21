
/*
 * Two elements of a binary search tree (BST)
 *  are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward.
 Could you devise a constant space solution?
 */
public class RecoverBST {
    
    TreeNode[] nodes;
    TreeNode pre;
    int idx;

    // Solution with inorder traversal 
    // Need O(lgn) stack space in average, 
    // O(n) in the worst case
    public void searchMis(TreeNode cur)
    {
        if (cur == null)
            return;
        searchMis(cur.left);
        if (pre != null && pre.val > cur.val) {
            if (idx == 0) {
                nodes[0] = pre;
                nodes[1] = cur;
                idx = 1;
            } else {
                nodes[1] = cur;
            }
            
                
        }
        pre = cur;
        
        searchMis(cur.right);
    }
    
    public void recoverTree(TreeNode root) {
        nodes = new TreeNode[2];
        idx = 0;
        nodes[0] = null;
        nodes[1] = null;

        pre = null;
        searchMis(root);
        int tmp = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = tmp;
    }
    
    // Morris Traversal solution
    public void recoverTreeMorris(TreeNode root) {
        TreeNode n1 = null;
        TreeNode n2 = null;
        TreeNode prev = null;
        TreeNode parent = null;
        TreeNode cur = root;
        
        while (cur != null) {
            if (cur.left == null) {
                // go to right sub tree when left is empty
                if (parent != null && parent.val > cur.val) {
                    if (n1 == null)
                        n1 = parent;
                    n2 = cur;
                }
                parent = cur;
                cur = cur.right;
            } else {
                // find predecessor
                prev = cur.left;
                
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;
                
                if (prev.right == null) {
                    // set the right child of previous node 
                    // to cur when it is null
                    prev.right = cur;
                    // move to its left child
                    cur = cur.left;
                    
                    
                } else {
                    // prev.right == cur
                    // remove the additional link
                    prev.right = null;
                    if (parent != null && parent.val > cur.val) {
                        if (n1 == null)
                            n1 = parent;
                        n2 = cur;
                    }
                    parent = cur;
                    cur = cur.right;

                }
                   
                
                
            }
        }
        

        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
        
    }
    
    
    public static void main(String[] args)
    {
        RecoverBST r = new RecoverBST();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.right = left;
        root.left = right;
        r.recoverTreeMorris(root);
        root.print();
    }
}

