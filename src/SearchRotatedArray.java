/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, 

otherwise return -1.

You may assume no duplicate exists in the array.
 * 
 */
  
public class SearchRotatedArray {
    public int search(int[] A, int target) {
        
        int leftIndex = 0;
        int rightIndex = A.length - 1;
        
        int middle;
        
        while (leftIndex <= rightIndex) {
            middle = leftIndex + (rightIndex - leftIndex)/2;
            if (A[middle] == target)
                return middle;

            // the left part of array are sorted
            if (A[leftIndex] < A[middle]) {
                if (target >= A[leftIndex] && target < A[middle]) {
                    // the target failed into left side
                    rightIndex = middle - 1;
                } else {
                    
                    leftIndex = middle + 1;
                }
            }
            // the right part of array are sorted
            else {
                if (target > A [middle] && target <= A[rightIndex]) {
                    leftIndex = middle + 1;
                } else {
                    rightIndex = middle - 1;
                }
            }
            
        }
        
        return -1;
    }

}
