import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        HashSet<String> filter = new HashSet<String>();
        ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
        int length = num.length;
        if (length < 4)
            return out;
        
        Arrays.sort(num);
        
        for (int i = 0; i < length - 3; i++) {
            for (int j = i + 1; j < length - 2; j++) {
                for (int k = j + 1; k < length - 1; k++) {
                    int key = target - num[i] - num[j] - num[k];
                    int lo = k+1;
                    int hi = length -1;
                    int idx = -1;
                    while (lo <= hi) {
                        int mid = lo + (hi - lo)/2;
                        if (num[mid] == key) {
                            idx = mid;
                            break;
                        }
                        else if (num[mid] < key)
                            lo = mid +1;
                        else
                            hi = mid -1;
                            
                    }
                    
                    if (idx != -1) {
                        String hashString = new String(num[i]+","+num[j]
                                + ","+num[k]+","+num[idx]);
                        if (filter.contains(hashString))
                            continue;
                        ArrayList<Integer> item = new  ArrayList<Integer>();
                        item.add(num[i]);
                        item.add(num[j]);
                        item.add(num[k]);
                        item.add(num[idx]);
                        out.add(item);
                        filter.add(hashString);
                    }
                }
            }
        }
        return out;
        
    }
}


