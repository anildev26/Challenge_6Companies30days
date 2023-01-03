package challenge_6Company_30Days;

import java.util.Arrays;

public class mMinimumDeletionToMakeArrayDivisible {
    public static int minOperations(int[] arr, int[] numsDivide) {
        int gcd = numsDivide[0];
        for (int i = 0; i < numsDivide.length; i++) {
            gcd = helper(numsDivide[i], gcd);
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (gcd % arr[i] == 0) {
                return count;
            } else {
                count += 1;
            }
        }
        return -1;
    }
    public static int helper(int a, int b) {
        if (b == 0)
            return a;
        return helper(b, a % b);
    }
    /*
    SOLUTION 2:

    public int minOperations(int[] A, int[] numsDivide) {
        int g = numsDivide[0], tmp;
        for (int a : numsDivide) {
            while (a > 0) { // g = gcd(g, a)
                tmp = g % a;
                g = a;
                a = tmp;
            }
        }
        Arrays.sort(A);
        for (int i = 0; i < A.length && A[i] <= g; ++i)
            if (g % A[i] == 0)
                return i;
        return -1;
    }
     */
    public static void main(String[] args) {
        int[] array = {2,3,2,4,3};
        int[] numsDivide = {9, 6, 9, 3, 15};
        System.out.println(minOperations(array,numsDivide));

    }


}
