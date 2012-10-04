import java.util.Arrays;


public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        
        
        Arrays.sort(num);
        int length = num.length;
        int diff = target - num[0] - num[1] - num[2];
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
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
                if (Math.abs(rest - num[lo]) > Math.abs(rest -num[lo-1]))
                    next = num[lo-1] + num[i]+ num[j];
                else
                    next = num[lo] + num[i]+ num[j];
                
                if (Math.abs(target - next) < Math.abs(diff))
                    diff = target - next;
                
            }
        }
        return target - diff;

        
    }
}
