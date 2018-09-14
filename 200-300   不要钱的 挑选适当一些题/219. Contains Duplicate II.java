import java.util.*;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return false;
        int n = nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],i);
            else
            if(i-map.get(nums[i])<=k)
                return true;
            else
                map.put(nums[i],i);

        }
        return false;
    }
    public static void main(String args[]){
        int a[]={};
        int k = 0;
        System.out.println(new Solution().containsNearbyDuplicate(a,k));
    }
}