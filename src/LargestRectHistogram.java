/*
 * Given n non-negative integers representing the histogram's
 *  bar height where the width of each bar is 1, find the area
 *   of largest rectangle in the histogram.



Above is a histogram where width of 
each bar is 1, given height = [2,1,5,6,2,3].



The largest rectangle is shown in the shaded
 area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.


 */
public class LargestRectHistogram {
    
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        
        int max = 0;
        
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            int min = height[i];
            for (int j = i+1; j < height.length; j++)
            {
                min =  Math.min(min, height[j]);
                int val = (j-i+1)*min;
                max = Math.max(max, val);
                    
            }
        }

        return max;
    }

}
