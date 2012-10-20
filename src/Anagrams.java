import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Anagrams {
    private class ValPack {
        private int idx;
        private boolean flag;
    }
    
    public String sortString(String in) {
        char[] list = in.toCharArray();
        Arrays.sort(list);
        return new String(list);
    }
    
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> out = new ArrayList<String>();
        HashMap<String, ValPack> map = 
                new HashMap<String, ValPack>();
        int len = strs.length;

        
        for (int i = 0; i < len; i++) {
            String key = sortString(strs[i]);
            ValPack value = map.get(key);
            if (value == null) {
                value = new ValPack();
                value.flag = true;
                value.idx = i;
                map.put(key, value);
            }
                
            else {
                if (value.flag) {
                    value.flag = false;
                    out.add(strs[value.idx]);
                    map.put(key, value);
                }
                out.add(strs[i]);
                    
            }
        }
        return out;
        
    }
}
