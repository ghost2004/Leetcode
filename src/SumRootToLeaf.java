
/*
 * Given a binary tree containing digits from 0-9 only, 
 * each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */

public class SumRootToLeaf {
    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int x) { val = x; }
    }    
    
    public int getSum(TreeNode node, int val)
    {
        int sum = 0;
        if (node == null)
            return val;
        if (node.left == null && node.right == null) {
            return (val*10+node.val);
        } else {
            if (node.left != null)
                sum += getSum(node.left, val*10+node.val);
            if (node.right != null)
                sum += getSum(node.right, val*10+node.val);
            
        }
        return sum;
        
        

    }
    
    public int sumNumbers(TreeNode root) {
        return getSum(root, 0);
        
       

        
    }

}
