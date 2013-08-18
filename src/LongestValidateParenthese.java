import java.util.Stack;
/*
 * Given a string containing just the characters '(' and ')',
 *  find the length of the longest valid (well-formed) 
 *  parentheses substring.

For "(()", the longest valid parentheses substring is "()",
 which has length = 2.

Another example is ")()())", where the longest valid
 parentheses substring is "()()", which has length = 4.
 */
public class LongestValidateParenthese {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int length = s.length();
        int max = 0;
        int lastIdx = length;
        int lastLen = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.size() == 0)
                    continue;
                int idx = stack.pop();
                int len = i - idx + 1;
                if (idx < lastIdx) {
                    lastIdx = idx;
                    lastLen = len;
                } else if (lastIdx  == idx -1) {
                    lastLen += len;
                    len = lastLen;
                }
                max = Math.max(max, len);
            }
        }
        

        return max;
    }
    
    public static void main(String[] args)
    {
        LongestValidateParenthese p = new LongestValidateParenthese();
        String t1 = "()()";
        System.out.println(t1+"--"+p.longestValidParentheses(t1));
    }
}
