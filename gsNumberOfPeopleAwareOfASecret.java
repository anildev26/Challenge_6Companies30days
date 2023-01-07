package challenge_6Company_30Days;

public class gsNumberOfPeopleAwareOfASecret {

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[] = new long[n + 1], mod = (long)1e9 + 7, share = 0, res = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i)
            dp[i] = share = (share + dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget, 0)] + mod) % mod;
        for (int i = n - forget + 1; i <= n; ++i)
            res = (res + dp[i]) % mod;
        return (int)res;
    }

    public static void main(String[] args) {
        int n=6;
        int delay=2;
        int forget=4;
        System.out.println(peopleAwareOfSecret(n,delay,forget));

    }
}
