/*
 * A robot is located at the top-left corner of a m x n grid
(marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid
 
  (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100
 */
public class UniquePath {
    // recursive solution
    public int getPaths(int x, int y, int m, int n) {
        if (x == m || y == n)
            return 1;
        return getPaths(x+1, y, m, n)+ getPaths(x, y+1, m, n);
        
    }
    public int uniquePathsV1(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        return  getPaths(1, 1, m, n);
    }
    
    // Dynamic programming solution
    public int uniquePathV2(int m, int n) {
        int[][] path = new int[m][n];
        int i, j;
        
        for (i = 0; i < n; i++)
            path[m-1][i] = 1;
        for (i = 0; i < m-1; i++)
            path[i][n-1] = 1;
        for (i = m-2; i >= 0; i--) {
            for (j = n-2; j >= 0; j--) {
                path[i][j] = path[i][j+1] + path[i+1][j];
            }
        }
        
        return path[0][0];
            
    }
    
    // optimized in space 
    public int uniquePath(int m, int n) {
        int[] path = new int[n];
        int i, j;
        
        for (i = 0; i < n; i++)
            path[i] = 1;
        
        for (i = m-2; i >= 0; i--) {
            for (j = n-2; j >= 0; j--)
                path[j] += path[j+1];
        }
        
        return path[0];
    }
    
    
}
