import java.util.*;
class Solution {
    //只用比较 n 次
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length<=1)
            return 0;
        int n =nums.length;
        int i =0 , j =n-1;
        while(i<j){
            int mid = (i+j)/2;
            if( mid==n-1||nums[mid]<nums[mid+1])
                return mid;
            else if( mid==0||nums[mid]>nums[mid-1])
                 i = mid+1;
                    else
                        j= mid;
        }
        
        return i;
        
            }
}