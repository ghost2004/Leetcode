
/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */
import java.util.ArrayList;
import java.util.Stack;

public class InOrderTr {
    
    public void inorder(TreeNode node, ArrayList<Integer> list) {
        if (node == null)
            return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        
        if (root == null)
            return out;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pt = root;
        while (pt != null) {
            stack.push(pt);
            pt = pt.left;
        }
        
        while (!stack.empty()) {
            pt = stack.pop();
            out.add(pt.val);
            pt = pt.right;
            while (pt != null) {
                stack.push(pt);
                pt = pt.left;
            }
          
        }
        
        return out;
    }

}
