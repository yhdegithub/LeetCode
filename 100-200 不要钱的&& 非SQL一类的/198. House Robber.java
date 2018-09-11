import java.util.*;
class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        //dp[i]代表0，..i为止的最大和 ，那么最后一个元素要么是nums[i] , 要么是nums[i-1]
        int dp[] = new int[n+1];
        if(n==1)  return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
         for(int i=2;i<n;i++){
             
             dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]); 
             
         }
        return dp[n-1];
    }
}