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
    
    ArrayList<TreeNode> nodes;
    TreeNode prev;

    
    public void searchMis(TreeNode cur)
    {
        if (cur == null)
            return;
        searchMis(cur.left);
        if (prev != null && prev.val > cur.val) {
            if (!nodes.contains(prev))
                nodes.add(prev);
            if (!nodes.contains(cur))
                nodes.add(cur);
                
        }
        prev = cur;
        
        searchMis(cur.right);
    }
    
    public void recoverTree(TreeNode root) {
        nodes = new ArrayList<TreeNode>();

        prev = null;
        searchMis(root);
        int tmp = nodes.get(0).val;
        nodes.get(0).val = nodes.get(nodes.size()-1).val;
        nodes.get(nodes.size()-1).val = tmp;
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

