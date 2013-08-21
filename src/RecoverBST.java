import java.util.ArrayList;
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
    TreeNode prev;
    int idx;

    
    public void searchMis(TreeNode cur)
    {
        if (cur == null)
            return;
        searchMis(cur.left);
        if (prev != null && prev.val > cur.val) {
            if (idx == 0) {
                nodes[0] = prev;
                nodes[1] = cur;
                idx = 1;
            } else {
                nodes[1] = cur;
            }
            
                
        }
        prev = cur;
        
        searchMis(cur.right);
    }
    
    public void recoverTree(TreeNode root) {
        nodes = new TreeNode[2];
        idx = 0;
        nodes[0] = null;
        nodes[1] = null;

        prev = null;
        searchMis(root);
        int tmp = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = tmp;
    }
    
    public static void main(String[] args)
    {
        RecoverBST r = new RecoverBST();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = left;
        root.left = right;
        r.recoverTree(root);
        root.print();
    }
}

