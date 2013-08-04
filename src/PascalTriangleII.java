import java.util.ArrayList;
/*
 * Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new  ArrayList<Integer>();
        
        row.add(1);
        
        if (rowIndex == 0)
            return row;
        
        row.add(1);
        if (rowIndex == 1)
            return row;
        
        for (int level = 2; level <= rowIndex; level++) {
            // set the 2nd element in the row
            int last = row.get(1);
            row.set(1, 1 + last);
            for (int i = 2; i < level; i++) {
                int pre = row.get(i);
                row.set(i, last + row.get(i));
                last = pre;
            }
            // add 1 at the end of row
            row.add(1);
        }

        return row;
    }

}
