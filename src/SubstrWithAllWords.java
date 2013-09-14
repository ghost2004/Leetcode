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
import java.util.HashMap;
public class SubstrWithAllWords {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> out = new ArrayList<Integer>();
        
        if (S == null || S.length() == 0)
            return out;
        if (L == null || L.length == 0 || L[0].length() == 0)
            return out;

        int subLen = L[0].length();
        int totalLen = L.length*subLen;
        int scanLen = S.length() - L.length*subLen;

        Integer num;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            
            num = map.get(L[i]);
            if (num == null) {
                map.put(L[i], 1);
            } else {
                map.put(L[i], num+1);
            }
                
        }
        HashMap<String, Integer> rec;
        for (int i = 0; i <= scanLen; i++) {
            rec = new HashMap<String, Integer>(map);
            boolean matched = true;
            int idx = i;
            int end = totalLen + i;
            while (idx < end) {
                String key = S.substring(idx, idx+subLen);
                num = rec.get(key);
                if (num == null) {
                    matched = false;
                    break;
                } else {
                    if (num == 1)
                        rec.remove(key);
                    else
                        rec.put(key, num-1);

                }
                idx += subLen;
            }
            
            if (matched && rec.isEmpty())
                out.add(i);
            
        }
        
        return out;
    
        
    }
    
    public static void prtArray(ArrayList<Integer> ret) {
        
        for (Integer i: ret){
           System.out.print(i + " "); 
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        SubstrWithAllWords all = new SubstrWithAllWords();
        String s1 = "a";
        String[] l1 = {"a"};
        prtArray(all.findSubstring(s1, l1));
    }
}
