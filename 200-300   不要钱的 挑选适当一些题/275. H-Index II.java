import java.util.*;
//既然是log n 那肯定要二分 ，关键是怎么找分界点
class Solution {
    public int hIndex(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n = nums.length;
        if(nums[0]>=n)
            return n ;
        if(nums[n-1]==0)
            return 0;
        //搞成降序的
        for(int i=0;i<n/2;i++){
            int t = nums[i];
            nums[i] =nums[n-1-i];
            nums[n-1-i] = t;
        }

        int low = 1,high = n-1;
        while(low<high){
            int mid = (low+high)/2;
            if(nums[mid-1]>=mid && !(nums[mid]>=mid+1))                  //满足 mid 但是不能满足 mid+1;
                return mid;
            else if(nums[mid-1] < mid )
                high = mid-1;
            else
                low = mid+1;

        }
        return low;
    }

    public static void main(String args[]) {
     int a[] ={0,1,3,5,6};
        System.out.println(new Solution().hIndex(a));
    }
}