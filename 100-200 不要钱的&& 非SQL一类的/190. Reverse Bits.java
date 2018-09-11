import java.util.*;
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
      //这道题因为java中int都是有符号的 ，所以不能用库函数 ， 否则某些用例通不过 ， 比如 1 对应 Integre,MAX_VALUE + 1;
      int res = 0;
        for(int i=0;i<32;i++){

           res = res | ((n>>i)&1) <<(31-i) ;
      }
    return res;

    }
    public static void main(String args[]){
        System.out.println(new Solution().reverseBits(43261596)); //964176192
        System.out.println(new Solution().reverseBits(1)); //964176192


    }
}