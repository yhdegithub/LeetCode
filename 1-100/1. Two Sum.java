/**
 *   (1)暴力尝试 ，O(n^2)
 *  (2)排序 ，用双指针夹逼 ， O(N * lg N )
 *  (3)使用HashMap,O(n)空间复杂度 ，但是时间可以降到 O(n)
 *
 * */import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = nums.length; 
        for(int i=0;i<n;i++){
            if( map.containsKey(target-nums[i]) ){
                return new int[]{ map.get(target - nums[i]), i };
            }else
                map.put( nums[i],  i );
        }
        return new int[]{-1,-1};
    }
    public static void main(String args[]){
        int nums[] = { 2,7,15,13 };
        int target = 20;
        int a[] = new Solution().twoSum(nums,target);
    }
}