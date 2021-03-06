/*
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
public class SortArrayToBST {
    // first solution
    public TreeNode formBST(int[] num, int begin, int end) {
        int middle = (begin + end)/2;
        TreeNode node = new TreeNode(num[middle]);
        if (middle > begin)
            node.left = formBST(num, begin, middle-1);
        else
            node.left = null;
        if (middle < end)
            node.right = formBST(num, middle+1, end);
        else
            node.right = null;
        
        return node;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0)
            return null;
        
        int length = num.length;
        
        return formBST(num, 0, length-1);

        
    }
    
    // second solution
    public TreeNode formBST2(int[] num, int begin, int end) {
        if (begin > end)
            return null;
        int middle = (begin + end)/2;
        TreeNode node = new TreeNode(num[middle]);
        node.left = formBST2(num, begin, middle-1);
        node.right = formBST2(num, middle+1, end);
        return node;
    }

}
