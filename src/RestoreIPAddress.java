import java.util.*;
/*
 * Given a string containing only digits, restore it 
 * by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


 */
public class RestoreIPAddress {
    
    public void findIPaddress(String s, 
            ArrayList<String> list, ArrayList<Integer> prefix)
    {
        int i;
        int subIP;
        int size = prefix.size();
        if (s.length() == 0)
            return;
        if (prefix.size() == 3)
        {
            if (s.length() <= 3 && 
                   (s.length() == 1 || s.charAt(0)!= '0')){
                subIP = Integer.parseInt(s);
                if (subIP >= 0 && subIP <= 255) {
                    StringBuffer buf = new StringBuffer();
                    for (i = 0; i < 3; i++) {
                        buf.append(prefix.get(i));
                        buf.append('.');
                    }
                    buf.append(subIP);
                    list.add(buf.toString());
                }
            }
            
            return;
        }
        for (i = 1; i <=3 ;i++) {
            if (i < s.length() && ( i == 1 || s.charAt(0) != '0')) {
                subIP = Short.parseShort(s.substring(0, i));
                if (subIP <= 255) {
                    prefix.add(subIP);
                   
                    findIPaddress(s.substring(i), list, prefix);
                    prefix.remove(size); 
                } 
                
            }
              
        }
        
    }
    
    
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> output = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return output;
        ArrayList<Integer> prefix = new ArrayList<Integer>();
        
        findIPaddress(s, output, prefix);
        return output;

        
    }
    
    public static void printIP(RestoreIPAddress r, String s) {
        ArrayList<String> list = r.restoreIpAddresses(s);
        
        for (String ip:list) {
            System.out.println(ip);
        }
    }
    public static void main(String[] args) {
        String s = "0000";
        RestoreIPAddress r = new RestoreIPAddress();
        printIP(r,s);
        
        s = "172162541";
        printIP(r,s);
        
        s = "010010";
        printIP(r,s);

        
    }
}
