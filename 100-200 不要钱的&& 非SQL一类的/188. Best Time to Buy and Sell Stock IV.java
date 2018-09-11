/*
Input:	2, [6,1,3,2,4,7]
Output:	6
Expected:	7
*/
// 306ms
public class Solution {
    public int maxProfit(int k, int[] prices) {
 
        int n = prices.length; 
        // validate input 1
        if (k <= 0 || n == 0) return 0;
        
        // validate input 2 : if k is large enough, the question will be the same as question II.
        if (k >= n / 2) {
            int result = 0;
            for (int i = 1; i < n; ++i) {
                if (prices[i] - prices[i - 1] > 0) {
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
        int[][] localProfit = new int[n][k + 1];
        int[][] globalProfit = new int[n][k + 1];
 
        //实际上没有必要进行初始化 k = 1时候的情况，下面的nested for loop已经能够处理这个初始化了。
        // int minPrice = prices[0];
        // for (int i = 1; i < n; ++i) {
        //     localProfit[i][1]= prices[i] - minPrice;
        //     globalProfit[i][1]= Math.max(localProfit[i][1], globalProfit[i - 1][1]);
        //     if (prices[i] < minPrice) {
        //         minPrice = prices[i];
        //     }
        // }
        
        for (int j = 1; j <= k; ++j) {
            for (int i = 1; i < n; ++i) {
                localProfit[i][j]= Math.max(
                    localProfit[i - 1][j] + prices[i] - prices[i -1], 
                    globalProfit[i - 1][j - 1] + Math.max(0, prices[i] - prices[i - 1]));
                globalProfit[i][j] = Math.max(localProfit[i][j], globalProfit[i - 1][j]);
            }
        }
        return globalProfit[n - 1][k];
    }
}
