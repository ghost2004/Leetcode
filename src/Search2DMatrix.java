/*
 * 
 * Search  2D Matrix problem in LEETCODE
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

 */
public class Search2DMatrix {
    
 
    // 2 binary search implement
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean out = false;
        
        if (matrix == null || matrix.length == 0 ||
                matrix[0].length ==0)
            return false;
            
        int row = matrix.length;
        int col = matrix[0].length;
        
        int start = 0;
        int end = row - 1;
        int mid;
        
        while (start <= end) {
            mid = (start + end)/2;
            if (matrix[mid][0] == target){
               return true;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
                
            } else {
                start = mid + 1;
            }           
            
        }
        
        int range = start;
        
        if (matrix[range][0] > target || range >= row)
            range --;
        
        int i;
        
        for (i = 0; i <= range; i++){
            
            if (matrix[i][col -1] < target)
                continue;
            start = 0;
            end = col - 1;
            
            while (start <= end) {
                mid = (start + end)/2;
                if (matrix[i][mid] == target){
                   return true;
                } else if (matrix[i][mid] > target) {
                    end = mid - 1;
                    
                } else {
                    start = mid + 1;
                }       
            }
            
        }
       
        
        
        return out;
        

        
    }    


}
