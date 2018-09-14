
   import java.util.*;
    class Solution {
        public int nthUglyNumber(int n) {
            if(n<=6)
                return n;

            int i2 = 1 ;
            int i3 = 1 ;
            int i5 = 1;
            int dp[] =new int[n+1];
            dp[1] = 1;
            for(int i=2;i<=n;i++){
                int t = Math.min(Math.min(dp[i2]*2 ,dp[i3]*3) , dp[i5]*5);
                dp[i] = t;
                if(t==dp[i2]*2)
                    i2++;
                if(t==dp[i3]*3)
                    i3++;
                if(t==dp[i5]*5)
                    i5++;
            }
            return dp[n];
        }

    public static void main(String args[]){
        System.out.println(new Solution().nthUglyNumber(16));
    }
}