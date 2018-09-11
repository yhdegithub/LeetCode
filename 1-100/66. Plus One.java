import java.math.BigInteger;
import java.util.*;
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits==null || digits.length==0)
            return new int[]{1};
        int n =digits.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
            sb.append(digits[i]);
        BigInteger t = new BigInteger(sb.toString());
        BigInteger res =  t.add(new BigInteger("1"));
        String  s = res.toString();
      int ans[] = new int[s.length()];
      for(int i=0;i<ans.length;i++)
          ans[i] = s.charAt(i)-'0';
        return ans;
    }
    public static void main(String args[]){
        int digits[]={4,9,9,9,9,9};
        new Solution().plusOne(digits);
    }
}