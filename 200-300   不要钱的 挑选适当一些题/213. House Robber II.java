import java.util.*;
//区分偷不偷第一家
public class Solution {
    //1 2 3
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        return Math.max(robsub(nums, 0, nums.length-2), robsub(nums, 1, nums.length-1));
    }
    
    private int robsub(int[] nums, int s, int e) {
        int n = e - s + 1;
        int[] d =new int[n];
        d[0] = nums[s];
        d[1] = Math.max(nums[s], nums[s+1]);
        
        for(int i=2; i<n; i++) {
            d[i] = Math.max(d[i-2]+nums[s+i], d[i-1]);
        }
        return d[n-1];
    }
}
