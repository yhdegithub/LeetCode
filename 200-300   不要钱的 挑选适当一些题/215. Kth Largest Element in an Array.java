import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //用快排思想，时间就是线性的
        if(nums==null || nums.length<k || nums.length==0 || k<=0)
            return -1;
        int n = nums.length;
        int  target =  find(nums,n-k,0,n-1); //第k大也就是 从0,1，..开始的第 n-k小
        return target;
    }
    //
    public int find(int a[] , int k,int low,int high){
        if(low>=high)
            return a[low];
        while(low<=high){
            int pos = partition(a,low,high);
            if(pos==k)   return a[pos];
            else if(pos > k)   high = pos-1;
            else
                low = pos+1;
        }
        return a[low];
    }
    //
    public int partition(int a[],int low,int high){
        if(low>=high)
            return low;
        int pivot = a[low];
        while(low < high){
            while(low<high && a[high]>=pivot)  high--;
            a[low] = a[high];
            while(low<high && a[low]<=pivot)  low++;
            a[high] = a[low];


        }
        a[low] = pivot;
        return low;

    }
    public static void main(String args[]){
        int nums[] = {3,2,3,1,2,4,5,5,6};
        int n = 3;
            System.out.println("第"+ n + "大" + new Solution().findKthLargest(nums,n));
    }
}