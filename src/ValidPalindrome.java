
/*
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty?
 * This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    
    public static boolean isValidChar(char idx) {
        if (idx >= 'a' && idx <= 'z')
            return true;
        if (idx >= '0' && idx <= '9')
            return true;
        return false;
    }
    
    public static int getNextChar(String inStr, int idx, int dir) {
        int index = idx;
        int max = inStr.length() -1;
        while (index >= 0 && index <= max
               && !isValidChar(inStr.charAt(index))) 
            index += dir;
        return index;
        
    }
    
    public static boolean isPalindrome(String s) {
        
        if (s == null)
            return false;
        
        int length = s.length();
        
        if (length == 0)
            return true;
        String t = s.toLowerCase();
        int leftIdx = getNextChar(t, 0, 1);
        int rightIdx = getNextChar(t, length-1, -1);
        while (leftIdx < rightIdx) {
            if (t.charAt(leftIdx) != t.charAt(rightIdx))
                return false;
            leftIdx = getNextChar(t, leftIdx+1, 1);
            rightIdx = getNextChar(t, rightIdx-1, -1);
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isPalindrome("..d."));
        System.out.println(isPalindrome("c#dc"));
    }
    
}
