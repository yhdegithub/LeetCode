import java.util.*;
class Solution {
        public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = 0x7fffffff;
            for (int j = 0; j < coins.length; j++)
                if (i >= coins[j] && dp[i - coins[j]] != 0x7fffffff)  //①
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
        return dp[amount] == 0x7fffffff ? -1 : dp[amount];
    }

}