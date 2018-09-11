import java.util.*;
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n=nums.length;
        if(n<=1)
            return n;
        int j=1;
        for(int i=1;i<n;i++){
            if(nums[i]!=nums[j-1])
                nums[j++] = nums[i];
        }

        return j;
    }
}