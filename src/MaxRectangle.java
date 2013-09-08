/*
 * Given a 2D binary matrix filled with 0's and 1's, find the
 *  largest rectangle containing all ones and return its area.
 */
public class MaxRectangle {
    public int maxRectArea(char[][] matrix, int row, int col) {
        int area = 1;
        int minWidth = Integer.MAX_VALUE;
        for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++) {
            int width = 1;
            while (width < minWidth && width+col < matrix[i].length
                    &&  matrix[i][col+width] == '1')
                width++;
            
            minWidth = Math.min(minWidth, width);
            area = Math.max(area, (i-row+1)*minWidth);
        }

        return area;
    }
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int max = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, maxRectArea(matrix, i, j));
                }
            }
        }
        
        return max;
        
    }
}
