import java.util.*;
public class Solution {
    public int Add(int num1,int num2) {
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

            res=res|(d<<i);
        }
    return res;
    }
}




//法二

   public int Add(int num1,int num2) {
        if(num1==0)
            return num2;
        else if(num2==0)
            return num1;
        while(num2!=0){
            int t = (num1 ^ num2);
            num2 = (num1 & num2)<<1;
            num1 = t;

        }

        return num1;
    }