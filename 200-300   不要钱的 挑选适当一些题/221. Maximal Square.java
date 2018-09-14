import java.util.*;
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int m = matrix.length , n = matrix[0].length;
        /**以dp[i][j]，代表以(i,j)为右下角的最大正方形 ，
         *   (1)m[i][j] = 0  ,dp[][] = 0;
         *   (2)else   dp[][] = 1 + min(dp[i-1][j-1] , [i][j-1],[i-1][j]);
         *
         */
        int dp[][] = new int[m][n];
        int res = 0;
        //初始化 i=0 ,和j=0;
        for(int j=0;j<n;j++)
            if(matrix[0][j]=='1'){
                dp[0][j] = matrix[0][j] - '0';
                res = 1;
            }

        for(int i=0;i<m;i++){
            dp[i][0] = matrix[i][0] - '0';
            if(dp[i][0]==1)
                res = 1;
        }

        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                if(matrix[i][j]=='1'){
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j]);
                    res = Math.max(dp[i][j] * dp[i][j] , res);
                }
        return res;

    }
    public static void main(String args[]){
        char matrix[][] ={
                {'1'}


        };

        System.out.println(new Solution().maximalSquare(matrix));
    }
}