import java.util.*;
class Solution {
    public int titleToNumber(String s) {
        if(s==null || s.length()==0)
            return 0;
        int n = s.length();
        int sum = 0;
        for(int i =0;i<n;i++){
            int cur = s.charAt(i) - 'A'+1;
            sum += cur *  (int)Math.pow(26,n-i-1);
        }
        return sum;
    }
}