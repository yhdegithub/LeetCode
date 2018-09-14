//  2^k== n  ,那么 k * log2 == log n    ,即可求出 k ,也可位运算
class Solution {
    public boolean isPowerOfTwo(int n) {
       if(n<=0)  return false; 
        return ( n&(n-1) )==0; 
    }
}