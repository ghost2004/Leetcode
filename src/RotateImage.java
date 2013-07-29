/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

 */
public class RotateImage {
    
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        
        int n = matrix.length;
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            
            for (int i = first; i < last; i++) {
                int topLeft = matrix[first][i];
                int offset = i - first;
                // move bottom left to top left
                matrix[first][i] = matrix[last-offset][first];
                // move bottom right to bottom left
                matrix[last-offset][first] = matrix[last][last-offset];
                // move top right to bottom right
                matrix[last][last-offset] = matrix[i][last];
                // move top left to top right
                matrix[i][last] = topLeft;
            }
            
        }
        

        
    }

}
