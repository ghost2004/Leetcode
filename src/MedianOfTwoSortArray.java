/*
 * There are two sorted arrays A and B of size m and n 
 * respectively. Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortArray {
    
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null && B == null)
            return 0;
        int m = A.length;
        int n = B.length;
        
        if (m == 0 && n == 0)
            return 0;
        
        if (m == 0)
            return B[n/2];
        else if (n == 0)
            return A[m/2];
        
        int med = (m+n+1)/2;
        
        
        
        
    }

}
