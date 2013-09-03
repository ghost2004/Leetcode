/*
 * Given a set of distinct integers, S,
 *  return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
import java.util.ArrayList;
import java.util.Arrays;
public class Subset {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {

        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        out.add(new ArrayList<Integer>());
        for (int i = 0; i < S.length; i++) {
            int j = out.size();
            while (j-- > 0) {
                ArrayList<Integer> n = new ArrayList<Integer>(out.get(j));
                out.add(n);
                out.get(out.size()-1).add(S[i]);
            }
            
        }
        return out;
    }
    
    public static void prtArrList(ArrayList<ArrayList<Integer>>  in) {
        for (int i = 0; i < in.size(); i++) {
            int s = in.get(i).size();
            for (int j = 0; j < s; j++)
                System.out.print(in.get(i).get(j)+ " ");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Subset s = new Subset();
        int[] t1 = {0};
        prtArrList(s.subsets(t1));
    }
}
