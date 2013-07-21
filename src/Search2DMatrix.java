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
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean out = false;
        
        int x = matrix.length;
        int y = matrix[0].length;
        
        int start = 0;
        int end = x - 1;
        int index;
        
        while (start < end) {
            index = (start + end)/2;
            if (matrix[index][0] == target){
               return true;
            } else if (matrix[index][0] < target) {
                start = index;
                
            } else {
                end = index;
            }           
            
        }
        
        
        return out;
        

        
    }    


}
