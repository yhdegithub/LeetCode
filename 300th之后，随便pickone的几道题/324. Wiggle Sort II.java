import java.util.*;
//排个序 ，然后双指针，一个从中间数往前 ， 一个从n-1往前
//最优法 现在我们可以同时做, 也就是, 遍历数组的时候如果当前的数大于中位数就将其从左往右放奇数位置, 如果小于中位数就将其从右往左放在偶数位置. 
class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length<=1)
            return ;
        int n =nums.length;
        Arrays.sort(nums);
        int res[] =new int[n];
        int i = (n-1)/2 ,j = n-1;
        int k=0;
        while(k<n){
            res[k++] = nums[i--];
            if(k<n)
            res[k++] = nums[j--];
        }
        for(i=0;i<n;i++)
            nums[i] =res[i];
    }

    public static void main(String args[]) {
        Solution s = new Solution();
       int a[] ={4,5,6,5};
      new Solution().wiggleSort(a);
    }
}