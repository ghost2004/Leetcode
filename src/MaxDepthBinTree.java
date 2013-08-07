/*
 * Given a binary tree, find its maximum depth.

  The maximum depth is the number of nodes along the
    longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthBinTree {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        return Math.max(1+maxDepth(root.left), 1+maxDepth(root.right));

    }
}
