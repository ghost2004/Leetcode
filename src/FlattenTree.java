import java.util.LinkedList;
/*
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Hints:
If you notice carefully in the flattened tree, each node's right child
 points to the next node of a pre-order traversal.
 */

public class FlattenTree {
    // in place solution
    public void flattenInPlace(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left == null) {
            flattenInPlace(root.right);
            return;
        }
            
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            flattenInPlace(root.right);
            return;
        }
        
        TreeNode node = root.left;
        while (node.right != null)
            node = node.right;
        
        node.right = root.right;
        root.right = root.left;
        root.left = null;
        
        flattenInPlace(root.right);
            
    
    }
    // the solution with queue
    public void preOrder(TreeNode node, LinkedList<TreeNode> queue)
    {
        if (node == null)
            return;
        queue.addLast(node);
        preOrder(node.left, queue);
        preOrder(node.right, queue);
    }
    
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        preOrder(root, queue);
        
        TreeNode node = queue.removeFirst();
        while (!queue.isEmpty()) {
            TreeNode next = queue.removeFirst();
            node.left = null;
            node.right = next;
            node = next;
        }
        
       
    }

}
