import java.util.*;
class Solution {
   public int trailingZeroes(int n) {
        //完全就是数学问题嘛，数论中化解为2*3*5...
        int sum =0;
        int t = 5;
        while(t<=n&&t>0&&(t%5)==0){
            int cnt = n/t;
            sum += cnt;
            t *=5;
        }
        return sum;
    }
}