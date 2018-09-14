import java.util.*;
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length<=1)
            return;
        int n = nums.length;
        int count = 0;
        int i=0 , j =n-1;
        for(;i<n;i++)
            if(nums[i]==0)  count++;
        int left = 0;
        for(i=0;i<n;i++)
            if(nums[i]!=0)
            nums[left++] = nums[i];
        while(left<n)
            nums[left++] = 0;
    }
    public static void main(String args[]){
        new Solution().moveZeroes(new int[]{0,1,0,3,12});
    }
}