/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A 

is now [1,1,2,2,3].
 */
public class RemoveDupArrayII {
    public int removeDuplicates(int[] A) {
        if (A == null)
            return 0;
        if (A.length < 3)
            return A.length;
        
        int cnt = 0;
        int rd = 1;
        int wr = 1;
        int prev = A[0];

        for (rd = 1; rd < A.length; rd++) {
            if (A[rd] == prev) {
                cnt++;
                if (cnt > 1)
                    continue;
            } else {
                cnt = 0;
                prev = A[rd];
            }
            
            if (wr != rd)
                A[wr] = A[rd];
            wr++;    
        }

        return wr;
    }
    
    
    public static void prtArray(int[] a, int len) {
        for (int i = 0; i < len; i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        RemoveDupArrayII r = new RemoveDupArrayII();
        int[] a0 = {1};
        int[] a1 = {1, 1};
        int[] a2 = {1, 1, 1};
        int[] a3 = {1, 1, 1, 2};
        int out;
        out = r.removeDuplicates(a3);
        prtArray(a3, out);
        out = r.removeDuplicates(a0);
        prtArray(a0, out);
        out = r.removeDuplicates(a1);
        prtArray(a1, out);
        out = r.removeDuplicates(a2);
        prtArray(a2, out);

    }
}
