import java.util.*;
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=val)
                nums[j++] = nums[i];    
        }

     return j;
    }
}