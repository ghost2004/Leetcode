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
    public boolean isScramble(String s1, String s2) {
     
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
    
    public static void main(String[] args) {
        ScrambleString s = new ScrambleString();
        System.out.println("aa, aa " + s.isScramble("aa", "aa"));
        System.out.println("aa, ab " + s.isScramble("aa", "ab"));
        System.out.println("abb, bba " + s.isScramble("abb", "bba"));
        System.out.println("abc, bca " + s.isScramble("abc", "bca"));
    }
}
