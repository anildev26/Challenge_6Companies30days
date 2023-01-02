package challenge_6Company_30Days;

public class mRotateFunction {
    public static int maxRotateFunction(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int sum = 0, prevProduct = 0;

        for(int i = 0; i < n; i++) //Calculating f[0] here
        {
            sum += nums[i]; //f[0] Sum
            prevProduct += (nums[i] * i); //f[0] value*index = total
        }

        int ans = prevProduct;

        for(int k = 1; k < n; k++) //ignoring the 0th index and starting from 1
        {
            int newProduct = prevProduct + (nums[k - 1] * (n - 1)) - (sum - nums[k - 1]);
            prevProduct = newProduct;
            ans = Math.max(newProduct, ans);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,6};
        System.out.println(maxRotateFunction(nums));
    }
}
