/*
 * Given an array S of n integers, are there elements a, b, c, and d 
 * in S such that a + b + c + d = target? Find all unique quadruplets 
 * in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order.
 (ie, a ¡Ü b ¡Ü c ¡Ü d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */
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


