import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1)
            return 0;
        int max = 0 ;   //有价格增量就记数到max一次
        int n = prices.length;
        for(int i=1;i<n;i++){
            max += ( prices[i] > prices[i-1] ) ? prices[i] - prices[i-1] : 0; 
        }
        return max;
    }
}