import java.util.*;
/**
 *   这道题懂了其实很简单就是找从0开始到j的最长回文串 ， 后面的子串再逆置到之前，结果即为所求
 */
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length==0 )
            return 0;
        int n = nums.length;
        int i = 0, j = 0;
        int sum = nums[0];
        int min = n;
        //典型的滑动窗口来做
        while(j<n){
           if(sum >= s){
               min = Math.min(min,j-i+1);
               sum -= nums[i];
               i++;
           }else{
               j++;
               if(j<n)
                   sum +=nums[j];
           }
        }
        //检查
        int t = 0;
        for(int k=0;k<n;k++)
            t += nums[k];
        if(t<s)
            return 0;
        return min;
    }
    public static void main(String args[]){
       int a[] = {1,2,3,4,5};
       int k = 11;
        System.out.println(new Solution().minSubArrayLen(k,a));
    }
}