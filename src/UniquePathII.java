/*
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. 
How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0
                || obstacleGrid[0].length == 0)
            return 0;
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[] path = new int[col];
        
        if (obstacleGrid[row-1][col-1] == 1)
            return 0;
        
        path[col-1] = 1;

        for (int i = row-1; i >= 0; i--) {
            if (obstacleGrid[i][col-1] == 0 && path[col-1] == 1)
                path[col-1] = 1;
            else 
                path[col-1] = 0;
            for (int j = col-2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1)
                    path[j] = 0;
                else
                    path[j] += path[j+1];
            }
        }
        return path[0];
    }
    
    public static void main(String[] args) {
        UniquePathII u = new UniquePathII();
        int[][] t1 = { {0}, {1} };
        int[][] t2 = {{0,0,0,0,0},{0,0,0,0,1},{0,0,0,1,0},{0,0,1,0,0}};
        System.out.println(u.uniquePathsWithObstacles(t1));
        System.out.println(u.uniquePathsWithObstacles(t2));
    }
}
