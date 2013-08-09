/*
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
 */
public class MergeSortedArray {
    
    public void merge(int[] A, int m, int[] B, int n) {
        int index = m + n - 1;
        int aIdx = m - 1;
        int bIdx = n - 1;
        
        while (aIdx >= 0 && bIdx >= 0) {
            if (A[aIdx] >= B[bIdx]) {
                A[index] = A[aIdx--];
            } else {
                A[index] = B[bIdx--];
            }
            index--;
        }
        
        int idx;
        boolean flag;
        
        if (aIdx > 0) {
            idx = aIdx;
            flag = true;
        } else {
            idx = bIdx;
            flag = false;
        }
        
        while (idx >= 0) {
            if (flag)
                A[index--] = A[idx--];
            else
                A[index--] = B[idx--];

        }
          
        

        
    }

}
