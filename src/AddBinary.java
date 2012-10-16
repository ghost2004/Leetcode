
public class AddBinary {
    
    public int getIntFromString(String in, int idx) {
        if (idx < 0)
            return 0;
        if (in.charAt(idx) == '1')
            return 1;
        return 0;
    }
    public String addBinary(String a, String b) {

        String out = "";
        
        int idxa = a.length() - 1;
        int idxb = b.length() - 1;
        
        int max;
        
        if (idxa > idxb)
            max = idxa;
        else
            max = idxb;
        int carry = 0;
        for (int i = max; i >= 0; i--) {
            int sum = getIntFromString(a, idxa) + getIntFromString(b, idxb) +carry;
            carry = sum/2;
            int bit = sum % 2;
            if (bit == 1)
                out = "1" + out;
            else
                out = "0" + out; 
        }
        if (carry == 1)
            out = "1" + out;
        idxa--;
        idxb--;
        return out;
    }

}
