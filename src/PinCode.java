/*
 * A digital panel for locker box, 4 digital pin number 
 * (from 0000 to 9999)
 * Initial code is 0000, then the locker box will check
 *  whether the pin is correct or not
 * next time you will try 0001, then 0012... etc.
 * Find a shortest string that guarantee to find out right pin number
 * 
 */
import java.util.HashSet;

public class PinCode {
    
    private String dfs(HashSet<Integer> visited, String pin) {
        int idx = pin.length() - 2;
        String prefix = pin.substring(idx, idx+2);
        String out = null;
        for (int i = 0; i < 2; i++) {
            String nextPin = prefix + Integer.toString(i);
            
            Integer key = new Integer(nextPin);
            if (!visited.contains(key)) {
                String newPin = pin+Integer.toString(i);
                
                visited.add(key);
                System.out.println("New Key " +key + " new Pin "+ newPin + " size " + visited.size() );
                if (visited.size() == 8)
                    return newPin;
                
                out = dfs(visited, newPin);
                if (out != null)
                    return out;
                visited.remove(key);
            }
            
        }
        
        System.out.println("Failed to find an answer in " + pin);
        return out;
    }
    public String getPinCode() {
        String stream = "000";
        HashSet<Integer> visited = new  HashSet<Integer>();
        visited.add(0);
        String out = dfs(visited, stream);
        return out;
    }
    
    public static void main(String[] args) {
        PinCode pin = new PinCode();
        System.out.println(pin.getPinCode());
    }

}
