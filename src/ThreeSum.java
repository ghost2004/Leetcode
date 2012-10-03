import java.util.ArrayList;
import java.util.Arrays;
public class ThreeSum {
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(num);
        int length = num.length;
        
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                int rest = 0 - num[i] - num[j];
                int k = -1;
                int lo = j + 1; 
                int high = length -1;
                while (lo <= high) {
                    int mid = lo + (high - lo)/2;
                    if (num[mid] < rest)
                        lo = mid + 1;
                    else if (num[mid] > rest)
                        high = mid -1;
                    else {
                        k = mid;
                        break;
                    }
                        
                }
                
                if (k != -1) {
                    ArrayList<Integer> item = new ArrayList<Integer>();
                    item.add(num[i]);
                    item.add(num[j]);
                    item.add(num[k]);
                    out.add(item);
                }
                
            }
            
            
        }
        
        return out;
    }

}
