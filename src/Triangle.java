import java.util.ArrayList;
/*
 * Given a triangle, find the minimum path sum from top to bottom. Each 
 * step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
 Bonus point if you are able to do this using only O(n) extra space, where n
 is the total number of rows in the triangle.
 */
public class Triangle {

    // Down to up solution
    public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        int out = 0;

        if (triangle == null || triangle.size() == 0)
            return out;
        int tLevel = triangle.size();

        int[] candidate = new int[tLevel];
        
        for (int i = 0; i < tLevel; i++)
            candidate[i] = triangle.get(tLevel-1).get(i);
        
        for (int level = tLevel - 2; level >= 0; level--) {
            for (int idx = 0; idx <= level; idx++) {
                int min = Math.min(candidate[idx], candidate[idx+1]);
                candidate[idx] = triangle.get(level).get(idx) + min;
            }
            
        }
        
        out =  candidate[0];
        
        return out;
    }
    
    // Up to down solution
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int out = 0;
        int min;
        if (triangle == null || triangle.size() == 0)
            return out;
        
        int tLevel = triangle.size();
        
        out = triangle.get(0).get(0);
        ArrayList<Integer> candidate = new ArrayList<Integer>();
        candidate.add(out);
        ArrayList<Integer> next;
        for (int level = 1; level < tLevel; level++) {
            next = new ArrayList<Integer>();
            int k;
            for (int i = 0; i <= level; i++) {
                if (i == 0)
                    k = triangle.get(level).get(0) + candidate.get(0);
                else if (i == level)
                    k = triangle.get(level).get(i) + candidate.get(i-1);
                else {
                    k = triangle.get(level).get(i);
                    k += Math.min(candidate.get(i-1), candidate.get(i));
                }
                next.add(k);
            }

            candidate.clear();
            candidate = next;
        }
        
        if (candidate.size() != 0) {
            min = candidate.get(0);
            for (int c:candidate) {
                min = Math.min(min, c);
            }
            out = min;
        }

        return out;
    }
    
    public static void main(String[] args) {
        Triangle t = new Triangle();
        ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(-1);
        tri.add(row);
        //System.out.println("L0:"+t.minimumTotal(tri));
        row = new ArrayList<Integer>();
        row.add(-2);
        row.add(-3);
        tri.add(row);
        System.out.println("L1:"+t.minimumTotal(tri));
        row = new ArrayList<Integer>();
        row.add(2);
        row.add(3);
        row.add(4);
        tri.add(row);
        //System.out.println("L2:"+t.minimumTotal(tri));
        row = new ArrayList<Integer>();
        row.add(12);
        row.add(1);
        row.add(4);
        row.add(5);
        tri.add(row);
        //System.out.println("L3:"+t.minimumTotal(tri));
        row = new ArrayList<Integer>();
        row.add(12);
        row.add(1);
        row.add(4);
        row.add(5);
        row.add(11);
        tri.add(row);
        System.out.println("L4:"+t.minimumTotal(tri));
        row = new ArrayList<Integer>();
        row.add(12);
        row.add(1);
        row.add(4);
        row.add(5);
        row.add(11);
        row.add(-1);
        tri.add(row);
        System.out.println("L5:"+t.minimumTotal(tri));
        row = new ArrayList<Integer>();
        row.add(12);
        row.add(1);
        row.add(4);
        row.add(5);
        row.add(11);
        row.add(-1);
        row.add(-1);
        tri.add(row);
        System.out.println("L6:"+t.minimumTotal(tri));
        
        
        
    }

}
