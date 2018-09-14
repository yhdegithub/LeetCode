import java.util.*;
/**
 *   剑指offer上讲的不清不楚的 ，请参考博客 ，这里是用的暴力法 。也可用一个优先队列改进
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length<k || nums.length==0)
            return new int[]{};
        List<Integer>list =new ArrayList<>();
        int n= nums.length;
        for(int i=0;i<=n-k;i++){
            int max = nums[i];
            for(int j=i+1;j<i+k&&j<n;j++)
                max = Math.max(max,nums[j]);
            list.add(max);
        }
        int res[] = new int[list.size()];
        for(int i=0;i<list.size();i++)
            res[i] = list.get(i);
        return res;
    }
    public static void main(String args[]){
       int a[] = {1,3,-1,-3,5,3,6,7};
       int k = 3;
       new Solution().maxSlidingWindow(a,k);
    }
}