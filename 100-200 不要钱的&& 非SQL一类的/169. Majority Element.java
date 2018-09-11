import java.util.*;
class Solution {
    public int majorityElement(int[] nums) {
        if(nums==null || nums.length==0)
            return -1;
        int n=nums.length;
        int time=0;
        int res = -999999;
        for(int i=0;i<n;i++){
            if(time==0){
                res = nums[i];
            }
            
            if(res==nums[i]){
                time++;
            }else{
               time--; 
            }
        }
    
    return res;
    }
}