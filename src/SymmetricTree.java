import java.util.ArrayList;
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
    
    public void inOrder(TreeNode node, ArrayList<Integer> list)
    {
        if (node == null)
            return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
    
    public boolean isSymmetric(TreeNode root) {
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

}
