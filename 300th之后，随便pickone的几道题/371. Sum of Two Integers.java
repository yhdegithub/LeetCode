import java.util.*;
class Solution {
    public int getSum(int num1, int num2) {
       //用32次位移运算
        int res=0;
        int c=0;  //进位
        for(int i=0;i<32;i++){
            int a=(num1>>i)&1;
            int b=(num2>>i)&1;
            int d = a^b^c;
            if((a==1&&b==1)||((a==1||b==1)&&c==1) )
                c=1;
            else
                c=0;

            res = res | (d<<i);  //计算一次和呗
        }
    return res;
}
}