
public class AddBinary {
    
    private long stringToInt(String in) {
        long out = 0;
        int idx = 0;
        int len = in.length();
        while (idx < len) {
            char i = in.charAt(idx);
            int v;
            if (i == '1')
                v = 1;
            else
                v = 0;

            out = 2*out + v;
            idx++;
        }
        return out;
    }
    
    private String intToString(long in) {
        long v = in;
        String t = "";
        if (in == 0)
            return "0";
        while (v > 0) {
            long i = v % 2;
            char p;
            if (i == 1)
                p = '1';
            else
                p = '0';
            
            t = p + t;
            
            v = v >> 1;
        }
        return t;
    }
    public String addBinary(String a, String b) {

        String out = null;
        long va = stringToInt(a);
        long vb = stringToInt(b);
        
        out = intToString(va+vb);
        
        return out;
    }

}
