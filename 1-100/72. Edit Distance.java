import java.util.*;
class Solution {
    public int minDistance(String s, String t) {
        if(s==null || t==null)
            return -1;
        int m =s.length() , n = t.length();
        int dp[][] = new int[m+1][n+1];
        //从s[0..i-1]到t[0..j-1]之间的最短距离
        for(int i=0;i<=m;i++)
            dp[i][0] = i;
        for(int j=0;j<=n;j++)
            dp[0][j] = j;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                   else
                       dp[i][j] = 1 + Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
             return dp[m][n];   
    }
}