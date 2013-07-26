/*
 * Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
 */

public class SearchRotatedArrayII {
    
    public boolean search(int[] A, int target) {

        if (A == null || A.length == 0)
            return false;
        int left = 0;
        int right = A.length - 1;
        int middle;
        
        while (left <= right) {
            middle = (left + right) / 2;
            if (A[middle] == target)
                return true;
            if (A[left] < A[middle]) {
                // left part are sorted
                if (A[left] <= target && target < A[middle])
                    right = middle -1;
                else
                    left = middle + 1;
            }
            else if (A[left] > A [middle]) {
                // right part are sorted
                if (A[middle] < target && target <= A[right])
                    left = middle + 1;
                else
                    right = middle -1;
            }
            else {
                left++;
            }
        }
        
        return false;
    }

}
