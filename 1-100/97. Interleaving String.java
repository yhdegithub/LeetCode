import java.util.*;
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        //二维的dp[][]
        int m =s1.length() , n=s2.length() ,k =s3.length();
        if(m+n!=k)
            return false;
        boolean dp[][] = new boolean[m+1][n+1];
        /*  s1取出前i个字符，s2前j个字符，s3前i+j个字符
        *    初始化 ： i==0 和j==0时候的情况
        *    转移方程 ： dp[i][j]==true 当且仅当 s3.charAt(i+j-1)==s1.charAt(i-1) && dp[i-1][j]   ||    s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]
        * */
        dp[0][0] = true;
        for(int i=1;i<=m;i++)
            if(s1.charAt(i-1)==s3.charAt(i-1))
                dp[i][0] = true;
        else  break;
        for(int i=1;i<=n;i++)
            if(s2.charAt(i-1)==s3.charAt(i-1))
                dp[0][i] = true;
            else  break;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
              dp[i][j] = (( s3.charAt(i+j-1)==s1.charAt(i-1) && dp[i-1][j] )   ||  (  s3.charAt(i+j-1)==s2.charAt(j-1) && dp[i][j-1]));


        return dp[m][n];
    }
    public static void  main(String args[]){
        String s1 = "";
        String s2 =  "b";
        String s3 = "b";
        System.out.println(new Solution().isInterleave(s1,s2,s3));

    }
}