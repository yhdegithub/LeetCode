import java.util.*;
class Solution {

    public int missingNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n =nums.length;
        //把数字i的位置nums[i] 使得 i==nums[i]
        for(int i=0;i<n;i++){
            while(nums[i]!=n && i!=nums[i]){
                swap(nums,i,nums[i]);
            }
        }
        for(int i=0;i<n;i++)
            if(nums[i]!=i)
                return i;
        return n;
    }
    public void swap(int a[],int i,int j){
        int t = a[i];
        a[i] = a[j];
        a[j] =t;
    }


    public static void main(String args[]){
        System.out.println(new Solution().missingNumber(new int[]{0}));
        System.out.println(new Solution().missingNumber(new int[]{1}));
        System.out.println(new Solution().missingNumber(new int[]{3,0,1}));
        System.out.println(new Solution().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        //System.out.println(Integer.bitCount(100));//???????????????????????????????????????????????????????????????????????????????????????
    }
}