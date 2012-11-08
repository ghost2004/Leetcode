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
    
       
    // my solution
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
            int b = 1;
            while ((k == '1' || k == '2') && index < length -1) {
                char n = s.charAt(index+1);
                boolean flag1 = k == '1' && n > '0' && n <= '9';
                boolean flag2 = k == '2' && n > '0' && n < '7';
                if (flag1 || flag2) {
                    times += b;
                    b = times - b; 
                   
                }
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
    
  
    // checked solution from MITBBS
    public int numDe3(String s) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        if (n == 1) {
            if (s.charAt(0) == '0')
                return 0; // not valid
            else
                return 1;
        }
        int[] num = new int[n];
        if (s.charAt(0) == '0')
            return 0; // not valid
        else
            num[0] = 1;
        if (s.charAt(1) != '0')
            num[1] += num[0];
        if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6'))
            num[1]++;
        for (int i = 2; i < n; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }
            }
            if (s.charAt(i) != '0')
                num[i] += num[i - 1];
            if (s.charAt(i - 1) == '1'
                    || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))
                num[i] += num[i - 2];
        }
        return num[n - 1];

    }
    
    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        String s = "10";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s)); 
        s = "012";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s)); 
        s = "100";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s));    
        s = "110";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s));   
        s = "230";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s));         
        s = "1090";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s)); 
        s = "121";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s));   
        s = "1211";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s)); 
        s = "12111";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s));
        s = "121111";
        System.out.println(s + " --> "+d.numDecodings(s)+"  "+d.numDe3(s));
    }
}
