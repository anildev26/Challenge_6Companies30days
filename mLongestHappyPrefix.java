package challenge_6Company_30Days;

public class mLongestHappyPrefix {
    public static String longestPrefix(String s) {
        int n = s.length();
        int [] lps = new int[n];
        int j=0;
        for(int i=1;  i<n; i++){
            while( j>0 && s.charAt(i) != s.charAt(j)){
                j = lps[j-1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            lps[i] = j;
        }
        String ans = s.substring(0,lps[n-1]);
        return ans;
    }

    public static void main(String[] args) {
        String s = "acccbaaacccbaac";
        System.out.println(longestPrefix(s));

    }
}
