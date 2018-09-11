import java.util.*;
class Solution {
    public boolean canJump(int[] nums) {
        if( nums == null || nums.length <= 1)
            return true;
        int n = nums.length;
        int max = 0 ;  //当前最远到达距离
        for(int i=0;i<n && i <= max ;i++){
            max = Math.max(max,i + nums[i]);
            if(max >= n-1 )
                return true;
            
        }
       return false;
    }
}