/*
 * Given a sorted array of integers, find the starting 
 * 
 * and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */
public class SearchForRange {
    public int[] searchRange(int[] A, int target) {


        int[] out = {-1, -1};
        if (A == null || A.length == 0)
            return out;
        int start = 0;
        int end = A.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (A[mid] < target)
                start = mid + 1;
            else if (A[mid] > target)
                end = mid - 1;
            else {
                int idx = mid;
                while (idx > 0 && A[idx-1] == target)
                    idx--;
                out[0] = idx;
                idx = mid;
                while (idx < A.length-1 && A[idx+1] == target)
                    idx++;
                out[1] = idx;
                    
                
                break;
            }
                
        }
        
        return out;
    }
    
    public static void main(String[] args) {
        int[] t1 = {5,7,7,8,8,10};
        SearchForRange s = new SearchForRange();
        int[] res = s.searchRange(t1, 8);
        System.out.println(res[0]+"  "+res[1]);
        int[] t2 = {1};
        res = s.searchRange(t2, 1);
        System.out.println(res[0]+"  "+res[1]);
        
    }

}
