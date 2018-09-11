import java.util.*;
//回文子串可以用一个dp[][]，这是一个套路
class Solution {
    public String longestPalindrome(String s) {
        if(s==null)  return "";
        int n =s.length();
        if(n==0)  return "";
        boolean dp[][] = new boolean[n][n];
        String res =String.valueOf( s.charAt(0) );
        for(int j=0;j<n;j++)   //标准模块
            for(int i=0;i<=j;i++){
                if(i==j || (s.charAt(i)==s.charAt(j)&& (i+1>=j-1 || dp[i+1][j-1] )  ) )
                    dp[i][j] = true;
                if( dp[i][j]&& j-i+1>res.length())
                    res = s.substring(i,j+1);
            }
        return res;
    }

    public static void main(String args[]) {
        System.out.println(new Solution().longestPalindrome( "cbbd"));//"cbbd"
    }
}