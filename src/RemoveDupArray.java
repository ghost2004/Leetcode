/*
 * Given a sorted array, remove the duplicates in place 
 * such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do
 this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDupArray {
    public int removeDuplicates(int[] A) {
        if (A == null)
            return 0;
        int length = A.length;
        if (length < 2)
            return length;
        int prev = A[0];
        int readPtr = 1;
        int wrPtr = 1;

        
        while (readPtr < length) {
            if (A[readPtr] != prev) {
                prev = A[readPtr];
                if (readPtr != wrPtr)
                    A[wrPtr] = prev;
                wrPtr++;

            }
            
            readPtr++;
        }

        return wrPtr;
    }
    
    
    public static void printArray(int[] A, int len)
    {
        System.out.print('{');
        for (int i = 0; i < len-1; i++)
            System.out.print(A[i]+", ");
        System.out.println(A[len-1]+"}");
    }
    
    public static void main(String[] args)
    {
        RemoveDupArray ar = new RemoveDupArray();
        int[] A1 = {1, 2, 2, 2, 3};
        int l1 = ar.removeDuplicates(A1);
        printArray(A1, l1);
        int[] A2 = {1, 2, 2, 2, 3, 3, 3};
        int l2 = ar.removeDuplicates(A2);
        printArray(A2, l2);       
    }

}
