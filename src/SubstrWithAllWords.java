/*
 * You are given a string, S, and a list of words, L,
 *  that are all of the same length. Find all starting
   indices of substring(s) in S that is a concatenation 
   of each word in L exactly once and without any 
   intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */
import java.util.ArrayList;
public class SubstrWithAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        
        if (S == null || S.length() == 0)
            return out;
        if (L == null || L.length == 0 || L[0].length() == 0)
            return out;

        int subLen = L[0].length();
        int scanLen = S.length() - L.length*subLen;
        
        for (int i = 0; i < scanLen; i++) {
            
        }
        
        return out;
    
        
    }
}
