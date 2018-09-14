import java.util.*;
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0)
            return new int[]{};
        int n = nums.length;
        int c[] =new int[n];
        int d[] = new int[n];
        c[0] = 1;
        for(int i=1;i<n;i++)
            c[i] = c[i-1] * nums[i-1];
        d[n-1] = 1;
        for(int i=n-2;i>=0;i--)
            d[i] = d[i+1] * nums[i+1];
        int res[] =new int[n];
        for(int i=0;i<n;i++)
            res[i] = c[i] *d[i];
      return res;
    }
    public static void main(String arghs[]){
        System.out.println(new Solution().productExceptSelf(new int[]{1,2,3,4}));
    }
}