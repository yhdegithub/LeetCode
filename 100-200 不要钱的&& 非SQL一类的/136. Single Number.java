import java.util.*;
class Solution {
    public int singleNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n;i++)
            res = res ^ nums[i];
        return res;
    }
}