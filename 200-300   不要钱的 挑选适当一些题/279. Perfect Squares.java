import java.util.*;
class Solution {
	//动态规划，没得想
    public int numSquares(int n) {
        if(n<=3)
            return n;
        int dp[] =new int[n+1];
        dp[1] = 1; dp[2]=2;dp[3] =3;
        for(int i=4;i<=n;i++){
            if((int)Math.sqrt(i) * (int)Math.sqrt(i) == i){
                dp[i] = 1;
                continue;
            }
            dp[i] = Integer.MAX_VALUE;
            for(int j=1;j<i;j++){
                dp[i] = Math.min(dp[i],  dp[j] + dp[i-j]);
            }
        }
        return dp[n];
    }
    public static void main(String args[]){
        int n=10;
        System.out.println(n +"   :" +  new Solution().numSquares(n));
        for(int i=1;i<=20;i++)
            System.out.println(i+"   :" +  new Solution().numSquares(i));
    }
}