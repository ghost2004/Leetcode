
/*
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the 

shortest path from the root node down to the nearest leaf node.
 */
public class MinDepthBinTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        if (root.left == null && root.right == null)
            return 1;
        
        if (root.left == null)
            return 1+minDepth(root.right);
        
        if (root.right == null)
            return 1+minDepth(root.left);
        
        return Math.min(1+(minDepth(root.left)), 1+(minDepth(root.right)));
        
    }

}
