package challenge_6Company_30Days;

import static java.lang.Integer.MIN_VALUE;

public class mUnsortedContinuousSubarray {
    /*
    Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order,
    then the whole array will be sorted in ascending order.

    Return the shortest such subarray and output its length.
     */
    public static int findUnsortedSubarray(int[] nums) {
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    minimum = Math.min(minimum, nums[i]);
                    maximum = Math.max(maximum, nums[i]);
                }
            } else if (i == n - 1) {
                if (nums[i] < nums[i - 1]) {
                    minimum = Math.min(minimum, nums[i]);
                    maximum = Math.max(maximum, nums[i]);
                }
            } else {
                if ((nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) || (nums[i] < nums[i + 1] && nums[i] < nums[i - 1])) {
                    minimum = Math.min(minimum, nums[i]);
                    maximum = Math.max(maximum, nums[i]);
                }
            }
        }
        if(minimum == Integer.MAX_VALUE || maximum == Integer.MIN_VALUE){
            return 0;
        }
//find the position of minimum and maximum to get the length between them
        int i,j;
//ex: [1,2,3,6] find position of 5
        for(i=0; i< n && nums[i]<=minimum;i++); //[1,2,3,"5",6]

//ex: [1,2,3,5,6] find position of 4 from back
//to find the maximum element position start the loop from right
        for(j=n-1; j>=0 && nums[j]>=maximum;j--);

        return j-i+1;



    }



    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(nums));

    }
}
