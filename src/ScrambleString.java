/*
 * Given a string s1, we may represent it as a binary tree by partitioning it 
 * to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces 
a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at",
 it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, 
determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {
    // recursive solution
    public boolean isScramble2(String s1, String s2) {
     
        if (s1 == null || s2 == null)
            return false;
        
        
        if (s1.length() != s2.length())
            return false;
        int length = s1.length();

        if (length == 0)
            return true;
        
        if (s1.equals(s2)) {
           return true;
                       
        }
                
        for (int i = 1; i < length; i++) {

            if (isScramble(s1.substring(0, i), s2.substring(0, i)) 
                && isScramble(s1.substring(i, length), s2.substring(i, length)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(length-i, length)) 
                && isScramble(s1.substring(i, length), s2.substring(0, length-i)))
                return true;
         
        }

        return false;
            
    }
    
    // DP solution
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        
        
        if (s1.length() != s2.length())
            return false;
        int length = s1.length();

        if (length == 0)
            return true;
        boolean[][][] dp = new boolean[length][length][length+1];
        
        for (int i = length-1; i >= 0; i--) {
            for (int j = length-1; j >= 0; j--) {
                int maxLen = length - Math.max(i, j);
                for (int k = 1; k <= maxLen; k++) {
                    if (s1.substring(i, i+k).equals(s2.substring(j, j+k)))
                        dp[i][j][k] = true;
                    else {
                        for (int l = 1; l < k; l++) {
                            if ((dp[i][j][l] && dp[i+l][j+l][k-l])
                                    || dp[i][j+k-l][l] && dp[i+l][j][k-l])
                            {
                                dp[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        
        return dp[0][0][length];
    
    }
    
    public static void main(String[] args) {
        ScrambleString s = new ScrambleString();
        System.out.println("aa, aa " + s.isScramble("aa", "aa"));
        System.out.println("aa, ab " + s.isScramble("aa", "ab"));
        System.out.println("abb, bba " + s.isScramble("abb", "bba"));
        System.out.println("abc, bca " + s.isScramble("abc", "bca"));
    }
}
