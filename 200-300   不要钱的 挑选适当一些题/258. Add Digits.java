import java.util.*;
class Solution {
    public int addDigits(int num) {
        //就是找规律 ， 然后发现以9为一轮循环
        if(num<10)
            return num;
        return (num-1)%9 +1 ;
    }
}