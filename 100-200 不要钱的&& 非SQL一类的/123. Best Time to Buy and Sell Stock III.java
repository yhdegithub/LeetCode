import java.util.*;
public class Solution {
  public int maxProfit(int[] p) {
      int res = 0;
      int n=p.length;
      if(n<=1)
          return 0;
      int first =0 , second = 0;
      for(int i=0;i<n-1;i++){
          first = max(p,0,i);
          second = max(p,i,n-1);
          if(first+ second > res)
              res = first + second;
      }
      return res;
    }
   //求某一段的最大收益
    public int max(int p[],int low,int high){
        int max = 0;
        int  min  = p[low];
        for(int i=low;i<=high;i++){
           max = Math.max(max,p[i] - min);
          if(p[i]<min)
              min = p[i];
        }
       return max;


    }
}