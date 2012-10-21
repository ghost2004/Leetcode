import java.util.ArrayList;


public class InOrderTr {
    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
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
        inorder(root, out);
        
        return out;
    }

}
