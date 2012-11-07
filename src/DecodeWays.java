/*
 * A message containing letters from A-Z is being encoded
 *  to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the 
total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */

public class DecodeWays {
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int ways = 1;
        int length = s.length();
        
        int index = 0;
        
        while (index < length) {
            
            char k = s.charAt(index);
            if (k <= '0' || k > '9')
                return 0;

            int times = 1;
            while ((k == '1' || k == '2') && index < length -1) {
                char n = s.charAt(index+1);
                boolean flag1 = k == '1' && n > '0' && n <= '9';
                boolean flag2 = k == '2' && n > '0' && n < '7';
                if (flag1 || flag2) 
                    times++;
                index++;
                k = s.charAt(index);
            }
            if (k == '0' && times > 1)
                times--;
            ways *= times;
            index++;
            
        }
        
        return ways;
    }
    
    public boolean ambiguosNum(char a, char b) {
        if ((a == '1' && b != '0')
            || (a == '2' && b < '7' && b > '0'))
            return true;
        
        return false;
    }
    
    public int numDecodings2(String s) {

        if (s == null || s.length() == 0)
            return 0;
        
        
        
        if (s.charAt(0) == '0')
            return 0;
        
        int outNum = 1;
        
        int length = s.length();
        
        int i = 0;

        while (i < length) {
  
            if (s.charAt(i) == '0')
                return 0;
            if (i < length -1) {
                if ((s.charAt(i) == '1' || s.charAt(i) == '2')
                        && s.charAt(i+1) == '0') {
                        i += 2;
                        continue;
                }
                if (ambiguosNum(s.charAt(i), s.charAt(i+1))) {
                    int cnt = 2;
                    i++;
                    while (i < length -1 && ambiguosNum(s.charAt(i), s.charAt(i+1)))
                    {
                        cnt++;
                        i++;
                    }
                    
                    if (i < length -1 && s.charAt(i+1) == '0') {
                        if (s.charAt(i) > '2')
                            return 0;
                        cnt--;
                        i++;
                    }
                        
                    if (cnt != 0)
                        outNum *= cnt;

                }
                    
                
            }
            
            i++;
            
        }
        
        return outNum;
        
    }
    
    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        String s = "10";
        System.out.println(s + " --> "+d.numDecodings(s));
        s = "012";
        System.out.println(s + " --> "+d.numDecodings(s));
        s = "100";
        System.out.println(s + " --> "+d.numDecodings(s));   
        s = "110";
        System.out.println(s + " --> "+d.numDecodings(s));  
        s = "230";
        System.out.println(s + " --> "+d.numDecodings(s));        
        s = "1090";
        System.out.println(s + " --> "+d.numDecodings(s));
    }
}
