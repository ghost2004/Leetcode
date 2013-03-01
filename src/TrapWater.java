/*
 * LEETCODE Trapping Rain Water
 * Given n non-negative integers representing an elevation map 
 * where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class TrapWater {
    public int trapWater(int[] A) {
        int len = A.length;
        // if less than 3 elements in array
        // return 0
        if (len < 3)
            return 0;
        int i;
        // use a new array to keep the max value on the left
        int[] leftHigh = new int[len];
        leftHigh[0] = A[0];
        int mark = A[0];
        
        // Scan the array from left to right
        // Keep the max value on the left 
        for (i = 1; i < len; i++) {
            if (mark < A[i])
                mark = A[i];
            leftHigh[i] = mark;
        }

        // use the mark as the max value on the right
        // to save the space we don't need a new array here
        mark = A[len-1];
        int trap = 0;
        int minMark;
        
        // Scan from right to left
        for (i = len -2; i >= 0; i--) {
            // get the min value of left high and right high
            if (mark < leftHigh[i])
                minMark = mark;
            else
                minMark = leftHigh[i];
            
            // if the element at this point is less than min(leftHight, RightHigh)
            // then we got the trap value here
            if (A[i] < minMark)
                trap += minMark - A[i];
            
            // refresh the right max value
            if (mark < A[i])
                mark = A[i];
        }

        
        
        return trap;
    }
}
