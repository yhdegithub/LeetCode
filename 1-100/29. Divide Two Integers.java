import java.util.*;
//这道题最好要用long的类型，毕竟考虑到int溢出的问题
class Solution {
    public int divide(int c, int d) {
        int sign = 1;
        if ((c > 0 && d < 0) || (c < 0 && d > 0))
            sign = -1;
        long a =(long) Math.abs((long)c);
        long  b =(long) Math.abs((long)d);
        if (a < b) return 0;
        long res = 0;
        long tmp = b;
        while (a >= b) {
            long t = 1;
            while (a > b + b) {   //指数增加，防止超时
                t = t + t;
                b = b + b;
            }
            a = a - b;
            res += t;
            b = tmp;
        }
        if(res*sign>Integer.MAX_VALUE)   //狗日的测试！！！
            return Integer.MAX_VALUE;
        else if(res*sign<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int)res * sign;
    }

    public static void main(String args[]) {
        int a = -2147483648;
        int b = -1;
        System.out.println(new Solution().divide(a, b));
    }
}