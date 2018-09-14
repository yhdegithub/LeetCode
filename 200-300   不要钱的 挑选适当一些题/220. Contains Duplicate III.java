import java.util.*;
//不是最优的 ，但是最暴力 ，O(n*k)
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] a, int k, int t) {
        int n = a.length;
        long nums[] = new long[n];
        for(int i=0;i<n;i++)
            nums[i] = (long)a[i];
        if(nums==null || nums.length==0)
            return false;
        if(n==1)
            return false;
        if(k==0)
            return t==0;
        for(int i=0;i<n;i++)
            for(int j=i+1;j<=i+k && j<n;j++)
            {
                long dif = Math.abs(nums[j] - nums[i]);
                if(dif<=t)
                    return true;

            }
        return false;
    }
    public static void main(String args[]) {
     int a[] ={1,5,9,1,5,9}; //0,1,3,5,6
        int k = 2 ,t =3;
        System.out.println(new Solution().containsNearbyAlmostDuplicate(a,k,t));
    }
}