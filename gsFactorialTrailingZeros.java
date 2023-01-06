package challenge_6Company_30Days;

public class gsFactorialTrailingZeros {

    public static int trailingZeroes(int n) {
        int count = 0;

        while(n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }



    public static void main(String[] args) {
        int n = 5;
        System.out.println(trailingZeroes(n));
    }
}
