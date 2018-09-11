import java.util.*;

class Solution {


    public double pow(double x, int n) {
        long t = (long) n;
        return myPow(x,t);
    }
    public double myPow(double x,long t){
        if(t<0)
            return 1/myPow(x,-t);
        else if(x==1)
            return 1;
        else if(t==1)
            return x;
        else if(t==0)
            return 1;
        else if((t&1)==0)
            return myPow(x*x,t/2);
        else
            return x*myPow(x*x,(t-1)/2);

    }
    public static void main(String args[]) {
        double x =1.00000;
        int n = -2147483648;
        System.out.println(new Solution().pow(x,n));
    }
}