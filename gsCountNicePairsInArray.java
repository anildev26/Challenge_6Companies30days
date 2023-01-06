package challenge_6Company_30Days;

import java.util.*;

public class gsCountNicePairsInArray {
    static int rev(int n) {
        int res = 0;
        for (; n > 0; n /= 10)
            res = res * 10 + n % 10;
        return res;
    }
    public static int countNicePairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for (var n : nums) {
            int comp = n - rev(n), prev = m.getOrDefault(comp, 0);
            res = (res + prev) % 1000000007;
            m.put(comp,  prev + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {13, 10, 35, 24, 76};
        System.out.println(countNicePairs(nums));

    }
}
