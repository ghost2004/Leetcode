/*
 * Given s1, s2, s3, find whether s3 is 
 * formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */
public class InterleavingString {
    public String out;
    public String in1;
    public String in2;
    
    public boolean checkInterleave(int idx1, int idx2, int idx3)
    {
        if (idx1 == -1 && idx2 == -1 && idx3 == -1)
            return true;
        
        if (idx1 >= 0 && in1.charAt(idx1) == out.charAt(idx3)
                && checkInterleave(idx1-1, idx2, idx3-1))
            return true;
        if (idx2 >= 0 && in2.charAt(idx2) == out.charAt(idx3)
                && checkInterleave(idx1, idx2-1, idx3-1))
            return true;       
        
        return false;
        
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        out = s3;
        in1 = s1;
        in2 = s2;
        if (s1.length() + s2.length() != s3.length())
            return false;
               

        return checkInterleave(s1.length()-1, s2.length()-1, s3.length()-1);
    }
    
    public boolean isInterLeave2(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        
        if (len1 + len2 != len3)
            return false;
        
        boolean[] flags = new boolean[len2+1];
        flags[len2] = true;
        // set up the flag array
        // flag is set to true if it is s2 the substring of s3 at tail
        int i, j;
        for (i = len2-1; i >= 0; i--) {
            if (s3.charAt(len1+i) == s2.charAt(i) && flags[i+1])
                flags[i] = true;
            else
                flags[i] = false;
        }
        // scan s1 from end to beginning 
        for (i = len1-1; i >= 0; i--) {
            // scan s2 from end to beginning
            for (j = len2-1; j >= 0; j--) {
                if (s3.charAt(i+j) == s1.charAt(i) && flags[j])
                    flags[j] =  true;
                else if (s3.charAt(i+j) == s2.charAt(j) && flags[j+1])
                    flags[j] = true;
                else
                    flags[j] = false;
            }
            
            if (flags[len2] && s3.charAt(i+len2) == s1.charAt(i))
                flags[len2] = true;
            else
                flags[len2] = false;
            
        }
        
        return flags[0];
        
    }
    
    public static void main(String[] args)
    {
        InterleavingString t = new InterleavingString();
        
        System.out.println(t.isInterleave("", "b", "b"));
    }
}
