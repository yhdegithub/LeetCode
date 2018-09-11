//依旧简单的动态规划
import java.util.*;
public class Solution {
     public int uniquePathsWithObstacles(int[][] a) {
        if(a==null)
            return 0;
        int m = a.length, n=a[0].length;
        if(m==0 && a[0][0] == 0)
            return 1;
        int dp[][] = new int[m+1][n+1];
        if(a[0][0] == 1)
            return 0;
        //初始化第一行第一列
        for(int i =0;i<m;i++)
            if(a[i][0]==1)
                break;
            else
                dp[i][0] = 1;
        for(int j=0;j<n;j++)
            if(a[0][j]==1)
                break;
            else
                dp[0][j] = 1;
        //递推
        for(int i =1;i<m;i++)
            for(int j =1;j<n;j++){
                if(a[i][j]==1)
                    dp[i][j]= 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];

            }
        return dp[m-1][n-1];
}
}