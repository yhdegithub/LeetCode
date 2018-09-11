import java.util.*;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length , n = nums2.length;
        if(m==0&&n==0)  return 0.0;
        if(m==0)   return (nums2[n/2] +  nums2[(n-1)/2]) /2.0;
        if(n==0)   return (nums1[m/2] +  nums1[(m-1)/2]) /2.0;
        int l = getKTh(nums1,0,nums2,0,(m+n+1)/2);
        int r =  getKTh(nums1,0,nums2,0,(m+n+2)/2);

        double res = (l+r)/2.0;
        return res;
    }
    //找两个有序数组的第K小的数字,这样找就可以保证时间复杂度变成O(lg（m+n）)了
    public int getKTh(int a[],int aLow ,int b[],int bLow,int k ){
        if(aLow>=a.length)
            return b[bLow+k-1];
        if(bLow>=b.length)
            return a[aLow+k-1];
        if(k==1)
            return Math.min(a[aLow],b[bLow]);
        int aMid = Integer.MAX_VALUE , bMid = Integer.MAX_VALUE;
        if(aLow + (k/2) - 1 < a.length)
            aMid = a[aLow + (k/2) - 1];
        if(bLow + (k/2) - 1 < b.length)
            bMid = b[bLow + (k/2) - 1];
        if(aMid<=bMid)
            return getKTh(a,aLow+k/2,b,bLow,k - k/2);
        else

            return getKTh(a,aLow,b,bLow+k/2,k - k/2);
    }
    public static void main(String args[]){
        int a[] = {1,3};
        int b[]={2};
        System.out.println(new Solution().findMedianSortedArrays(a,b));
    }
}