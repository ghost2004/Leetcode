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
    
    public static void main(String[] args)
    {
        InterleavingString t = new InterleavingString();
        
        System.out.println(t.isInterleave("", "b", "b"));
    }
}
