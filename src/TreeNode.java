/*
 * 
 * 
OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, 
where '#' signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 */


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
    
    public void printNode(TreeNode node) {
        if (node == null) {
            System.out.print("# ");
        } else {
            System.out.print(node.val+" ");
            printNode(node.left);
            printNode(node.right);
        }
    }
    
    public void print() {
        printNode(this);
        System.out.println("");
    }
}
    
    