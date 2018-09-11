import java.util.*;
class Solution {
    //这个用动态规划
    public boolean isMatch(String s, String p) {
        if((s==null&&p==null) ||(s.length()==0 && p.length()==0))
            return true;
        if(s==null || p==null)
            return false;
        int m = s.length() , n=p.length();
        if(n==0)   return m==0;
        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        //初始化
        if(p.charAt(0)=='*')
            for(int i=0;i<=m;i++)
                dp[i][1] = true;
        int k =0;
        while(k<n && p.charAt(k++) == '*')
            dp[0][k] = true;
        //开始递推
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)=='*'){
                    for(k=0;(k<=i)&&(!dp[i][j]);k++)
                        dp[i][j] = dp[i][j]  || dp[k][j-1];
                }else

                    dp[i][j]  = dp[i-1][j-1] &&(s.charAt(i-1)==p.charAt(j-1)|| p.charAt(j-1)=='?');

            }


        return dp[m][n];
    }
}