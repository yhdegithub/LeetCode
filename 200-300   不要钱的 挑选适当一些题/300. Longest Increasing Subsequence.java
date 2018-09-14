import java.util.*;
/**
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] increasing = new int[nums.length];
        int size = 0;
        for(int i=0; i<nums.length; i++) {
            int left=0, right=size-1;
            while (left<=right) {
                int m=(left+right)/2;
                if (nums[i] > increasing[m]) left = m + 1;
                else right = m - 1;
            }
            increasing[left] = nums[i];
            if (left==size) size ++;
        }
        return size;
    }
}


*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        //dp[i]代表以nums[i]结尾的数字的符合题意的结果 ， 那么在j = 0,1,2...i-1之中 ，若dp[j]<dp[i]  则 dp[i] = Math.max(dp[i],dp[j]+1);
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
        }
        int max = 1;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp[i]);
        return max;
    }

    public static void main(String args[]) {
        int a[] = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLIS(a));

    }
}