/*
 * Write a function to find the longest common prefix
 *  string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs == null || strs.length == 0)
            return "";
        
        int num = strs.length;
        
        if (num == 1)
            return strs[0];
        int len1 = strs[0].length();
        String prefix = "";
        
        for (int idx = 0; idx < len1; idx++) {
            boolean flag = false;
            char key = strs[0].charAt(idx);
            for (int i = 1; i < num; i++) {
                if (strs[i].length() <= idx || strs[i].charAt(idx) != key) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
            else {
                prefix += key;
            }
        }
        
        return prefix;
        
    }
}
