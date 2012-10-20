
public class IsBalancedBinaryTree {
    
    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
    }
    public int checkDepth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = checkDepth(node.left);
        if (leftDepth == -1)
            return -1;
        int rightDepth = checkDepth(node.right);
        
        if (rightDepth == -1)
            return -1;
        
        if (Math.abs(leftDepth - rightDepth) > 1)
            return -1;
        
        int depth;
        
        if (leftDepth > rightDepth)
            depth = leftDepth+1;
        else
            depth = rightDepth+1;
        return depth;
    }
    

    public boolean isBalanced(TreeNode root) {
        if (checkDepth(root) == -1)
            return false;
        return true;
    }


}
