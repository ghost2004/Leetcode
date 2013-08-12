/*
 * Given inorder and postorder traversal of a tree, 
 * construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
 */
public class BuildTreeInorderPostorder {
    
    public TreeNode bldTree(int[] inorder, int ib, int ie,
            int[] postorder, int pb, int pe) 
    {
        if (pb > pe)
            return null;
        else if (pb == pe)
            return new TreeNode(postorder[pe]);
        
        TreeNode root = new TreeNode(postorder[pe]);
        int rootIdx = -1;
        for (int i = ib; i <= ie; i++) {
            if (inorder[i] == postorder[pe]) {
                rootIdx = i;
                break;
            }
        }
        if (rootIdx == -1)
            return null;
        int rightIdx = pe - (ie - rootIdx); 
        root.left = bldTree(inorder,ib, rootIdx -1,
                postorder, pb, rightIdx-1);
        root.right = bldTree(inorder, rootIdx+1, ie,
                postorder, rightIdx, pe-1);
        
        return root;
        
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (postorder == null || inorder == null
            || postorder.length == 0
            || inorder.length == 0
            || postorder.length != inorder.length)
            return null;
        
        return bldTree( inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1);        

        
    }
    public static void main(String[] args) {
        
        int[] inorder = {2, 1, 3};
        int[] postorder = {2, 3, 1};
        BuildTreeInorderPostorder bld = new  BuildTreeInorderPostorder();
        TreeNode root = bld.buildTree(inorder, postorder);
        root.print();
    }
}
