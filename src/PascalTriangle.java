import java.util.ArrayList;
/*
 * Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        
        ArrayList<ArrayList<Integer>> tri = new  ArrayList<ArrayList<Integer>>();
        
        if (numRows == 0)
            return tri;
        // Add the first row
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        tri.add(row);
        
        for (int level = 1; level < numRows; level++) {
            row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 1; i <= level; i++) {
                if (i == level)
                    row.add(1);
                else {
                    int k = tri.get(level-1).get(i-1) + tri.get(level-1).get(i);
                    row.add(k);
                }
                    
            }
            tri.add(row);
        }
        
        return tri;
        
    }

}
