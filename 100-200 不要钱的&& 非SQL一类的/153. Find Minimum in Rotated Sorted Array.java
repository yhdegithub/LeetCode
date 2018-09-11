import java.util.*;
class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length<=0)
            return -1;
         int n = nums.length;
        int min = Integer.MAX_VALUE;
        if(nums[0]<nums[n-1])  //本来就顺序的
            return nums[0];
        int low = 0 ,high = n-1;
        while(low<high){
            int mid = (low+high)/2;
            //出口
            if(low==high-1)
                return nums[high];
            if(mid==n-1 || mid==0 )
                return nums[mid];
            if(nums[low]<nums[mid])  //左边有序的，最小值在右边
                low = mid;
                else if( nums[mid] < nums[low])           //右边有序的
                   high = mid;
            else
                low++;                     //有冗余的时候
            
            
            
        }
       
            return nums[low];
        
   
    }
}