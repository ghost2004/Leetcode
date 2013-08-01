
/*
 * Given a binary tree and a sum, find all root-to-leaf paths where 
 * each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
 */
import java.util.ArrayList;
public class PathSumII {

    public void hasPathSum(TreeNode node, int sum, 
            ArrayList<Integer> list, ArrayList<ArrayList<Integer>> output)
    {
        if (node == null)
            return;

        list.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                
                ArrayList<Integer> curList = new ArrayList<Integer>(list);
                output.add(curList);
                
            }
        } else {
            if (node.left != null) {
                hasPathSum(node.left, sum - node.val, list, output);
            }
            if (node.right != null) {
                hasPathSum(node.right, sum - node.val, list, output);
            }
            
        }
        
       
        list.remove(list.size()-1);
        
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function

        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        if (root == null)
            return out;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        hasPathSum(root, sum, list, out);
        return out;
        
    }
    
}
