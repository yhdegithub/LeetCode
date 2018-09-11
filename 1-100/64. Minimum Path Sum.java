public class Solution {
     public int minPathSum(int[][] a) {
        if(a==null)
            return 0;
        int m = a.length,  n = a[0].length;
        int dp[][] = new int[m+1][n+1];
        //初始行列
        dp[0][0] = a[0][0];
        for(int i =1;i<m;i++)
        dp[i][0] = dp[i-1][0] + a[i][0];
        for(int j =1;j<n;j++)
            dp[0][j] = dp[0][j-1] + a[0][j];
        //动态规划
        for(int i =1;i<m;i++)
            for(int j =1;j<n;j++)
                dp[i][j]  = a[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
        return dp[m-1][n-1];
    }
}