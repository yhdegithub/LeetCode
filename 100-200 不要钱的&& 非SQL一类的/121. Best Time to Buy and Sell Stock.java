import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<=1 )
        return 0;
        int max = 0;
        int min = prices[0];
        for(int i=0;i<prices.length;i++){
          min = Math.min(min,prices[i]);
          max = Math.max(max , prices[i] - min);
        }
        return max;
    }
}