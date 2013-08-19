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
        int lastIdx = -1;
        Stack<Integer> stack = new Stack<Integer>();
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    lastIdx = i;
                    continue;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, i - lastIdx);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
                
            }
        }
        

        return max;
    }
    
    public static void main(String[] args)
    {
        LongestValidateParenthese p = new LongestValidateParenthese();
        String t1 = "()()";
        System.out.println(t1+"--"+p.longestValidParentheses(t1));
        t1 = "(()()(())((";
        System.out.println(t1+"--"+p.longestValidParentheses(t1));
        t1 = ")(())))(())())";
        System.out.println(t1+"--"+p.longestValidParentheses(t1));
        t1 = "()((())()";
        System.out.println(t1+"--"+p.longestValidParentheses(t1));
    }
}
