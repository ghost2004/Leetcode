import java.util.ArrayList;
import java.util.Arrays;
public class ThreeSum {
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {

        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(num);
        int length = num.length;
        
        int[] a = null;
        
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
                    boolean flag = false;
                    if (a != null) {
                        if (a[0] != num[i] && a[1] != num[j])
                            flag = true;
                    }
                    else {
                        flag = true;

                    }
                        
                    if (flag) {
                        ArrayList<Integer> item = new ArrayList<Integer>();
                        item.add(num[i]);
                        item.add(num[j]);
                        item.add(num[k]);
                        out.add(item);
                        
                        a = new int[3];
                        a[0] = num[i];
                        a[1] = num[j];
                        a[2] = num[k];
                        
                    }
                    
                    
                }
                
            }
            
            
        }
        
        return out;
    }

}
