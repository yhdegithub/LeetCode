import java.util.*;

class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null || nums.length<=1 || k<=0)
            return;
        int n=nums.length;
        k = k%n;
        if(k==0) return;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=n-k;i<n;i++)
            list.add(nums[i]);
        int j=n-k-1;
        int i=n-1;
        for(i=n-1;i>0&&j>=0;i--,j--)
            nums[i] = nums[j];
        j=0;
       for(i=0;i<k;i++)
            nums[i] = list.get(j++);
    }
    public static void main(String args[]) {
        int a[] = {1,2,3,4,5,6,7};// 1,2,0      7,8,9,11,12
        int k=0;
      new Solution().rotate(a,k);

    }
}