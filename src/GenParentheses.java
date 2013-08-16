import java.util.ArrayList;
/*
 * Given n pairs of parentheses, write a function to generate
 *  all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenParentheses {
    
    public void genPth(int left, int right,
            String in, ArrayList<String> out) 
    {

        if (left == 0) {
            String next = new String(in);
            for (int i = 0; i < right; i++)
                next += ")";
            if (next.length() != 0) 
                out.add(next);
            return;
        }

        genPth(left-1, right, in+"(", out);
        if (right > left) {
            genPth(left, right-1, in+")", out);
        }
    }

    
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> out = new ArrayList<String>();
        genPth(n, n, "", out);
        return out;
        
    }
    
    public static void printArray(ArrayList<String> in) 
    {
        for (String s:in) {
            System.out.print(s+",");
        }
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        GenParentheses gen = new GenParentheses();
        printArray(gen.generateParenthesis(1));
        printArray(gen.generateParenthesis(2));
        printArray(gen.generateParenthesis(3));
        printArray(gen.generateParenthesis(4));
        printArray(gen.generateParenthesis(0));
        
    }

}
