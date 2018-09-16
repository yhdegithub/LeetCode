import java.util.*;
class Solution {

    public boolean isPowerOfThree(int n) {
        double x = Math.log10(n) / Math.log10(3);
        double res = x%1;
        if(Math.abs(res)<0.0000000000000000000000000000000000000000000000000001)
            return true;
           return false;
    }


    public static void main(String args[]){
        System.out.println(27 + " "+ new Solution().isPowerOfThree(27));
        for(int i=1;i<=30;i++)
        System.out.println(i+ "::" + new Solution().isPowerOfThree(i));
    }
}