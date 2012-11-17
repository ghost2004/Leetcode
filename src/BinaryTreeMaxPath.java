/*
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 * 
 */
public class BinaryTreeMaxPath {
    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public class TreeVal {
        private int self;
        private int export;
        TreeVal() {
            self = 0;
            export = 0;
        }
    }
    

    
    public TreeVal getTreeVal(TreeNode node) {
        TreeVal out = new TreeVal();
        
        if (node == null)
            return out;
        TreeVal left = getTreeVal(node.left);
        TreeVal right = getTreeVal(node.right);
        
        int childExport = Math.max(left.export, right.export);
        out.export = node.val + childExport;
        int childSelf = Math.max(left.self, right.self);
        int self2 = 0;
        if (left.export > 0)
        out.self = Math.max(childSelf, left.export + node.val + right.export);
        return out;
    }
    
    public int maxPathSum(TreeNode root) {
        
        if (root == null)
            return 0;
        TreeVal left = getTreeVal(root.left);
        TreeVal right = getTreeVal(root.right);
        
        
             
    }
}
