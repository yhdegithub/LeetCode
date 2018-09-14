import java.util.*;
class Solution {
    public int findDuplicate(int[] nums) {
        if(nums==null || nums.length<=2)
            return 1;
        int n = nums.length;
        int low = 1 , high = n-1;
        //取一个数字key ，观察整个数组<=key的共有几个 ，如果>k了 ，则冗余的在<k之间了
        while(low<high){
            int count = 0;
            int mid = low + (high-low)/2;
            for(int i=0;i<n;i++)
                if(nums[i]<=mid)
                    count++;
              if(count > mid)
                  high = mid;
            else
                low = mid+1;
        }
        return low;
    }
}