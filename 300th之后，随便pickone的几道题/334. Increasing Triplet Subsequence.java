import java.util.*;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums==null || nums.length<=2)
            return false;
        int n = nums.length;
        int a = Integer.MAX_VALUE , b =a;
        for(int i=0;i<n;i++){
            if(nums[i]<=a)
                a = nums[i];
            else if(nums[i]<=b)
                b = nums[i];
            else
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Solution s = new Solution();
       int a[] ={1,1,1,1,1,1};
        System.out.println(new Solution().increasingTriplet(a));
    }
}