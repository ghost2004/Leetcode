/*
 * Given an array S of n integers, find three integers in S
 * such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that
 *  each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
import java.util.Arrays;


public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        
        int length = num.length;
        
        if (length == 3)
            return num[0] + num[1] + num[2];

        Arrays.sort(num);
        int best = num[0] + num[1] + num[2];
        
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length - 1; j++) {
                int rest = target - num[i] - num[j];
                
                // Binary search 

                int lo = j + 1;
                
                int high = length -1;
                while (lo <= high) {
                    int mid = lo + (high-lo)/2;
                    if (num[mid] > rest)
                        high = mid - 1;
                    else if (num[mid] < rest)
                        lo = mid + 1;
                    else 
                        return target;
                        
                }

                int next;
                
                if (high < j + 1)
                    next = num[high+1] + num[i]+ num[j];
                else if (high < length - 1 
                        && Math.abs(rest -num[high+1]) < Math.abs(rest -num[high]))
                    next = num[high+1] + num[i]+ num[j];
                else
                    next = num[high] + num[i]+ num[j];
                
                if (Math.abs(target - next) < Math.abs(target - best))
                    best = next;
                
            }
        }
        return best;

        
    }
    
    public static void main(String[] args) {
        int[] a1 = {0, 0, 0};
        int[] a2 = {0, 1, 2};
        int[] a3 = {-1, 2, 1, -4};
        int[] a4 = {0, 2, 1, -3};
        ThreeSumClosest c = new ThreeSumClosest(); 
        System.out.println(c.threeSumClosest(a1, 1));   //expect 0
        System.out.println(c.threeSumClosest(a2, 0));   //expect 3
        System.out.println(c.threeSumClosest(a3, 1));   //expect 2
        System.out.println(c.threeSumClosest(a4, 1));   //expect 0
        
    }
}
