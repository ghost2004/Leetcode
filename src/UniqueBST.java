/*
 * Given n, how many structurally unique BST's
 *  (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class UniqueBST {
    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;
        int total = 0;
        
        for (int i = 1; i <= n; i++)
        {
            int left = i - 1;
            int right = n - i;
            total += numTrees(left)*numTrees(right);
        }

        return total;
        
    }
    
    public static void main(String[] args)
    {
        UniqueBST u = new UniqueBST();
        
        int[] a = {0, 1, 2, 3, 4, 5};
        for (int i:a)
            System.out.println(i+"--"+u.numTrees(i));
    }
}
