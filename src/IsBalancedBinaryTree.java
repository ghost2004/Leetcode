
public class IsBalancedBinaryTree {
    
    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
    }
    public int depth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        int depth;
        if (leftDepth > rightDepth)
            depth = leftDepth+1;
        else
            depth = rightDepth+1;
        return depth;
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (!isBalanced(root.left))
            return false;
        if (!isBalanced(root.right))
            return false;
        
        if (Math.abs(depth(root.left) - depth(root.right))  > 1)
            return false;
        
        return true;
    }


}
