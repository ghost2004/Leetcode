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

import java.util.Arrays;
import java.util.Stack;
public class LargestRectHistogram {

    
    // Solution with brute force, O(n^2)
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
    
    // Solution with Pruning
    public int largestRectangleArea2(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        
        int max = 0;
        int i = 0;
        
        while (i < height.length) {
            int k = i;
            while (k < height.length-1) {
                if (height[k] > height[k+1]) {
                    break;
                }
                k++;
            }
            
            i = k;
            int lowest = height[i];
            for (int j = i; j >= 0; j--) {
                lowest = Math.min(lowest, height[j]);
                int val = (i-j+1)*lowest;
                max = Math.max(max, val);
                
            }
            i++;
                
        }
        return max;
    
    }
    
    // Dynamic programming solution with O(n) complex
    public int largestRectangleArea3(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        // create a new array end with 0
        int[] h = new int[height.length+1];
        h = Arrays.copyOf(height, height.length + 1);
        h[height.length] = 0;
        int index = 0;
        while (index < h.length) {
            if (stack.isEmpty() || h[index]  >= h[stack.peek()]) {
                // keep the consecutive increase sequence in stack 
                stack.push(index);
                index++;
            } else {
                int lastIndex = stack.pop();
                int area;
                if (stack.isEmpty())
                    area = h[lastIndex] * index;
                else
                    area = h[lastIndex]  * (index - stack.peek() - 1);
                max = Math.max(max, area);
            }
            
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        
        LargestRectHistogram  l = new LargestRectHistogram();
        
        int[] a0 = {0};
        int[] a1 = {1, 1};
        int[] a3 = {2, 1, 5, 6, 2, 3};
        int[] a4 = {4, 2, 0, 3, 2, 5};
        System.out.println(l.largestRectangleArea3(a0));
        System.out.println(l.largestRectangleArea3(a1));
        System.out.println(l.largestRectangleArea3(a3));
        System.out.println(l.largestRectangleArea3(a4));
    }
    
}
