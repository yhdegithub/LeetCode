import java.util.*;
/**
 *    1)暴力 ， N^3也能过 
 *    2）夹逼  ，或者利用map，空间换取时间
 */
 

public class Solution {
    int res;
    public int threeSumClosest(int[] num, int target) {
        int n = num.length;
        if (n <= 2) return 0;
        Arrays.sort(num);
        res = 0;
        int dif = Integer.MAX_VALUE;
        // int dif = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            for(int j=i+1;j<n-1;j++){
                for(int k =j+1;k<n;k++){
                    int sum = num[i] +num[j] +num[k];
                    if( Math.abs(sum - target) < dif){
                        dif = Math.abs(sum - target) ;
                        res=  sum;
                    }

                }
            }

        }


        return res;
    }
}


// 法二的夹逼法


public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}