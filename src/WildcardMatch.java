/*
 * ?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ¡ú false
isMatch("aa","aa") ¡ú true
isMatch("aaa","aa") ¡ú false
isMatch("aa", "*") ¡ú true
isMatch("aa", "a*") ¡ú true
isMatch("ab", "?*") ¡ú true
isMatch("aab", "c*a*b") ¡ú false
 */
public class WildcardMatch {
    public boolean isMatch(String s, String p) {
        if (p == null)
            return true;
        if (s == null)
            return false;
        
       
        int pIdx = 0;
        int sIdx = 0;
        int pLen = p.length();
        int sLen = s.length();
        boolean flag = false;
        
        while (pIdx < pLen && sIdx < sLen) {
            char key = p.charAt(pIdx);
            if (key == '?') {
                sIdx++;
            } else if (key == '*') {
                flag = true;
            } else {
                if (flag) {
                    flag = false;
                    while (sIdx < sLen-1 && s.charAt(sIdx) != key)
                        sIdx++;
                    if (s.charAt(sIdx) != key)
                        return false;
                    
                        
                } else {
                    if (s.charAt(sIdx) != key)
                        return false;
                    sIdx++;
                }
            }
            
            pIdx++;
        }
        
        if (flag && pIdx == pLen)
            return true;
        
        while (pIdx < pLen) {
            if (p.charAt(pIdx) != '*')
                return false;
            pIdx++;
        }
        
        if (sIdx != sLen)
            return false;
        
        return true;
    }
    
    public static void main(String[] args) {
        WildcardMatch w = new WildcardMatch();

        System.out.println(w.isMatch("aa", "a"));
        System.out.println(w.isMatch("aa", "aa"));
        System.out.println(w.isMatch("aaa", "aa"));
        System.out.println(w.isMatch("aa", "*"));
        System.out.println(w.isMatch("aa", "a*"));
        System.out.println(w.isMatch("ab", "?*"));
        System.out.println(w.isMatch("aab", "c*a*b"));
        System.out.println(w.isMatch("b", "*a*"));
        System.out.println(w.isMatch("", "*"));
        System.out.println(w.isMatch("a", ""));
        System.out.println(w.isMatch("b", "*?*?"));
        System.out.println(w.isMatch("a", "*a"));
    }
}
