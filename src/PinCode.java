/*
 * A digital panel for locker box, 4 digital pin number 
 * (from 0000 to 9999)
 * Initial code is 0000, then the locker box will check
 *  whether the pin is correct or not
 * next time you will try 0001, then 0012... etc.
 * Find a shortest string that guarantee to find out right pin number
 * 
 */
public class PinCode {
    private boolean[][] flags;
    public String getPinCode() {
        flags = new boolean[1000][10];
        String stream = "0000";
        flags[0][0] = true;
        int idx = 1;
        int cnt = 1;

        while (cnt < 10000) {
            int p = Integer.parseInt(stream.substring(idx, idx+3));
            int k = 9;
            int p2 = p;
            boolean found = false;
            do {
                while (k >= 0 && flags[p][k])
                    k--;
                if (k < 0) 
                    p++;
                else {
                    cnt++;
                    found = true;
                }
                    
                p = p % 1000;
                
            } while (!found);
            
            if (p2 == p) {
                stream += Integer.toString(k);
                idx++;
            } else {
                if (p < 10) 
                    stream += "00"+Integer.toString(p);
                else if (p < 100)
                    stream += "0"+Integer.toString(p);
                else
                    stream += Integer.toString(p);
                idx += 3;
            }

        }

        return stream;
    }
    
    public static void main(String[] args) {
        PinCode pin = new PinCode();
        System.out.println(pin.getPinCode());
    }

}
