//剑指offer里面有详细的 ，这里不找了 ，不要用暴力
class Solution {
    public int countDigitOne(int n) {
         if(n<=0)
      return 0;
      int count=0;
      int t=n;
      int base=1;
      while(t>0){
      int weight=t%10;
      t=t/10;
      count+= t*base;
      if(weight==1)
        count+=(n%base)+1;
        else if(weight>1)
        count+=base;
        base*=10;
      
      
      }
      
      return count;
    }
    }
