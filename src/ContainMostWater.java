/*
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints
 *  of line i is at (i, ai) and (i, 0). Find two lines, 
 *  which together with x-axis forms a container, 
 *  such that the container contains the most water.

Note: You may not slant the container.
 */
public class ContainMostWater {
    // Brute-force solution, time complex O(n^2)
    public int maxAreaVer1(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int max = 0;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i+1; j < length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                max = Math.max(max, area);
            }
        }

        return max;
    }
    // Greedy solution, time complex O(n)
    public int maxAreaVer2(int[] height) {
        if (height == null || height.length == 0)
            return 0;
                
        int leftIdx = 0;
        int rightIdx = height.length - 1;
        int max = 0;
        while (leftIdx < rightIdx) {
            int area = Math.min(height[leftIdx], height[rightIdx]) 
                    * (rightIdx - leftIdx);
            max = Math.max(max, area);
            int leftValue = height[leftIdx];
            int rightValue = height[rightIdx];
            if (leftValue < rightValue) {
                leftIdx++;
            } else {
                rightIdx--;
            }
             
        }
        return max;
    }
    
}
