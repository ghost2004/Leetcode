/*
 * Given preorder and inorder traversal of a tree, 
 * construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */

public class BuildTreeInorderPreorder {
    
    public int findIdx(int[] array, int key, int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (array[i] == key)
                return i;
        }
        return -1;
    }
    /*
     * 1. The first node is preorder is the root
     * 2. The left side of root in inorder is left sub tree
     * 3. Get the number of nodes in left sub tree, then split array
     */
    public TreeNode bldTree(int[] preorder, int pb, int pe, 
            int[] inorder, int ib, int ie) {
        if (pb == pe)
            return new TreeNode(preorder[pb]);
        else if (pb > pe)
            return null;
        
        TreeNode root = new TreeNode(preorder[pb]);
        int rootIdx = findIdx(inorder, preorder[pb], ib, ie);
        if (rootIdx == -1)
            return null;
        int leftIdx = rootIdx - ib + pb;
        if (leftIdx < 0)
            return null;
        root.left = bldTree(preorder, pb+1, leftIdx, 
                inorder, ib, rootIdx-1);
        root.right = bldTree(preorder, leftIdx+1, pe,
                inorder, rootIdx+1, ie);

        return root;
        
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder == null || inorder == null
            || preorder.length == 0
            || inorder.length == 0
            || preorder.length != inorder.length)
            return null;
        
        return bldTree(preorder, 0, preorder.length-1, 
                inorder, 0, inorder.length-1);
        
        
    }
    
    public static void main(String[] args) {
        int[] preorder = {3, 2, 4, 1};
        int[] inorder = {1, 2, 3, 4};
        BuildTreeInorderPreorder bld = new  BuildTreeInorderPreorder();
        TreeNode root = bld.buildTree(preorder, inorder);
        root.print();
    }

}
