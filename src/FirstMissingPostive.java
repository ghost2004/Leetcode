/*
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPostive {
    // the solution with bitmap, faild in large cases
    public int firstMissingPositiveV1(int[] A) {
        long bitmap = 0;
        int length = A.length;
        int i;
        for (i = 0; i < length; i++) {
            if (A[i] > 0) {
                bitmap |= (long) 1 << (A[i] - 1);
            }
        }
        
            
        i = 0;
        while (bitmap % 2 != 0) {
            bitmap /= 2;
            i++;
        }
        
        return i+1;
        
    }
    
    public int firstMissingPositive(int[] A) {
        int length = A.length;
        
        int i;

        
        for (i = 0; i < length; i++) {
            if (A[i] != i+1)
                return i;
        }
        
        return length+1;
    }

    public static void main(String[] args) {
        FirstMissingPostive f = new FirstMissingPostive();
        int[] t1 = {2, 1};
        //System.out.println(f.firstMissingPositive(t1));
        int[] t2 = {10,4,16,54,17,-7,21,15,25,31,61,1,6,
                12,21,46,16,56,54,12,23,20,38,63,2,27,35,
                11,13,47,13,11,61,39,0,14,42,8,16,54,50,
                12,-10,43,11,-1,24,38,-10,13,60,0,44,11,
                50,33,48,20,31,-4,2,54,-6,51,6};
        System.out.println(f.firstMissingPositive(t2));
        int[] t3 = {4,27,-9,35,24,11,25,8,-9,16,65,60,10,
                13,24,-2,-9,-10,25,9,36,29,50,46,48,35,67,
                -8,22,66,-7,36,0,-6,56,9,-10,12,2,-8,38,-2,
                37,34,21,-7,17,-2,-7,53,17,15,67,52,-8,47,
                18,-9,24,50,42,27,-8,27,31,58,21,7,2};
        System.out.println(f.firstMissingPositive(t3));
    }
}
