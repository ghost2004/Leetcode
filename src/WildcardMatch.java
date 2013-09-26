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
        int starIdx = -1;
        int lastStar = 0;
        int pLen = p.length();
        int sLen = s.length();
        
        while (sIdx < sLen) {
            char pKey;
            if (pIdx < pLen)
                pKey = p.charAt(pIdx);
            else
                pKey = '\0';
            
            if (s.charAt(sIdx) == pKey || pKey == '?') {
                sIdx++;
                pIdx++;
            } else if (pKey == '*') {
                starIdx = pIdx;
                pIdx++;
                lastStar = sIdx;
            } else if (starIdx != -1) {
                pIdx = starIdx + 1;
                sIdx = (++lastStar);
            } else
                return false;
        }
        
        
        while (pIdx < pLen) {
            if (p.charAt(pIdx) != '*')
                return false;
            pIdx++;
        }
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
        System.out.println(w.isMatch("ab", "*a"));
        System.out.println(w.isMatch("bbaabb", "b??a"));
    }
}
