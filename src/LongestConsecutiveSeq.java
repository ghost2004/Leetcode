
import java.util.HashSet;
/*
 * Given an unsorted array of integers, find the length of the
 *  longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSeq {
    public int findCnt(HashSet<Integer> set, int key, int step)
    {
        int cnt = 0;
        int word = key;
        boolean flag = set.contains(word);
        
        while (flag) {
            cnt++;
            set.remove(word);
            word += step;
            flag = set.contains(word);
        }
        return cnt;
    }
    
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        for (int i:num) {
            set.add(i);
        }
        
        int max = 0;
        
        for (int i:num) {
            max = Math.max(max, findCnt(set, i, 1)+findCnt(set, i-1, -1));
        }
        
        return max;

    }

}
