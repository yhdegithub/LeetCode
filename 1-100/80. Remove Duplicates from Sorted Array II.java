import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null||nums.length<=2)
            return nums.length;
        int n =nums.length;
        int j = 2;
        for(int i=2;i<n;i++){
            if(nums[i]!=nums[j-2])
                 nums[j++] = nums[i];
        }
    
     return j;
    }
}