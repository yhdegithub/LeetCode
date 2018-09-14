import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums==null || nums.length<=1)
            return false;
        int n =nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++)
            if(set.contains(nums[i]))
                return true;
        else
            set.add(nums[i]);
        return false;
    }
}