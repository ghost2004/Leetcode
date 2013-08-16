import java.util.Stack;
/*
 * Given a string containing just the characters 
 * '(', ')', '{', '}', '[' and ']', determine if 
 * the input string is valid.

The brackets must close in the correct order, "()" 
and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    final short left1 = 1;
    final short left2 = 2;
    final short left3 = 3;
    public boolean isValid(String s) {
        if (s == null || s.equals(""))
            return true;
        int length = s.length();
        
        Stack<Short> stack = new Stack<Short>();
        
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(left1);
            } else if (c == '[') {
                stack.push(left2);
            } else if (c == '{') {
                stack.push(left3);
            } else if (c == ')') {
                if (stack.size() == 0 || stack.pop() != left1)
                    return false;
            } else if (c == ']') {
                if (stack.size() == 0 || stack.pop() != left2)
                    return false;
            } else if (c == '}') {
                if (stack.size() == 0 || stack.pop() != left3)
                    return false;
            }
                
            
        }
        
        if (stack.size() > 0)
            return false;
        
        return true;

        
    }
}
