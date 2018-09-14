import java.util.*;
class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums==null || nums.length<=1)
            return new int[]{-1,-1};
        int n = nums.length;
        int t = 0;
        for(int i=0;i<n;i++)
            t = t^nums[i];
        int pos = find(t);
       int a = 0 , b = 0;
        for(int i=0;i<n;i++){
            if((nums[i] & pos )==0){
                         a = a ^ nums[i];   
            }else
                b = b ^ nums[i];
        }
        return new int[]{a,b};
    }
    //t的第几位不为0，找出一个来,且设置这个数为判定值
    public int find(int t){
        for(int i=0;i<32;i++)
        if( (t & (1<<i))!=0  )
        return 1<<i;
        return  -1;
    }
}