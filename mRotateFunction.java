package challenge_6Company_30Days;

public class mRotateFunction {
    public static int maxRotateFunction(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int sum =0, iteration = 0, len = nums.length;

        for(int i=0; i<len; i++){
            sum += nums[i];
            iteration += (nums[i] * i);
        }

        int max = iteration;
        for(int j=1; j<len; j++){
            iteration = iteration - sum + nums[j-1]*len;
            max = Math.max(max, iteration);
        }

        return max;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,6};
        System.out.println(maxRotateFunction(nums));
    }
}
