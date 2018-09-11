import java.util.*;
class Solution {
    public int numDecodings(String s) {
      if(s==null || s.length()==0)
          return 0;
      int n  =s.length();
      //长度为1
      if(n==1){
          if(s.charAt(0)=='0')
              return 0;
          else  return 1;
      }
      //动态规划
        if(s.charAt(0)=='0')
            return 0;
        int dp[] = new int[n+1];
        dp[0] = 1;dp[1]=1;
     for(int i=2;i<=n;i++){
         int cur = s.charAt(i-1)-'0' , pre = s.charAt(i-2) - '0';
          if(cur==0){
              if(pre==1 || pre==2)
                  dp[i] = dp[i-2];
              else return 0;
          }else{
              int tmp  = pre*10 +cur;
              if(tmp<10)  dp[i] = dp[i-2];
              else if(tmp<=26)  dp[i] = dp[i-1] + dp[i-2];
              else dp[i] = dp[i-1];
     }
     }
    return dp[n];
    }
    public static void main(String args[]){
        System.out.println(new Solution().numDecodings("226"));
    }
}