import java.util.ArrayList;
import java.util.LinkedList;
/*
 * Given a binary tree, check whether it is a mirror of itself
 *  (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:

    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.


 */
public class SymmetricTree {
    
    // Inorder travseral solution
    public void inOrder(TreeNode node, ArrayList<Integer> list)
    {
        if (node == null)
            return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
    
    public boolean isSymmetricV1(TreeNode root) {
        if (root == null)
            return true;
        ArrayList<Integer> list = new ArrayList<Integer>();
        inOrder(root, list);
        if ((list.size() % 2) != 1)
            return false;
        int middle = (list.size()-1)/2;
        for (int idx = 1; idx <= middle; idx++) {
            if (list.get(middle-idx) != list.get(middle+idx))
                return false;
        }
        
        return true;    
    }
    
    // recursively solution
    public boolean checkSym(TreeNode left, TreeNode right)
    {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return (checkSym(left.left, right.right)
                && checkSym(left.right, right.left));
    }
    public boolean isSymmetricV2(TreeNode root) {
        if (root == null)
            return true;
        return checkSym(root.left, root.right);
    }
    
    // iteratively solution
    
    public boolean isSymmetricV3(TreeNode root) {
        if (root == null)
            return true;
        LinkedList<TreeNode> left = new LinkedList<TreeNode>();
        LinkedList<TreeNode> right = new LinkedList<TreeNode>();
        
        left.addLast(root.left);
        right.addLast(root.right);
        
        while (!left.isEmpty() && !right.isEmpty()) {
            TreeNode nl = left.removeFirst();
            TreeNode nr = right.removeFirst();
            
            if (nl == null && nr == null)
                continue;
            if (nl == null || nr == null)
                return false;
            if (nl.val != nr.val)
                return false;
            left.addLast(nl.left);
            left.addLast(nl.right);
            right.addLast(nr.right);
            right.addLast(nr.left);
        }
        
        if (left.isEmpty() && right.isEmpty())
            return true;
        
        return false;
        
              

    }
    

}
